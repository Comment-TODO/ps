import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2178 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] maze = new int[N][M];
		int[][] count = new int[N][M];
		boolean[][] visit = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				maze[i][j] = line.charAt(j) - '0';
			}
		}

		Queue<Integer> xQue = new LinkedList<Integer>();
		Queue<Integer> yQue = new LinkedList<Integer>();
		count[0][0] = 1;
		visit[0][0] = true;
		xQue.offer(0);
		yQue.offer(0);

		final int[] moveX = { -1, 1, 0, 0 };
		final int[] moveY = { 0, 0, -1, 1 };

		while (!xQue.isEmpty()) {
			int x = xQue.poll();
			int y = yQue.poll();
			int currCount = count[y][x];

			if (x == M - 1 && y == N - 1) {
				break;
			}

			for (int i = 0; i < 4; i++) {
				int nextX = x + moveX[i];
				int nextY = y + moveY[i];

				if (nextX >= 0 && nextX < M && nextY >= 0 && nextY < N) {
					if (maze[nextY][nextX] == 1 && !visit[nextY][nextX]) {
						visit[nextY][nextX] = true;
						xQue.offer(nextX);
						yQue.offer(nextY);
						count[nextY][nextX] = currCount + 1;
					}
				}
			}
		}

		System.out.println(count[N - 1][M - 1]);

	}
}
