package baekjoon;

import java.util.Scanner;
import java.util.Arrays;

public class B2309 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] inputNum = new int[9];
		int sum = 0;
		for (int i = 0; i < 9; i++) {
			inputNum[i] = sc.nextInt();
			sum += inputNum[i];
		}
		sc.close();

		floop: for (int i = 0; i < 8; i++) {
			for (int j = i + 1; j < 9; j++) {
				if (sum - inputNum[i] - inputNum[j] == 100) {
					inputNum[i] = inputNum[j] = 0;
					break floop;
				}
			}
		}

		Arrays.sort(inputNum);

		for (int i = 2; i < 9; i++) {
			System.out.println(inputNum[i]);
		}
	}
}
