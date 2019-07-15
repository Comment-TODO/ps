package programmers;

import java.util.*;

class KakaoFailure {
	class Failure implements Comparable<Failure> {
		int stage;
		double fail;

		public Failure(int stage, double fail) {
			this.stage = stage;
			this.fail = fail;
		}

		@Override
		public int compareTo(Failure next) {
			if (this.fail > next.fail) {
				return -1;
			} else if (this.fail == next.fail) {
				if (this.stage < next.stage)
					return -1;
				else
					return 1;
			} else {
				return 1;
			}
		}
	}

	public int[] solution(int N, int[] stages) {
		PriorityQueue<Integer> pque = new PriorityQueue<>();
		PriorityQueue<Failure> pque2 = new PriorityQueue<>();
		int challenger = stages.length;

		for (int i = 0; i < stages.length; i++) {
			pque.offer(stages[i]);
		}

		for (int i = 1; i <= N; i++) {
			int fail = 0;
			while (!pque.isEmpty() && pque.peek() == i) {
				pque.poll();
				fail++;
			}
			if (challenger == 0) {
				pque2.offer(new Failure(i, 0));
			} else {
				pque2.offer(new Failure(i, (double) fail / challenger));
				challenger -= fail;
			}
		}

		int[] answer = new int[N];
		for (int i = 0; i < N; i++) {
			answer[i] = pque2.poll().stage;
		}

		return answer;
	}
}
