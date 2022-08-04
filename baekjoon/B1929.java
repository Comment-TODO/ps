package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class B1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(token.nextToken());
        int N = Integer.parseInt(token.nextToken());
        boolean[] dp = new boolean[N + 1];
        dp[1] = true;

        for (int i = 2; i * i <= N; i++) {
            if (!dp[i]) {
                for (int j = i + i; j <= N; j += i) {
                    dp[j] = true;
                }
            }
        }

        for (int i = M; i <= N; i++) {
            if (!dp[i]) System.out.println(i);
        }

        br.close();
    }
}
