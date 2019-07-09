package programmers;

class MinandMax {
	public String solution(String s) {
		int[] arr = new int[s.split(" ").length];
		int count = 0;

		for (String str : s.split(" ")) {
				arr[count++] = Integer.parseInt(str);
		}

		int max = arr[0];
		int min = arr[0];

		for (int i : arr) {
			if (i > max) {
				max = i;
			}
			if (i < min) {
				min = i;
			}
		}

		String answer = String.valueOf(min) + " " + String.valueOf(max);
		return answer;
	}
}