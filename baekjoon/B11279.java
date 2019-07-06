package baekjoon;

import java.util.*;
import java.io.*;

public class B11279 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tNum = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pque = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer a1, Integer a2) {
				return a1 >= a2 ? -1 : 1;
			}
		});
		
		StringBuffer sb = new StringBuffer();
		
		while (tNum-- > 0) {
			int input = Integer.parseInt(br.readLine());
			
			if (input > 0) {
				pque.add(input);
			} else {
				int tmp;
				if (pque.peek() == null)
					tmp = 0;
				else
					tmp = pque.poll();
				sb.append(tmp + "\n");
			}
		}
		
		System.out.println(sb.toString());
	}
}
