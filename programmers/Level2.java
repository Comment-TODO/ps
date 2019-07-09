package programmers;

public class Level2 {
	public static void main(String[] args) {
		int[][] board = { { 0, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 0, 0, 1, 0 } };

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				squareLeng(board, i, j);
				System.out.println(count);
			}
		}

		System.out.println(count);
	}

	static int count = 0;

	static boolean squareLeng(int[][] board, int a, int b) {
		boolean square = false;
		try {
			if (board[a][b] == 1) {
				if (board[a + 1][b] + board[a + 1][b + 1] + board[a][b + 1] == 3) {
					square = true;
					count++;
					squareLeng(board, a + 1, b + 1);
					squareLeng(board, a + 1, b);
					squareLeng(board, a, b + 1);
				}
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			return false;
		}
		return square;
	}
}