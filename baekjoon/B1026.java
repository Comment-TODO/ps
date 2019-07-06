package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;

public class B1026 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(br.readLine());
		ArrayList<Integer> listA = new ArrayList<Integer>();
		ArrayList<Integer> listB = new ArrayList<Integer>();
		
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		while (st.hasMoreTokens()) {
			listA.add(Integer.parseInt(st.nextToken()));
		}
		st = new StringTokenizer(br.readLine());
		while (st.hasMoreTokens()) {
			listB.add(Integer.parseInt(st.nextToken()));
		}
		
		Collections.sort(listA);
		Collections.sort(listB);
		Collections.reverse(listB);
		
		int sum = 0;
		for (int i = 0; i < size; i++) {
			sum += listA.get(i) * listB.get(i);
		}
		
		System.out.println(sum);
	}

}
