package baekjoon;

import java.util.Scanner;

public class B2231 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		sc.close();
		boolean is = false;

		for (int i = 1; i < input; i++) {
			if (getResult(i) == input) {
				is = true;
				System.out.println(i);
				break;
			}
		}
		if (!is) {
			System.out.println(0);
		}
	}

	private static int getResult(int input) {
		int cipher = getCipher(input);
		int sum = input;

		if (input < 10)
			return sum * 2;

		for (; cipher > 0; cipher--) {
			sum += input / square(cipher);
			input %= square(cipher);
		}

		return sum;
	}

	private static int square(int cipher) {
		int result = 1;
		for (int i = cipher - 1; i > 0; i--) {
			result *= 10;
		}
		return result;
	}

	private static int getCipher(int num) {
		int count = 1;
		while (num >= 10) {
			num /= 10;
			count++;
		}
		return count;
	}
}
