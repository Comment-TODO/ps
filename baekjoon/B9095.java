package baekjoon;

import java.util.Scanner;

public class B9095 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		int[] result = new int[testCase];
		int input = 0;
		int one, two, three, tmpTwo, tmpOne;

		for (int i = 0; i < testCase; i++) {
			input = sc.nextInt();
			one = two = three = 0;

			// 3이 최대인 경우부터 시작
			three = input / 3;
			switch (input % 3) {
			case 1:
				one++;
				break;
			case 2:
				two++;
				break;
			}
			
			// 3의 갯수가 고정됐을때 변화될 1, 2 갯수
			tmpOne = one;
			tmpTwo = two;

			for (; three >= 0; three--) {
				tmpTwo = two;
				tmpOne = one;
				for (; tmpTwo >= 0; tmpTwo--) {
					result[i] += countCase(tmpOne, tmpTwo, three);
					tmpOne += 2;
				}
				// 3 하나 줄어들고 2와 1 추가. 만약 1이 2개면 2로 통합.
				two++;
				one++;
				if(one == 2) {
					one -= 2;
					two++;
				}
			}

		}
		
		sc.close();
		
		for(int i = 0; i < testCase; i++) {
			System.out.println(result[i]);
		}
	}

	// 팩토리얼
	static int factorial(int n) {
		if (n == 1 || n == 0) {
			return 1;
		} else {
			return n * factorial(n - 1);
		}
	}

	// a, b, c 조합
	static int countCase(int a, int b, int c) {
		int count = a + b + c;
		return factorial(count) / factorial(a) / factorial(b) / factorial(c);
	}
}
