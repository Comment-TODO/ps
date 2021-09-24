import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
    int x, y, time;

    public Point(int y, int x, int time) {
        this.x = x;
        this.y = y;
        this.time = time;
    }
}

public class B3055 {
    final static int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token;
        Queue<Point> waterQue = new ArrayDeque();
        Queue<Point> hedgehogQue = new ArrayDeque();
        int time = 0;

        token = new StringTokenizer(buffer.readLine());
        int R = Integer.parseInt(token.nextToken());
        int C = Integer.parseInt(token.nextToken());

        char[][] map = new char[R][C];
        boolean[][] visited = new boolean[R][C];
        boolean[][] waterVisited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String line = buffer.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == '*') {
                    waterQue.offer(new Point(i, j, 0));
                    waterVisited[i][j] = true;
                } else if (map[i][j] == 'S') {
                    hedgehogQue.offer(new Point(i, j, 0));
                    visited[i][j] = true;
                    map[i][j] = '.';
                }
            }
        }

        while (!hedgehogQue.isEmpty()) {
            Point hedgehogPoint = hedgehogQue.poll();
            if (time < hedgehogPoint.time) {
                time = hedgehogPoint.time;
            }

            while (!waterQue.isEmpty()) {
                Point waterPoint = waterQue.peek();
                if (waterPoint.time > time) break;
                waterPoint = waterQue.poll();
                map[waterPoint.y][waterPoint.x] = '*';
                for (int[] direction : directions) {
                    if (waterPoint.y + direction[0] < 0
                            || waterPoint.y + direction[0] >= map.length
                            || waterPoint.x + direction[1] < 0
                            || waterPoint.x + direction[1] >= map[0].length)
                        continue;

                    char next = map[waterPoint.y + direction[0]][waterPoint.x + direction[1]];

                    if (next == '.' && !waterVisited[waterPoint.y + direction[0]][waterPoint.x + direction[1]]) {
                        waterQue.offer(new Point(waterPoint.y + direction[0], waterPoint.x + direction[1], time + 1));
                        waterVisited[waterPoint.y + direction[0]][waterPoint.x + direction[1]] = true;
                    }
                }
            }

            if (map[hedgehogPoint.y][hedgehogPoint.x] == '*') continue;

            for (int[] direction : directions) {
                if (hedgehogPoint.y + direction[0] < 0
                        || hedgehogPoint.y + direction[0] >= map.length
                        || hedgehogPoint.x + direction[1] < 0
                        || hedgehogPoint.x + direction[1] >= map[0].length)
                    continue;

                char next = map[hedgehogPoint.y + direction[0]][hedgehogPoint.x + direction[1]];

                if (next == '.' && !visited[hedgehogPoint.y + direction[0]][hedgehogPoint.x + direction[1]]) {
                    hedgehogQue.offer(new Point(hedgehogPoint.y + direction[0], hedgehogPoint.x + direction[1], hedgehogPoint.time + 1));
                    visited[hedgehogPoint.y + direction[0]][hedgehogPoint.x + direction[1]] = true;
                } else if (next == 'D') {
                    System.out.println(hedgehogPoint.time + 1);
                    return;
                }
            }
        }

        System.out.println("KAKTUS");
    }
}
