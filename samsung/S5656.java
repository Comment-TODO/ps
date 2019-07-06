package samsung;

import java.io.*;
import java.util.StringTokenizer;

public class S5656 {
	static int[][] block;
	static int[][] block_origin;
	static int leftBlock;

	static void init() {
		for (int i = 0; i < block_origin.length; i++) {
			for (int j = 0; j < block_origin[0].length; j++)
				block[i][j] = block_origin[i][j];
		}
	}

	static void boom(int x, int y) {
		int fire = block[x][y];
		if (fire <= 0)
			return;
		block[x][y] *= -1;
		// boom!
		for (int i = 1; i < fire; i++) {
			if (x + i < block.length) {
				boom(x + i, y);
			}
			if (x - i >= 0) {
				boom(x - i, y);
			}
			if (y + i < block[0].length) {
				boom(x, y + i);
			}
			if (y - i >= 0) {
				boom(x, y - i);
			}
		}
	}

	static void afterBoom() {
		// block = 0 when be boomed
		for (int i = 0; i < block.length; i++) {
			for (int j = 0; j < block[0].length; j++) {
				if (block[i][j] < 0)
					block[i][j] = 0;
			}
		}

		// re-order blocks
		for (int i = 0; i < block.length; i++) {
			for (int j = 0; j < block[0].length - 1; j++) {
				if (block[i][j] == 0) {
					for (int k = j + 1; k < block[0].length; k++) {
						if (block[i][k] > 0) {
							block[i][j] = block[i][k];
							block[i][k] = 0;
							break;
						}
					}
				}
			}
		}
	}

	static int topY(int x) {
		for (int y = block[0].length - 1; y >= 0; y--) {
			if (block[x][y] > 0) {
				return y;
			}
		}
		return 0;
	}

	static void countBlock() {
		int count = 0;
		for (int i = 0; i < block.length; i++) {
			for (int j = 0; j < block[0].length; j++) {
				if (block[i][j] > 0)
					count++;
			}
		}
		if (leftBlock > count)
			leftBlock = count;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int T = Integer.parseInt(buff.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(buff.readLine());
			int N = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			int H = Integer.parseInt(st.nextToken());
			// block conform
			block = new int[W][H];
			block_origin = new int[W][H];
			for (int i = H - 1; i >= 0; i--) {
				st = new StringTokenizer(buff.readLine());
				leftBlock = 999999999;
				for (int j = 0; j < W; j++) {
					block_origin[j][i] = Integer.parseInt(st.nextToken());
				}
			}

			// permutation
			int[] foo = new int[4];
			out: for (foo[0] = 0; foo[0] < W; foo[0]++) {
				for (foo[1] = 0; foo[1] < W; foo[1]++) {
					for (foo[2] = 0; foo[2] < W; foo[2]++) {
						for (foo[3] = 0; foo[3] < W; foo[3]++) {
							init();
							for (int i = 0; i < N; i++) {
								boom(foo[i], topY(foo[i]));
								afterBoom();
							}
							countBlock();
							if (leftBlock == 0)
								break out;

							if (N < 4)
								break;
						}
						if (N < 3)
							break;
					}
					if (N < 2)
						break;
				}
			}

			System.out.printf("#%d %d\n", t, leftBlock);
		}
	}
}
