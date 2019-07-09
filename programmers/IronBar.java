package programmers;

import java.util.ArrayList;
import java.io.InputStreamReader;

class IronBar {
	private static int panel = 0;
	private static int count = 0;
	
	public static void main(String[] args) throws Exception {
		
		ArrayList<Character> stack = new ArrayList<Character>();
		InputStreamReader in = new InputStreamReader(System.in);
		
		// 입력
		int tmp;
		while ((tmp = in.read()) != 13) {
			stack.add((char)tmp);
		}
		
		// 레이저를 0으로 표기
		for (int i = 0; i < stack.size() - 1; i++) {
			if (stack.get(i) == '(' && stack.get(i + 1) == ')') {
				stack.remove(i);
				stack.remove(i);
				stack.add(i, '0');
			}
		}
		
		for (int i = 0; i < stack.size(); i++) {
			if (stack.get(i) != '0') {
				setPanel(stack.get(i));	
			} else {
				count += panel;
			}
		}	
		
		System.out.println(count);

	}
	
	private static void setPanel(char chr) {
		if (chr == '(') panel++;
		if (chr == ')') {
			count++;
			panel--;
		}
	}
}
