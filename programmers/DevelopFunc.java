package programmers;

import java.util.*;

class DevelopFunc {
	public int[] solution(int[] progresses, int[] speeds) {

		Queue<Integer> que = new LinkedList<>();
		ArrayList<Integer> list = new ArrayList<>();
		
		for (int i = 0; i < speeds.length; i++) {
			int left = ((100 - progresses[i]) % speeds[i] == 0) ? (100 - progresses[i]) / speeds[i]
					: (100 - progresses[i]) / speeds[i] + 1;
			que.offer(left);
		}

		int maxLeft = que.poll();
		int distribute = 1;

		while (!que.isEmpty()) {
			int curr = que.poll();
			if (curr <= maxLeft) {
				distribute++;
			} else {
				maxLeft = curr;
				list.add(distribute);
				distribute = 1;
			}
		}

		list.add(distribute);

		return list.stream().mapToInt(i -> i).toArray();
	}
}
