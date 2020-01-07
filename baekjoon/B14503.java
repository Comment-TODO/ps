package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B14503 {
    private static int robot_y;
    private static int robot_x;
    private static int robotDir;
    private static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};    // 북, 동, 남, 서
    private static int width;
    private static int height;
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        height = Integer.parseInt(input[0]);
        width = Integer.parseInt(input[1]);
        map = new int[height][width];
        int cleanCount = 0;

        input = br.readLine().split(" ");
        robot_y = Integer.parseInt(input[0]);
        robot_x = Integer.parseInt(input[1]);
        robotDir = Integer.parseInt(input[2]);  // 로봇 방향

        for (int i = 0; i < height; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < width; j++)
                map[i][j] = Integer.parseInt(input[j]);
        }
        br.close();

        while (true) {
            if (map[robot_y][robot_x] == 0) {
                map[robot_y][robot_x] = 2;  // 청소
                cleanCount++;
            }

            if (!isCleannable(robot_y, robot_x, 0) && !isCleannable(robot_y, robot_x, 1)
                    && !isCleannable(robot_y, robot_x, 2) && !isCleannable(robot_y, robot_x, 3)) {
                int back_y = robot_y + dir[spinLeft(spinLeft(robotDir))][0];
                int back_x = robot_x + dir[spinLeft(spinLeft(robotDir))][1];
                if (back_y >= 0 && back_y < height && back_x >= 0 && back_x < width && map[back_y][back_x] != 1) {
                    robot_y = back_y;
                    robot_x = back_x;
                    continue;
                } else {
                    break;
                }
            } else if (isCleannable(robot_y, robot_x, spinLeft(robotDir))) {
                robot_y += dir[spinLeft(robotDir)][0];
                robot_x += dir[spinLeft(robotDir)][1];
            }
            robotDir = spinLeft(robotDir);
            continue;
        }

        System.out.println(cleanCount);
    }

    private static int spinLeft(int curr) {
        return curr - 1 < 0 ? 3 : curr - 1;
    }

    private static boolean isCleannable(int y, int x, int cp) {
        int next_y = y + dir[cp][0];
        int next_x = x + dir[cp][1];
        return (next_y > 0 && next_x > 0 && next_y < height && next_x < width && map[next_y][next_x] == 0);
    }
}
