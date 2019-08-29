import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1463 {

	private static int[] num; // for memoization

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		num = new int[N + 1];

		calc(N, 0);
		System.out.println(num[1]);
	}

	private static void calc(int n, int count) {
		if (n == 0)
			return;
		if (num[n] != 0 && num[n] < count)
			return;
		num[n] = num[n] == 0 ? count : Math.min(count, num[n]);
		if (n % 3 == 0) {
			calc(n / 3, count + 1);
		}
		if (n % 2 == 0) {
			calc(n / 2, count + 1);
		}
		calc(n - 1, count + 1);
	}
}
