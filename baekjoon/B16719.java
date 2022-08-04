package baekjoon;

import java.io.*;

public class B16719 {
    private static StringBuilder sb = new StringBuilder();
    private static int sbIdx = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        divideAndConquer(str, 0, str.length());
    }

    private static void divideAndConquer(String s, int from, int to) {
        char min = 'Z' + 1;
        int minIdx = -1;
        for (int i = from; i < to; i++) {
            if (s.charAt(i) < min) {
                minIdx = i;
                min = s.charAt(i);
            }
        }

        int idx = sbIdx;
        sb.insert(idx, min);
        System.out.println(sb.toString());

        if (minIdx < to - 1) {
            sbIdx++;
            divideAndConquer(s, minIdx + 1, to);
        }
        if (minIdx > from) {
            divideAndConquer(s, from, minIdx);
        }
        sbIdx--;
    }
}
