package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int deadline = Integer.parseInt(br.readLine());
        int[][] consults = new int[deadline + 1][2];

        for (int i = 1; i <= deadline; i++) {
            String[] input = br.readLine().split(" ");
            consults[i][0] = Integer.parseInt(input[0]);
            consults[i][1] = Integer.parseInt(input[1]);
        }

        System.out.println(dfs(consults, 1, 0));
    }

    private static int dfs(int[][] consults, int day, int profitSum) {
        int deadline = consults.length - 1;
        if (day > deadline)
            return profitSum;
        if (day + consults[day][0] > deadline + 1)
            return dfs(consults, day + 1, profitSum);

        return Math.max(dfs(consults, day + consults[day][0], profitSum + consults[day][1]), dfs(consults, day + 1, profitSum));
    }
}
