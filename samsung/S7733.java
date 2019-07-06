package samsung;

import java.io.*;
import java.util.StringTokenizer;

public class S7733 {
	static int[][] cheese;
	static boolean[][] eat;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();

		// test case
		int tcase = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tcase; t++) {
			int n = Integer.parseInt(br.readLine());
			cheese = new int[n][n];
			// set cheese info
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					cheese[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int count = 1;
			for (int day = 1; day <= 100; day++) {
				int tmp = 0;
				eat = new boolean[n][n];
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						if (cheese[i][j] <= day) {
							eat[i][j] = true;
						}
					}
				}

				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						if (dfs(eat, i, j) == 1)
							tmp++;
					}
				}
				count = Math.max(tmp, count);
			}

			sb.append("#").append(t).append(" ").append(count).append("\n");

		}
		
		System.out.print(sb.toString());
	}

	static int dfs(boolean[][] eat, int x, int y) {
		if (eat[x][y])
			return 0;

		eat[x][y] = true;
		
		if (x + 1 < eat.length)
			dfs(eat, x + 1, y);
		if (x - 1 >= 0)
			dfs(eat, x - 1, y);
		if (y + 1 < eat[0].length)
			dfs(eat, x, y + 1);
		if (y - 1 >= 0)
			dfs(eat, x, y - 1);
		return 1;
	}
}
