package baekjoon;

import java.util.Scanner;

public class B15988 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		long[] result = new long[testCase];
		int input = 0;

		for (int i = 0; i < testCase; i++) {
			input = sc.nextInt();
			if (input == 1) {
				result[i] = 1;
				continue;
			} else if (input == 2) {
				result[i] = 2;
				continue;
			} else if (input == 3) {
				result[i] = 4;
				continue;
			}
			long[] tmp = new long[input];

			tmp[0] = 1;
			tmp[1] = 2;
			tmp[2] = 4;

			for (int j = 3; j < input; j++) {
				tmp[j] = tmp[j - 2] % 1000000009 + tmp[j - 1] % 1000000009 + tmp[j - 3] % 1000000009;
			}

			result[i] = tmp[input - 1];
		}

		sc.close();

		for (int i = 0; i < testCase; i++) {
			System.out.println(result[i] % 1000000009);
		}
	}
}