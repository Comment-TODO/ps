package baekjoon;

import java.io.*;
import java.util.*;

public class B1012 {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int testCase = 0; testCase < T; testCase++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(token.nextToken());
            int N = Integer.parseInt(token.nextToken());
            int K = Integer.parseInt(token.nextToken());
            boolean[][] map = new boolean[N][M];
            boolean[][] visited = new boolean[N][M];

            for (int i = 0; i < K; i++) {
                token = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(token.nextToken());
                int Y = Integer.parseInt(token.nextToken());
                map[Y][X] = true;
            }

            int count = 0;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (map[j][k] && !visited[j][k]) {
                        bfs(map, visited, j, k);
                        count++;
                    }
                }
            }

            sb.append(count).append("\n");
        }
        System.out.print(sb);
        br.close();
    }

    private static final int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private static void bfs(boolean[][] map, boolean[][] visited, int y, int x) {
        Queue<int[]> que = new ArrayDeque<>();
        visited[y][x] = true;
        que.offer(new int[]{y, x});

        while (!que.isEmpty()) {
            int[] p = que.poll();

            for (int i = 0; i < 4; i++) {
                int nY = p[0] + dir[i][0];
                int nX = p[1] + dir[i][1];

                if (nY >= 0 && nY < map.length && nX >= 0 && nX < map[0].length && map[nY][nX] && !visited[nY][nX]) {
                    visited[nY][nX] = true;
                    que.offer(new int[]{nY, nX});
                }
            }
        }
    }
}
