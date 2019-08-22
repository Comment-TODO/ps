package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class B10610 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();
		boolean hasZero = false;
		int digitSum = 0;

		for (int i = 0; i < input.length(); i++) {
			int digit = input.charAt(i) - '0';
			if (digit == 0) {
				hasZero = true;
			}

			digitSum += digit;
		}

		if (hasZero && digitSum % 3 == 0) {
			char[] chr = input.toCharArray();
			Arrays.sort(chr);
			StringBuilder sb = new StringBuilder(new String(chr));
			System.out.println(sb.reverse().toString());
		} else {
			System.out.println(-1);
		}

	}
}
