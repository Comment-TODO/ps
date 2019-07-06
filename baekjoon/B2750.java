package baekjoon;

import java.util.Arrays;
import java.io.*;

public class B2750 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] list = new int[n];
		
		for (int i = 0; i < n; i++) {
			list[i] = Integer.parseInt(br.readLine());
		}
		br.close();
		Arrays.sort(list);
		
		for (int i = 0; i < n; i++) {
			System.out.println(list[i]);
		}
	}
}
