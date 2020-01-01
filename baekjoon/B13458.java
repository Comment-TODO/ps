package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class B13458 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testRoom = Integer.parseInt(reader.readLine());
        String[] input = reader.readLine().split(" ");
        int[] rooms = new int[input.length];
        for (int i = 0; i < rooms.length; i++) {
            rooms[i] = Integer.parseInt(input[i]);
        }
        input = reader.readLine().split(" ");
        int priViewerCoverage = Integer.parseInt(input[0]);
        int secViewerCoverage = Integer.parseInt(input[1]);
        // BigInteger가 아닌 long으로도 가능
        BigInteger count = new BigInteger(String.valueOf(testRoom));

        for (int i = 0; i < testRoom; i++) {
            if (rooms[i] > priViewerCoverage) {
                rooms[i] -= priViewerCoverage;
                count = count.add(new BigInteger(String.valueOf((int) (Math.ceil(rooms[i] / (double) secViewerCoverage)))));
            }
        }

        System.out.println(count);
    }
}
