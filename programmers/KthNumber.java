package programmers;

import java.util.Arrays;

class KthNumber {
	public int[] solution(int[] array, int[][] commands) {

		int[] temp = new int[100];
		int[] answer = new int[commands.length];

		for (int i = 0; i < commands.length; i++) {
			for (int j = commands[i][0] - 1; j < commands[i][1]; j++) {
				temp[j] = array[j];
			}
			Arrays.sort(temp);
			answer[i] = temp[100 - (commands[i][1] - commands[i][0] + 1) + commands[i][2] - 1];
			temp = new int[100];
		}

		return answer;
	}
}