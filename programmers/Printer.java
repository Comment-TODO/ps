package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Printer {
	public int solution(int[] priorities, int location) {
		Queue<Integer> que = new LinkedList<>();
		int obj_loc = location;
		int out_count = 0;
		int[] max = new int[priorities.length]; // 우선순위 내림차순
		int count = 0;
		for (int i : priorities) {
			que.add(i);
			max[count++] = i;
		}
		count--;	// max 마지막 인덱스로
		Arrays.sort(max);	// 오름차순 정렬


		while (!que.isEmpty()) {
			int tmp = que.poll();	// 큐 첫번째가
			if (tmp == max[count]) { // 우선순위 최대면
				out_count++;
				count--;
				if (obj_loc == 0) { // 목표 작업이면
					return out_count;
					
				}
				obj_loc--;
			} else { // 최대가 아니면
				que.add(tmp);
				if (obj_loc == 0) {
					obj_loc = que.size() - 1; // 마지막 인덱스로
				} else {
					obj_loc--; // 한 칸 앞으로
				}
			}
		}
		int answer = 0;
		return answer;
	}
}