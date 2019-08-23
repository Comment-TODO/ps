package programmers.kakao;

import java.util.Arrays;

class Failure {

	private class Stage implements Comparable<Stage> {
		int index;
		double failure;

		@Override
		public int compareTo(Stage o) {
			return o.failure > this.failure ? 1 : o.failure == this.failure && o.index < this.index ? 1 : -1;
		}
	}

	public int[] solution(int N, int[] stages) {

		int[] challenger = new int[N + 2];
		int[] pass = new int[N + 2];

		for (int i = 0; i < stages.length; i++) {
			for (int j = 1; j < stages[i]; j++) {
				pass[j]++;
				challenger[j]++;
			}
			challenger[stages[i]]++;
		}

		Stage[] stage = new Stage[N];

		for (int i = 1; i <= N; i++) {
			Stage temp = new Stage();
			temp.index = i;
			temp.failure = challenger[i] > 0 ? (challenger[i] - pass[i]) / (double) challenger[i] : 0;
			stage[i - 1] = temp;
		}

		Arrays.sort(stage);
		int[] answer = new int[N];

		for (int i = 0; i < N; i++) {
			answer[i] = stage[i].index;
		}

		return answer;
	}
}
