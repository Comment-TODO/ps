package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class B14888 {
    private static int numSize;
    private static int[] nums;
    private static Set<Integer> resultSet = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        numSize = Integer.parseInt(br.readLine());

        nums = new int[numSize];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < numSize; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }

        int[] arithmetics = new int[4];
        input = br.readLine().split(" ");
        br.close();
        for (int i = 0; i < 4; i++) {
            arithmetics[i] = Integer.parseInt(input[i]);
        }

        for (int i = 0; i < 4; i++) {
            if (arithmetics[i] > 0) {
                dfs(2, nums[0], arithmetics);
            }
        }
        int max = resultSet.stream().max(Integer::compareTo).get();
        int min = resultSet.stream().min(Integer::compareTo).get();

        System.out.println(max);
        System.out.println(min);
    }

    private static int calc(int num1, int arithmetic, int num2) {
        switch (arithmetic) {
            case 0:   // +
                return num1 + num2;
            case 1:   // -
                return num1 - num2;
            case 2:   // *
                return num1 * num2;
            case 3:   // /
                return num1 > 0 ? (num1 / num2) : -(-num1 / num2);
        }
        return 0;
    }

    private static void dfs(int cursor, int result, int[] arithmetics) {
        if (cursor > numSize) {
            resultSet.add(result);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (arithmetics[i] > 0) {
                arithmetics[i]--;
                dfs(cursor + 1, calc(result, i, nums[cursor - 1]), arithmetics);
                arithmetics[i]++;
            }
        }
    }
}
