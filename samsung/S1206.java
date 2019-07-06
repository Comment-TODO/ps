package samsung;

import java.io.*;
import java.util.StringTokenizer;

public class S1206 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int test_case = 1; test_case <= 10; test_case++) {

			int[][] building = new int[Integer.parseInt(br.readLine())][255];
			StringTokenizer token = new StringTokenizer(br.readLine());

			for (int i = 0; i < building.length; i++) {
				int height = Integer.parseInt(token.nextToken());
				for (int j = 0; j < height; j++) {
					building[i][j] = 1;
				}
			}

			int count = 0;

			for (int i = 2; i < building.length - 2; i++) {
				for (int j = 0; j < building[0].length; j++) {
					if (building[i][j] == 0)
						break;

					if (building[i - 1][j] == 0 && building[i + 1][j] == 0)
						if (building[i - 2][j] == 0 && building[i + 2][j] == 0)
							count++;
				}
			}
			sb.append("#").append(test_case).append(" ").append(count).append("\n");
		}
		
		System.out.print(sb.toString());
		br.close();
	}
}