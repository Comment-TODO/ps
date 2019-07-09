package programmers;

class Tower {
	public int[] solution(int[] heights) {
		int[] answer = new int[heights.length];

		int curr = heights.length - 1;
		while (curr >= 0) {
			boolean sig = false;
			for (int i = curr - 1; i >= 0; i--) {
				if (heights[i] > heights[curr]) {
					answer[curr] = i + 1;
					sig = true;
					break;
				}
			}
			if (!sig)
				answer[curr] = 0;
			curr--;
		}

		return answer;
	}
}
