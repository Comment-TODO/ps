package baekjoon;

import java.io.*;

public class B1003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        int[] zeroDp = new int[41];
        int[] oneDp = new int[41];

        zeroDp[0] = 1;
        oneDp[1] = 1;
        for (int i = 2; i <= 40; i++) {
            zeroDp[i] = zeroDp[i - 2] + zeroDp[i - 1];
            oneDp[i] = oneDp[i - 2] + oneDp[i - 1];
        }

        for (int i = 0; i < T; i++) {
            int t = Integer.parseInt(br.readLine());
            bw.write(zeroDp[t] + " " + oneDp[t] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
