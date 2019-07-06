package samsung;

import java.io.*;
import java.util.*;

public class S5658 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();

		int test_case = Integer.parseInt(br.readLine());

		for(int p = 1; p <= test_case; p++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int[] treasure = new int[n];
			TreeSet<Integer> num = new TreeSet<Integer>();

			String input = br.readLine();
			for (int i = 0; i < n; i++) {
				treasure[i] = toDecimal(input.charAt(i));
			}

			for (int t = 0; t < n; t++) {
				for (int i = t; i < n + t; i += n / 4) {
					int tmp = 0;
					for (int j = 0; j < n / 4; j++) {
						tmp += treasure[(i + j) % n] * Math.pow(16, n / 4 - 1 - j);
					}
					num.add(tmp);
				}
			}

			for (int i = 0; i < k - 1; i++) {
				num.pollLast();
			}
			
			sb.append("#" + p).append(" ").append(num.pollLast()).append("\n");
		}
		
		System.out.println(sb.toString());
	}

	static int toDecimal(char chr) {
		switch (chr) {
		case 'A':
			return 10;
		case 'B':
			return 11;
		case 'C':
			return 12;
		case 'D':
			return 13;
		case 'E':
			return 14;
		case 'F':
			return 15;
		default:
			return (chr - 48);
		}
	}
}
