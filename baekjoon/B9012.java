package baekjoon;

import java.io.*;
import java.util.Stack;

public class B9012 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cycle = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		Stack<Character> stk = new Stack<>();

		lbl: while (cycle-- > 0) {
			String input = br.readLine();
			int count = 0;
			if (!input.substring(0, 1).equals("(")) {
				sb.append("NO#");
				continue;
			} else if (!input.substring(input.length() - 1).equals(")")) {
				sb.append("NO#");
				continue;
			}

			for (char c : input.toCharArray()) {
				switch (c) {
				case '(':
					stk.push('(');
					count++;
					break;
				case ')':
					stk.push(')');
					count--;
					break;
				}
			}

			if (stk.isEmpty()) {
				sb.append("NO#");
				stk.clear();
				continue;
			}

			while (!stk.isEmpty()) {
				switch (stk.pop()) {
				case ')':
					count--;
					break;
				case '(':
					count++;
					if (count > 0) {
						sb.append("NO#");
						stk.clear();
						continue lbl;
					}
					break;
				}
			}

			if (count != 0) {
				sb.append("NO#");
				stk.clear();
				continue;
			}
			
			sb.append("YES#");
			stk.clear();

		}

		for (String str : sb.toString().split("#")) {
			System.out.println(str);
		}
	}
}
