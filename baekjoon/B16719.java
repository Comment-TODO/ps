package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B16719 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		char[] chr = new char[input.length()];
		char[] chr2 = new char[input.length()];

		for (int i = 0; i < input.length(); i++) {
			chr[i] = input.charAt(i);
			chr2[i] = '\\';
		}

		int[] lastIdx = new int[chr.length];

		lbl: for (int i = 65; i <= 90; i++) {
			for (int j = 0; j < chr.length; j++) {
				if ((char) i == chr[j]) {
					chr2[j] = (char) i;
					chr[j] = 0;
					lastIdx[0] = j;
					break lbl;
				}
			}
		}
		
	}
}