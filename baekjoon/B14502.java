package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B14502 {
    private static boolean[][] infected;
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        int height = Integer.parseInt(input[0]);
        int width = Integer.parseInt(input[1]);
        map = new int[height][width];
        infected = new boolean[height][width];

        for (int i = 0; i < height; i++) {
            input = reader.readLine().split(" ");
            for (int j = 0; j < width; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        int result = 0;
        int mul = height * width;
        for (int i = 0; i < mul - 2; i++) {
            if (map[i / width][i % width] != 0)
                continue;
            map[i / width][i % width] = 1;

            for (int j = i + 1; j < mul - 1; j++) {
                if (map[j / width][j % width] != 0)
                    continue;
                map[j / width][j % width] = 1;

                for (int k = j + 1; k < mul; k++) {
                    if (map[k / width][k % width] != 0)
                        continue;
                    map[k / width][k % width] = 1;
                    spreadVirus();
                    result = Math.max(countSafety(), result);
                    map[k / width][k % width] = 0;
                }
                map[j / width][j % width] = 0;
            }
            map[i / width][i % width] = 0;
        }

        System.out.println(result);
    }

    private static void spreadVirus() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 2) {
                    spreadBFS(i, j);
                }
            }
        }
    }

    private static void spreadBFS(int y, int x) {
        Queue<Integer> x_que = new LinkedList<>();
        Queue<Integer> y_que = new LinkedList<>();
        x_que.offer(x);
        y_que.offer(y);

        while (!x_que.isEmpty()) {
            x = x_que.poll();
            y = y_que.poll();

            if (x - 1 >= 0 && map[y][x - 1] == 0 && !infected[y][x - 1]) {
                x_que.offer(x - 1);
                y_que.offer(y);
                infected[y][x - 1] = true;
            }
            if (x + 1 < map[0].length && map[y][x + 1] == 0 && !infected[y][x + 1]) {
                x_que.offer(x + 1);
                y_que.offer(y);
                infected[y][x + 1] = true;
            }
            if (y - 1 >= 0 && map[y - 1][x] == 0 && !infected[y - 1][x]) {
                x_que.offer(x);
                y_que.offer(y - 1);
                infected[y - 1][x] = true;
            }
            if (y + 1 < map.length && map[y + 1][x] == 0 && !infected[y + 1][x]) {
                x_que.offer(x);
                y_que.offer(y + 1);
                infected[y + 1][x] = true;
            }
        }
    }

    private static int countSafety() {
        int count = 0;
        for (int i = 0; i < infected.length; i++) {
            for (int j = 0; j < infected[0].length; j++) {
                if (!infected[i][j] && map[i][j] == 0) count++;
                infected[i][j] = false;
            }
        }
        return count;
    }

}
