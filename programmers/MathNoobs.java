package programmers;

import java.util.Arrays;

class MathNoobs {
	public static void main(String[] args) {
		int[] answers = { 1, 3, 2, 4, 2 };
		int[] noob1 = { 1, 2, 3, 4, 5 };
		int[] noob2 = { 2, 1, 2, 3, 2, 4, 2, 5 };
		int[] noob3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };
		int count1, count2, count3, tmp;
		count1 = count2 = count3 = 0;

		for (int i = 0; i < answers.length; i++) {
			tmp = i;
			while (tmp > 4) {
				tmp -= 5;
			}
			if (answers[i] == noob1[tmp])
				count1++;

			tmp = i;
			while (tmp > 7) {
				tmp -= 8;
			}
			if (answers[i] == noob2[tmp])
				count2++;

			tmp = i;
			while (tmp > 9) {
				tmp -= 10;
			}
			if (answers[i] == noob3[tmp])
				count3++;
		}

		int[] answer;
		int[] tmpArr = { count1, count2, count3 };
		Arrays.sort(tmpArr);
		if (tmpArr[0] == tmpArr[1] && tmpArr[1] == tmpArr[2]) {
			answer = new int[3];
			answer[0] = 1;
			answer[1] = 2;
			answer[2] = 3;
		} else if (tmpArr[2] == tmpArr[1]) {
			answer = new int[2];
			if (tmpArr[2] == count1) {
				if (count1 == count2) {
					answer[0] = 1;
					answer[1] = 2;
				} else {
					answer[0] = 1;
					answer[1] = 3;
				}
			} else {
				answer[0] = 2;
				answer[1] = 3;
			}
		} else {
			answer = new int[1];
			if (tmpArr[2] == count1) answer[0] = 1;
			else if (tmpArr[2] == count2) answer[0] = 2;
			else answer[0] = 3;
		}
		System.out.println(Arrays.toString(answer));
	}

}
