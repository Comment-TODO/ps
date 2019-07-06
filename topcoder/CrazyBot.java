package topcoder;

public class CrazyBot {
	static int count = 0;

	double getProbability(int n, int east, int west, int south, int north) {
		boolean[][] map = new boolean[2 * n + 1][2 * n + 1];
		map[n][n] = true;

		move(n, east, west, south, north, n, n, map);

		return count;
	}
	
	public static void main(String[] args) {
		CrazyBot cb = new CrazyBot();
		System.out.println(cb.getProbability(1, 25, 25, 25, 25));
	}

	static boolean move(int n, int east, int west, int south, int north, int x, int y, boolean[][] arr) {
		boolean[][] map = arr.clone();

		if (east > 0 && x < 2 * n) {
			if (map[x + 1][y]) {
				return false;
			} else {
				map[x + 1][y] = true;
				move(n, east - 1, west, south, north, x + 1, y, map);
				System.out.println("e");
			}
		}
		if (west > 0 && x > 0) {
			if (map[x - 1][y]) {
				return false;
			} else {
				map[x - 1][y] = true;
				move(n, east, west - 1, south, north, x - 1, y, map);
				System.out.println("w");
			}
		}
		if (north > 0 && y < 2 * n) {
			if (map[x][y + 1]) {
				return false;
			} else {
				map[x][y + 1] = true;
				move(n, east, west, south, north - 1, x, y + 1, map);
				System.out.println("n");
			}
		}
		if (south > 0 && y > 0) {
			if (map[x][y - 1]) {
				return false;
			} else {
				map[x][y - 1] = true;
				move(n, east, west, south - 1, north, x, y - 1, map);
				System.out.println("s");
			}
		}

		if (east == 0 && west == 0 && south == 0 && north == 0) {
			System.out.println("count++");
			count++;
		}
		return true;
	}
}
