package programmers;

import java.util.*;

class GymClothes {
	public int solution(int n, int[] lost, int[] reserve) {
		Set<Integer> res = new HashSet<>();
		List<Integer> los = new ArrayList<>();
		int count = n - lost.length;

		for (int i = 0; i < reserve.length; i++) {
			res.add(reserve[i]);
		}

		for (int i = 0; i < lost.length; i++)
			los.add(lost[i]);

		for (int i = 0; i < lost.length; i++) {
			if (res.contains(lost[i])) {
				res.remove((Integer) lost[i]);
				los.remove((Integer) lost[i]);
				count++;
			}
		}

		for (int i = 0; i < los.size(); i++) {
			if (res.contains(los.get(i) - 1)) {
				res.remove(los.get(i) - 1);
				count++;
				continue;
			}
			if (res.contains(los.get(i) + 1)) {
				res.remove(los.get(i) + 1);
				count++;
			}
		}

		return count;
	}
}