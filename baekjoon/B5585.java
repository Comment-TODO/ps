package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class B5585 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int change = 1000 - Integer.parseInt(br.readLine());
		int coin = 0;
		int[] type = { 500, 100, 50, 10, 5, 1 };
		int typeIdx = 0;

		while (change > 0) {
			if (change >= type[typeIdx]) {
				change -= type[typeIdx];
				coin++;
			} else
				typeIdx++;
		}
		
		System.out.println(coin);
	}
}
