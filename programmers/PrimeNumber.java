package programmers;

import java.util.HashMap;

class PrimeNumber {
	static HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
	
	int arrToNum(int[] arr, int depth) {
		int result = 0;
		for (int i = 0; i < depth; i++) {
			result += arr[i] * Math.pow(10, depth - 1 - i);
		}
		return result;
	}
	
	boolean chkPrime(int number) {
		if (number <= 1) return false;
		
		for (int i = 2; i <= number / 2; i++) {
			if (number % i == 0) return false;
		}
		return true;
	}

	void perm(int[] numbers, int depth, int n) {
		if (depth == n) {
			if (chkPrime(arrToNum(numbers, n))) {
				hash.put(arrToNum(numbers, n), arrToNum(numbers, n));
			}
			return;
		}
		
		for (int i = depth; i < numbers.length; i++) {
			swap(numbers, i, depth);
			perm(numbers, depth + 1, n);
			swap(numbers, i, depth);
		}
	}

	void swap(int[] numbers, int a, int b) {
		int tmp = numbers[a];
		numbers[a] = numbers[b];
		numbers[b] = tmp;
	}

	public int solution(String numbers) {
		int[] list = new int[numbers.length()];
		String[] num_String = numbers.split("");
		PrimeNumber pm = new PrimeNumber();

		for (int i = 0; i < numbers.length(); i++) {
			list[i] = Integer.parseInt(num_String[i]);
		}
		
		for (int i = 1; i <= numbers.length(); i++) {
			pm.perm(list, 0, i);
		}

		int answer = hash.size();
		return answer;
	}
}