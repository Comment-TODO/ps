import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class B2667 {
    private static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());
        int[][] map = new int[N][N];
        boolean[][] checked = new boolean[N][N];
        List<Integer> householdList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String line = reader.readLine();
            for (int j = 0; j < line.length(); j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int household = bfs(map, checked, j, i);
                if (household > 0)
                    householdList.add(household);
            }
        }

        Collections.sort(householdList);

        System.out.println(count);
        for (int i = 0; i < householdList.size(); i++) {
            System.out.println(householdList.get(i));
        }
    }

    private static int bfs(int[][] map, boolean[][] checked, int currX, int currY) {
        if (checked[currY][currX] || map[currY][currX] == 0)
            return 0;

        int house = 0;
        Queue<Integer> xQue = new LinkedList<>();
        Queue<Integer> yQue = new LinkedList<>();

        xQue.offer(currX);
        yQue.offer(currY);
        checked[currY][currX] = true;

        while (!xQue.isEmpty()) {
            int x = xQue.poll();
            int y = yQue.poll();
            house++;

            if (x + 1 < map[0].length && !checked[y][x + 1] && map[y][x + 1] == 1) {
                xQue.offer(x + 1);
                yQue.offer(y);
                checked[y][x + 1] = true;
            }
            if (x - 1 >= 0 && !checked[y][x - 1] && map[y][x - 1] == 1) {
                xQue.offer(x - 1);
                yQue.offer(y);
                checked[y][x - 1] = true;
            }
            if (y - 1 >= 0 && !checked[y - 1][x] && map[y - 1][x] == 1) {
                xQue.offer(x);
                yQue.offer(y - 1);
                checked[y - 1][x] = true;
            }
            if (y + 1 < map.length && !checked[y + 1][x] && map[y + 1][x] == 1) {
                xQue.offer(x);
                yQue.offer(y + 1);
                checked[y + 1][x] = true;
            }
        }

        count++;
        return house;
    }
}
