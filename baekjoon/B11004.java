package baekjoon;

import java.io.*;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B11004 {
	public static void main(String[] args) throws IOException {
		Min_k min = new Min_k();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		st.nextToken();
		int k = Integer.parseInt(st.nextToken());
		min.setSize(k);

		st = new StringTokenizer(br.readLine());
		float max = 0;
		for (int i = 0; i < k; i++) {
			min.arr[i] = Float.parseFloat((st.nextToken()));
			if (max < min.arr[i])
				max = min.arr[i];
		}

		min.max = max;

		while (st.hasMoreTokens()) {
			float tmp = Float.parseFloat(st.nextToken());
			if (tmp < min.max) {
				min.setMin(tmp);
			}
		}
		Arrays.sort(min.arr);

		float result = min.arr[k - 1];
		BigDecimal bigd = new BigDecimal(result);
		System.out.println(bigd.toString());
	}
}

class Min_k {
	private int size;
	float max;
	float[] arr = null;

	void setSize(int k) {
		this.size = k;
		this.arr = new float[k];
	}

	int getMaxIdx() {
		int max_idx = 0;
		for (int i = 0; i < size; i++) {
			if (arr[i] == max) {
				max_idx = i;
				break;
			}
		}
		return max_idx;
	}

	void setMin(float num) {
		arr[getMaxIdx()] = num;
		max = num;
	}
}
