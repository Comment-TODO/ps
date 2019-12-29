package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14499 {
    private static StringBuffer buffer = new StringBuffer();
    private static int currX, currY;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(reader.readLine());
        int height = Integer.parseInt(token.nextToken());
        int width = Integer.parseInt(token.nextToken());
        currY = Integer.parseInt(token.nextToken());
        currX = Integer.parseInt(token.nextToken());
        int cmdCount = Integer.parseInt(token.nextToken());
        int[][] map = new int[height][width];
        int[] dice = new int[6];
        /*
          2
        4 1 3
          5
          6
         */

        for (int i = 0; i < height; i++) {
            token = new StringTokenizer(reader.readLine());
            int tokenCount = token.countTokens();
            for (int j = 0; j < tokenCount; j++) {
                map[i][j] = Integer.parseInt(token.nextToken());
            }
        }
        token = new StringTokenizer(reader.readLine());
        while (token.hasMoreTokens()) {
            move(map, Integer.parseInt(token.nextToken()), dice);
        }

        if (buffer.length() > 1)
            buffer.deleteCharAt(buffer.length() - 1);
        System.out.println(buffer.toString());
    }

    private static void copyDice(int[][] map, int[] dice) {
        if (map[currY][currX] == 0)
            map[currY][currX] = dice[5];
        else {
            dice[5] = map[currY][currX];
            map[currY][currX] = 0;
        }
    }

    private static void move(int[][] map, int cmd, int[] dice) {
        boolean inMap = false;
        switch (cmd) {
            case 1: // East
                if (currX + 1 < map[0].length) {
                    inMap = true;
                    currX++;
                    int tmp = dice[0];
                    dice[0] = dice[3];
                    dice[3] = dice[5];
                    dice[5] = dice[2];
                    dice[2] = tmp;
                }
                break;
            case 2: // West
                if (currX - 1 >= 0) {
                    inMap = true;
                    currX--;
                    int tmp = dice[0];
                    dice[0] = dice[2];
                    dice[2] = dice[5];
                    dice[5] = dice[3];
                    dice[3] = tmp;
                }
                break;
            case 3: // North
                if (currY - 1 >= 0) {
                    inMap = true;
                    currY--;
                    int tmp = dice[0];
                    dice[0] = dice[4];
                    dice[4] = dice[5];
                    dice[5] = dice[1];
                    dice[1] = tmp;
                }
                break;
            case 4: // South
                if (currY + 1 < map.length) {
                    inMap = true;
                    currY++;
                    int tmp = dice[0];
                    dice[0] = dice[1];
                    dice[1] = dice[5];
                    dice[5] = dice[4];
                    dice[4] = tmp;
                }
                break;
        }
        if (inMap) {
            copyDice(map, dice);
            buffer.append(dice[0]).append('\n');
        }
    }
}
