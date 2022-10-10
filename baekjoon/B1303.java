package baekjoon;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;

public class B1303 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        char[][] map = new char[M][N];
        boolean[][] visited = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            String l = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = l.charAt(j);
            }
        }

        int ourPower = 0;
        int enemyPower = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    int power = (int) Math.pow(bfs(map, visited, i, j), 2);
                    if (map[i][j] == 'W') {
                        ourPower += power;
                    } else {
                        enemyPower += power;
                    }
                }
            }
        }

        System.out.println(ourPower + " " + enemyPower);

        br.close();
    }

    private static final int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private static int bfs(char[][] map, boolean[][] visited, int sy, int sx) {
        char type = map[sy][sx];
        Queue<Integer[]> que = new ArrayDeque<>();
        int count = 0;

        que.offer(new Integer[]{sy, sx});
        visited[sy][sx] = true;
        while (!que.isEmpty()) {
            Integer[] q = que.poll();
            int y = q[0];
            int x = q[1];
            count++;

            for (int i = 0; i < 4; i++) {
                int ny = y + dir[i][0];
                int nx = x + dir[i][1];
                if (ny >= 0 && nx >= 0 && ny < map.length && nx < map[0].length
                        && map[ny][nx] == type && !visited[ny][nx]) {
                    que.offer(new Integer[]{ny, nx});
                    visited[ny][nx] = true;
                }
            }
        }

        return count;
    }
}
