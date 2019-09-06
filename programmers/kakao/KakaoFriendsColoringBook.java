package programmers;

class KakaoFriendsColoringBook {

	boolean[][] visited;

	public int[] solution(int m, int n, int[][] picture) {
		int numberOfArea = 0;
		int maxSizeOfOneArea = 0;

		visited = new boolean[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (visited[i][j])
					continue;

				if (picture[i][j] > 0) {
					maxSizeOfOneArea = Math.max(maxSizeOfOneArea, move(picture, i, j, picture[i][j]));
					numberOfArea++;
				}
			}
		}

		int[] answer = new int[2];
		answer[0] = numberOfArea;
		answer[1] = maxSizeOfOneArea;
		return answer;
	}

	public int move(int[][] picture, int x, int y, int color) {
		if (x < 0 || y < 0 || x >= visited.length || y >= visited[0].length || visited[x][y])
			return 0;
		if (picture[x][y] != color)
			return 0;

		int ret = 1;
		visited[x][y] = true;
		ret += move(picture, x + 1, y, color);
		ret += move(picture, x - 1, y, color);
		ret += move(picture, x, y + 1, color);
		ret += move(picture, x, y - 1, color);

		return ret;
	}
}
