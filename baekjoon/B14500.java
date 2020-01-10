package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B14500 {
    private static int height;
    private static int width;
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        height = Integer.parseInt(input[0]);
        width = Integer.parseInt(input[1]);
        map = new int[height][width];

        for (int i = 0; i < height; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < width; j++)
                map[i][j] = Integer.parseInt(input[j]);
        }

        System.out.println(tetroSum(0, 0, 0));
    }

    private static int tetroSum(int y, int x, int count) {
        // shape 1-1
        if (x + 3 < width) {
            count = Math.max(count, map[y][x] + map[y][x + 1] + map[y][x + 2] + map[y][x + 3]);
        }

        // shape 1-2
        if (y + 3 < height) {
            count = Math.max(count, map[y][x] + map[y + 1][x] + map[y + 2][x] + map[y + 3][x]);
        }

        // shape 2
        if (x + 1 < width && y + 1 < height) {
            count = Math.max(count, map[y][x] + map[y][x + 1] + map[y + 1][x] + map[y + 1][x + 1]);
        }

        // shape 3-1,2,3,4
        if (x + 1 < width && y + 2 < height) {
            count = Math.max(count, map[y][x] + map[y + 1][x] + map[y + 2][x] + map[y + 2][x + 1]);
            count = Math.max(count, map[y][x + 1] + map[y + 1][x + 1] + map[y + 2][x + 1] + map[y + 2][x]);
            count = Math.max(count, map[y][x] + map[y + 1][x] + map[y + 2][x] + map[y][x + 1]);
            count = Math.max(count, map[y][x] + map[y][x + 1] + map[y + 1][x + 1] + map[y + 2][x + 1]);
        }

        // shape 3-5,6,7,8
        if (x + 2 < width && y + 1 < height) {
            count = Math.max(count, map[y][x] + map[y][x + 1] + map[y][x + 2] + map[y + 1][x]);
            count = Math.max(count, map[y][x] + map[y][x + 1] + map[y][x + 2] + map[y + 1][x + 2]);
            count = Math.max(count, map[y][x] + map[y + 1][x] + map[y + 1][x + 1] + map[y + 1][x + 2]);
            count = Math.max(count, map[y + 1][x] + map[y + 1][x + 1] + map[y + 1][x + 2] + map[y][x + 2]);
        }

        // shape 4-1,2
        if (x + 1 < width && y + 2 < height) {
            count = Math.max(count, map[y][x] + map[y + 1][x] + map[y + 1][x + 1] + map[y + 2][x + 1]);
            count = Math.max(count, map[y][x + 1] + map[y + 1][x] + map[y + 1][x + 1] + map[y + 2][x]);
        }

        // shape 4-3,4
        if (x + 2 < width && y + 1 < height) {
            count = Math.max(count, map[y][x + 1] + map[y][x + 2] + map[y + 1][x] + map[y + 1][x + 1]);
            count = Math.max(count, map[y][x] + map[y][x + 1] + map[y + 1][x + 1] + map[y + 1][x + 2]);
        }

        // shape 5-1,2
        if (x + 2 < width && y + 1 < height) {
            count = Math.max(count, map[y][x] + map[y][x + 1] + map[y][x + 2] + map[y + 1][x + 1]);
            count = Math.max(count, map[y][x + 1] + map[y + 1][x] + map[y + 1][x + 1] + map[y + 1][x + 2]);
        }

        // shape 5-3,4
        if (x + 1 < width && y + 2 < height) {
            count = Math.max(count, map[y][x] + map[y + 1][x] + map[y + 2][x] + map[y + 1][x + 1]);
            count = Math.max(count, map[y][x + 1] + map[y + 1][x] + map[y + 1][x + 1] + map[y + 2][x + 1]);
        }

        if (x == width - 1 && y == height - 1) {
            return count;
        } else if (x == width - 1) {
            return tetroSum(y + 1, 0, count);
        } else {
            return tetroSum(y, x + 1, count);
        }
    }
}
