package baekjoon;

import java.util.Stack;
import java.io.*;

public class B10828 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stk = new Stack<>();
		
		int cmdNum = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < cmdNum; i++) {
			String cmd = br.readLine();
			
			if (cmd.startsWith("push")) {
				stk.push(Integer.parseInt(cmd.substring(5, cmd.length())));
			} else if (cmd.startsWith("pop")) {
				System.out.println(stk.empty() ? -1 : stk.pop());
			} else if (cmd.startsWith("size")) {
				System.out.println(stk.size());
			} else if (cmd.startsWith("empty")) {
				System.out.println(stk.empty() ? 1 : 0);
			} else if (cmd.startsWith("top")) {
				System.out.println(stk.empty() ? -1 : stk.peek());
			}
		}
		
		br.close();
	}
}
