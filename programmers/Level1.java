package programmers;

class Level1 {
	public String solution(String s) {
		String[] arr = s.split("");
		StringBuilder sb = new StringBuilder();
		int count = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i].equals(" ")) {
				sb.append(" ");
				count = 0;
				continue;
			}
			if (count % 2 == 0) {
				sb.append(arr[i].toUpperCase());
				count++;
			} else {
				sb.append(arr[i].toLowerCase());
				count++;
			}
		}

		String answer = sb.toString();

		return answer;
	}
}