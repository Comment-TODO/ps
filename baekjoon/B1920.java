package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1920 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] list = new int[n];
		String listInput = br.readLine();
		StringTokenizer st = new StringTokenizer(listInput);
		for (int i = 0; i < n; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(list);
		
		int m = Integer.parseInt(br.readLine());
		int[] checkList = new int[m];
		listInput = br.readLine();
		st = new StringTokenizer(listInput);
		for (int i = 0; i < m; i++) {
			checkList[i] = Integer.parseInt(st.nextToken());
			if (Arrays.binarySearch(list, checkList[i]) >= 0) {
				System.out.println(1);
			} else {
				System.out.println(0);
			}
		}
			

	}
}
