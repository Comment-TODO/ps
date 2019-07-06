package samsung;

import java.io.*;
import java.util.StringTokenizer;

class S1210 {
	static int[][] lad;
	static boolean[][] visit;
	static final int size = 100;

	static boolean checkLad(int x, int y) {
		visit[x][y] = true;
		if (lad[x][y] == 0)
			return false;
		if (lad[x][y] == 2)
			return true;
		if (y == 0)
			return false;
		
		if (x > 0 && !visit[x - 1][y] && lad[x - 1][y] == 1) {
			return checkLad(x - 1, y);
		}
		
		if (x < size - 1 && !visit[x + 1][y] && lad[x + 1][y] == 1) {
			return checkLad(x + 1, y);
		}
		
		if (checkLad(x, y - 1)) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= 10; t++) {
			br.readLine();
			// set ladder
			lad = new int[size][size];
			for (int i = 0; i < size; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < size; j++) {
					lad[j][size - 1 - i] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < size; i++) {
				visit = new boolean[size][size];
				if (checkLad(i, size - 1)) {
					sb.append("#").append(t).append(" ").append(i).append("\n");
					break;
				}
			}
		}

		System.out.print(sb.toString());
		br.close();
	}
}
