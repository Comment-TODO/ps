package baekjoon;

import java.io.*;

public class B1697 {
    public static void main(String[] args) throws IOException {
        final int MAX = 100000;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        int[] dp = new int[MAX + 1];

        dp[N] = 0;
        for (int i = 0; i < N; i++) {
            dp[i] = N - i;
        }

        for (int i = N + 1; i <= K + 1 && i <= MAX; i++) {
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i / 2] + 1, dp[i - 1] + 1);
                dp[i - 1] = Math.min(dp[i - 1], dp[i] + 1);
            } else {
                dp[i] = dp[i - 1] + 1;
            }
        }

        System.out.println(dp[K]);
        br.close();
    }
}
