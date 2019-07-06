package samsung;

import java.io.*;
import java.util.StringTokenizer;

public class S1953 {
	static int[][] culvert;
	static boolean[][] visited;
	static boolean[][] tmp;

	static void tunnel(int x, int y, int leftTime) {
		leftTime--;

		if (culvert[x][y] == 0) {
			return;
		}

		visited[x][y] = true;
		tmp[x][y] = true;
		
		if (leftTime == 0) {
			visited[x][y] = false;
			return;
		}

		switch (culvert[x][y]) {
		case 1:
			if (x > 0 && culvert[x - 1][y] != 2 && culvert[x - 1][y] != 6 && culvert[x - 1][y] != 7
					&& !visited[x - 1][y]) {
				tunnel(x - 1, y, leftTime);
			}
			if (x < culvert.length - 1 && culvert[x + 1][y] != 2 && culvert[x + 1][y] != 4 && culvert[x + 1][y] != 5
					&& !visited[x + 1][y]) {
				tunnel(x + 1, y, leftTime);
			}
			if (y > 0 && culvert[x][y - 1] != 3 && culvert[x][y - 1] != 5 && culvert[x][y - 1] != 6
					&& !visited[x][y - 1]) {
				tunnel(x, y - 1, leftTime);
			}
			if (y < culvert[0].length - 1 && culvert[x][y + 1] != 3 && culvert[x][y + 1] != 4 && culvert[x][y + 1] != 7
					&& !visited[x][y + 1]) {
				tunnel(x, y + 1, leftTime);
			}
			break;
		case 2:
			if (y > 0 && culvert[x][y - 1] != 3 && culvert[x][y - 1] != 5 && culvert[x][y - 1] != 6
					&& !visited[x][y - 1]) {
				tunnel(x, y - 1, leftTime);
			}
			if (y < culvert[0].length - 1 && culvert[x][y + 1] != 3 && culvert[x][y + 1] != 4 && culvert[x][y + 1] != 7
					&& !visited[x][y + 1]) {
				tunnel(x, y + 1, leftTime);
			}
			break;
		case 3:
			if (x > 0 && culvert[x - 1][y] != 2 && culvert[x - 1][y] != 6 && culvert[x - 1][y] != 7
					&& !visited[x - 1][y]) {
				tunnel(x - 1, y, leftTime);
			}
			if (x < culvert.length - 1 && culvert[x + 1][y] != 2 && culvert[x + 1][y] != 4 && culvert[x + 1][y] != 5
					&& !visited[x + 1][y]) {
				tunnel(x + 1, y, leftTime);
			}
			break;
		case 4:
			if (x < culvert.length - 1 && culvert[x + 1][y] != 2 && culvert[x + 1][y] != 4 && culvert[x + 1][y] != 5
					&& !visited[x + 1][y]) {
				tunnel(x + 1, y, leftTime);
			}
			if (y < culvert[0].length - 1 && culvert[x][y + 1] != 3 && culvert[x][y + 1] != 4 && culvert[x][y + 1] != 7
					&& !visited[x][y + 1]) {
				tunnel(x, y + 1, leftTime);
			}
			break;
		case 5:
			if (x < culvert.length - 1 && culvert[x + 1][y] != 2 && culvert[x + 1][y] != 4 && culvert[x + 1][y] != 5
					&& !visited[x + 1][y]) {
				tunnel(x + 1, y, leftTime);
			}
			if (y > 0 && culvert[x][y - 1] != 3 && culvert[x][y - 1] != 5 && culvert[x][y - 1] != 6
					&& !visited[x][y - 1]) {
				tunnel(x, y - 1, leftTime);
			}
			break;
		case 6:
			if (x > 0 && culvert[x - 1][y] != 2 && culvert[x - 1][y] != 6 && culvert[x - 1][y] != 7
					&& !visited[x - 1][y]) {
				tunnel(x - 1, y, leftTime);
			}
			if (y > 0 && culvert[x][y - 1] != 3 && culvert[x][y - 1] != 5 && culvert[x][y - 1] != 6
					&& !visited[x][y - 1]) {
				tunnel(x, y - 1, leftTime);
			}
			break;
		case 7:
			if (x > 0 && culvert[x - 1][y] != 2 && culvert[x - 1][y] != 6 && culvert[x - 1][y] != 7
					&& !visited[x - 1][y]) {
				tunnel(x - 1, y, leftTime);
			}
			if (y < culvert[0].length - 1 && culvert[x][y + 1] != 3 && culvert[x][y + 1] != 4 && culvert[x][y + 1] != 7
					&& !visited[x][y + 1]) {
				tunnel(x, y + 1, leftTime);
			}
			break;
		}

		visited[x][y] = false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token;
		StringBuilder sb = new StringBuilder();
		// 테스트 케이스
		int testCase = Integer.parseInt(br.readLine());
		for (int tCount = 1; tCount <= testCase; tCount++) {
			// 변수 입력
			token = new StringTokenizer(br.readLine());
			int height = Integer.parseInt(token.nextToken());
			int width = Integer.parseInt(token.nextToken());
			int hole_y = height - 1 - Integer.parseInt(token.nextToken());
			int hole_x = Integer.parseInt(token.nextToken());
			int elapsed = Integer.parseInt(token.nextToken());
			culvert = new int[width][height];
			visited = new boolean[width][height];
			tmp = new boolean[width][height];

			// 지하수로 작성
			for (int i = height - 1; i >= 0; i--) {
				token = new StringTokenizer(br.readLine());
				for (int j = 0; j < width; j++) {
					culvert[j][i] = Integer.parseInt(token.nextToken());
				}
			}

		
			// 장소 카운팅
			int count = 0;
			tunnel(hole_x, hole_y, elapsed);
			for (int i = height - 1; i >= 0; i--) {
				for (int j = 0; j < width; j++)
					if (tmp[j][i])
						count++;
			}
			
			sb.append("#").append(tCount).append(" ");
			sb.append(count).append("\n");
			
			

		}
		

		System.out.print(sb.toString());
	}
}
