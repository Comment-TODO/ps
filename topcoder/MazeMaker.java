package topcoder;

import java.util.LinkedList;
import java.util.Queue;

public class MazeMaker {

    public int longestPath(String[] maze, int startRow, int startCol, int[] moveRow, int[] moveCol) {
        Queue<Integer> cur_x = new LinkedList<>();
        Queue<Integer> cur_y = new LinkedList<>();
        int[][] leastVisit = new int[maze.length][maze[0].length()];

        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length(); j++) {
                leastVisit[i][j] = -1;
            }
        }

        cur_y.offer(startRow);
        cur_x.offer(startCol);
        leastVisit[startRow][startCol] = 0;

        while (!cur_x.isEmpty()) {
            for (int i = 0; i < moveRow.length; i++) {
                int nextY = moveRow[i] + cur_y.peek();
                int nextX = moveCol[i] + cur_x.peek();

                if (nextY >= 0 && nextY < maze.length &&
                        nextX >= 0 && nextX < maze[0].length() &&
                        maze[nextY].charAt(nextX) == '.' &&
                        leastVisit[nextY][nextX] == -1) {

                    leastVisit[nextY][nextX] = leastVisit[cur_y.peek()][cur_x.peek()] + 1;
                    cur_x.offer(nextX);
                    cur_y.offer(nextY);

                }
            }
            cur_x.poll();
            cur_y.poll();
        }

        int max = -1;

        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length(); j++) {
                if (leastVisit[i][j] == -1 && maze[i].charAt(j) == '.') {
                    return -1;
                }

                max = Math.max(max, leastVisit[i][j]);
            }
        }

        return max;
    }
}
