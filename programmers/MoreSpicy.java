package programmers;

import java.util.*;

class MoreSpicy {
	static void downHeap(ArrayList<Integer> arr, int idx) {
		int min;
		if (arr.size() < 2)
			return;
		for (int parent = idx; parent <= (arr.size() - 2) / 2; parent = min) {
			int cl = 2 * parent + 1;
			int cr = cl + 1;
			if (cr < arr.size() && arr.get(cl) > arr.get(cr)) {
				min = cr;
			} else {
				min = cl;
			}
			if (arr.get(parent) > arr.get(min)) {
				int tmp = arr.get(parent);
				arr.set(parent, arr.get(min));
				arr.set(min, tmp);
			} else {
				break;
			}
		}
	}

	static void upHeap(ArrayList<Integer> arr, int idx) {
		if (arr.size() < 2)
			return;
		for (int parent = (idx - 1) / 2; parent >= 0; parent = (parent - 1) / 2) {
			if (arr.get(parent) > arr.get(idx)) {
				int tmp = arr.get(parent);
				arr.set(parent, arr.get(idx));
				arr.set(idx, tmp);
				idx = parent;
			} else {
				break;
			}
		}
	}

	public int solution(int[] scoville, int K) {
		ArrayList<Integer> arr = new ArrayList<>();
		int count = 0;

		for (int i = 0; i < scoville.length; i++) {
			arr.add(scoville[i]);
			upHeap(arr, i);
		}

		while (arr.size() > 1) {
			if (arr.get(0) >= K) {
				break;
			}
			arr.add(0, arr.get(0) + arr.get(1) * 2);
			arr.remove(1);
			arr.remove(1);
			downHeap(arr, 0);
			count++;
		}
		
		if (arr.get(0) < K)
			return -1;

		return count;
	}
}