package baekjoon;

import java.io.*;
import java.util.Arrays;

public class B1427 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String strArr[] = br.readLine().split("");
		Arrays.sort(strArr);
		
		for (int i = strArr.length - 1; i >= 0; i--) {
			System.out.print(strArr[i]);
		}
	}
}
