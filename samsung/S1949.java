package samsung;

import java.io.*;
import java.util.StringTokenizer;

public class S1949 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer buf = new StringBuffer();
		StringTokenizer st = null;
		int tCase = Integer.parseInt(br.readLine());

		for (int curCase = 1; curCase <= tCase; curCase++) {
			buf.append("#").append(curCase).append(" ");
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			// mapping
			int[][] map = new int[N][N];
			boolean[][] visited = new boolean[N][N];
			int max = 0;
			int[][] max_idx = new int[5][2];
			int max_count = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] > max) {
						max_count = 0;
						max = map[i][j];
						max_idx[max_count][0] = i;
						max_idx[max_count][1] = j;
						max_count++;
					} else if (map[i][j] == max) {
						max_idx[max_count][0] = i;
						max_idx[max_count][1] = j;
						max_count++;
					}
				}
			}

			// goDown
			int trail = 0;
			for (int i = 0; i < max_count; i++) {
				trail = Math.max(goDown(map, visited, max_idx[i][0], max_idx[i][1], 1, false), trail);
			}
			buf.append(trail).append("\n");
			
			System.out.print(buf.toString());
		}
	}

	static int goDown(int[][] map, boolean[][] visited, int x, int y, int len, boolean fix) {
		visited[x][y] = true;
		int[] m_len = new int[4];

		// right
		if (x < map.length - 1 && !visited[x + 1][y]) {
			if (map[x + 1][y] < map[x][y]) {
				m_len[0] = goDown(map, visited, x + 1, y, len + 1, fix);
			} else if (!fix) {
				int tmp = map[x + 1][y];
				map[x + 1][y] = map[x][y] - 1;
				m_len[0] = goDown(map, visited, x + 1, y, len + 1, true);
				map[x + 1][y] = tmp;
			}
		}

		// left
		if (x > 0 && !visited[x - 1][y]) {
			if (map[x - 1][y] < map[x][y]) {
				m_len[1] = goDown(map, visited, x - 1, y, len + 1, fix);
			} else if (!fix) {
				int tmp = map[x - 1][y];
				map[x - 1][y] = map[x][y] - 1;
				m_len[1] = goDown(map, visited, x - 1, y, len + 1, true);
				map[x - 1][y] = tmp;
			}
		}

		// up
		if (y < map[x].length - 1 && !visited[x][y + 1]) {
			if (map[x][y + 1] < map[x][y]) {
				m_len[2] = goDown(map, visited, x, y + 1, len + 1, fix);
			} else if (!fix) {
				int tmp = map[x][y + 1];
				map[x][y + 1] = map[x][y] - 1;
				m_len[2] = goDown(map, visited, x, y + 1, len + 1, true);
				map[x][y + 1] = tmp;
			}
		}

		// down
		if (y > 0 && !visited[x][y - 1]) {
			if (map[x][y - 1] < map[x][y]) {
				m_len[3] = goDown(map, visited, x, y - 1, len + 1, fix);
			} else if (!fix) {
				int tmp = map[x][y - 1];
				map[x][y - 1] = map[x][y] - 1;
				m_len[3] = goDown(map, visited, x, y - 1, len + 1, true);
				map[x][y - 1] = tmp;
			}
		}
		
		visited[x][y] = false;
		// go nowhere
		if (m_len[0] == 0 && m_len[1] == 0 && m_len[2] == 0 && m_len[3] == 0)
			return len;
		// else
		int max = 0;
		for (int i = 0; i < 4; i++) {
			if (m_len[i] > max)
				max = m_len[i];
		}
		return max;
	}
}
