package samsung;

import java.io.*;
import java.util.StringTokenizer;

public class S1208 {
	static void getDump(int[] arr) {
		int max = 0;
		int max_idx = 0;
		int min = 101;
		int min_idx = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
				max_idx = i;
			}
			if (arr[i] < min) {
				min = arr[i];
				min_idx = i;
			}
		}
		arr[max_idx]--;
		arr[min_idx]++;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int[] box;

		for (int t = 1; t <= 10; t++) {
			box = new int[100];
			int dump = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());

			int idx = 0;
			while (st.hasMoreTokens())
				box[idx++] = Integer.parseInt(st.nextToken());

			for (int i = 0; i < dump; i++)
				getDump(box);

			int max = 0;
			int min = 101;
			for (int i = 0; i < 100; i++) {
				max = Math.max(max, box[i]);
				min = Math.min(min, box[i]);
			}
			
			sb.append("#").append(t).append(" ").append(max - min).append("\n");
		}
		
		System.out.print(sb.toString());
		br.close();
	}
}
