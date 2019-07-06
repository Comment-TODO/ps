package topcoder;


import java.util.Arrays;
import java.util.HashMap;

public class InterestingDigits {
	public int[] digits(int base) {
		HashMap<Integer, Integer> answer = new HashMap<>();
		for (int j = 2; j <= Math.pow(base, 3) - 1 && j < base; j++) {
			boolean chkDone = false;	// 아닌 경우가 있는지 확인
			for (int i = 2; i * j <= Math.pow(base, 3) - 1; i++) {
				int temp = i * j;
				int chk = 0;
				// 각 자릿수의 합
				while (temp > 0) {
					chk += (temp % base);
					temp /= base;
				}
				// 합이 j의 배수가 아니라면
				if (chk % j != 0) {
					answer.remove(j);
					chkDone = true;
				} else if (!chkDone){	// 한 번이라도 아니었으면 추가X
					answer.put(j, j);
				}

			}
		}

		
		int[] result = new int[answer.size()];
		int i = 0;
		for (int key : answer.keySet()) {
			result[i++] = answer.get(key);
		}

		return result;
	}

	public static void main(String[] args) {
		InterestingDigits id = new InterestingDigits();
		System.out.println(Arrays.toString(id.digits(30)));
	}
}
