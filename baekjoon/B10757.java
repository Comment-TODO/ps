package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B10757 {
    public static void main(String[] args) throws IOException {
        StringBuilder buffer = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        String a = tmp[0];
        String b = tmp[1];

        int aLen = a.length();
        int bLen = b.length();
        int overTen = 0;
        while (aLen > 0 || bLen > 0) {
            int sum = 0;
            if (aLen > 0) {
                sum += Character.getNumericValue(a.charAt(aLen - 1));
                aLen--;
            }
            if (bLen > 0) {
                sum += Character.getNumericValue(b.charAt(bLen - 1));
                bLen--;
            }

            if (overTen > 0) {
                sum += overTen;
            }
            overTen = sum / 10;
            buffer.append(sum % 10);
        }
        if (overTen > 0) buffer.append(overTen);

        System.out.println(buffer.reverse().toString());
    }
}
