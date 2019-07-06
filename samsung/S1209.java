package samsung;

import java.io.*;
import java.util.StringTokenizer;

class S1209 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= 10; t++) {
			int[][] arr = new int[100][100];
			br.readLine();
			int[] sum_x = new int[100];
			int[] sum_y = new int[100];
			int[] sum_c = new int[2];
			for (int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					arr[j][i] = Integer.parseInt(st.nextToken());
					sum_y[i] += arr[j][i];
				}
			}

			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					sum_x[i] += arr[i][j];
					if (i == j)
						sum_c[0] += arr[i][j];
					if (i + j == 99)
						sum_c[1] += arr[i][j];
				}
			}

			int max = -1;
			for (int i = 0; i < 100; i++) {
				if (sum_x[i] > max)
					max = sum_x[i];
				if (sum_y[i] > max)
					max = sum_y[i];
			}
			if (sum_c[0] > max)
				max = sum_c[0];
			if (sum_c[1] > max)
				max = sum_c[0];

			sb.append("#").append(t).append(" ").append(max).append("\n");
		}

		System.out.print(sb.toString());
	}
}
