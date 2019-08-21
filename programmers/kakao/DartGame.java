package programmers.kakao;

class DartGame {

	public int solution(String dartResult) {

		int[] score = new int[3];
		int cursor = 0;

		for (int i = 0; i < dartResult.length(); i++) {
      // 아스키코드로 숫자 체크
			if (dartResult.charAt(i) >= 48 && dartResult.charAt(i) < 58) {
				if (dartResult.charAt(i + 1) == '0') {  // 10 예외처리
					score[cursor] = 10;
					i++;
				} else {
					score[cursor] = dartResult.charAt(i) - 48;
				}
				cursor++;
      // D, T, *, # 처리
			} else if (dartResult.substring(i, i + 1).equals("D")) {
				score[cursor - 1] *= score[cursor - 1];
			} else if (dartResult.substring(i, i + 1).equals("T")) {
				score[cursor - 1] = (int) Math.pow(score[cursor - 1], 3);
			} else if (dartResult.substring(i, i + 1).equals("*")) {
				if (cursor > 1) {
					score[cursor - 2] *= 2;
					score[cursor - 1] *= 2;
				} else {
					score[cursor - 1] *= 2;
				}
			} else if (dartResult.substring(i, i + 1).equals("#")) {
				score[cursor - 1] *= -1;
			}
		}

		int sum = 0;
		for (int i : score) {
			sum += i;
		}

		return sum;
	}
}
