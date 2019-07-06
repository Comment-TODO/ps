package samsung;

import java.io.*;
import java.util.StringTokenizer;

public class S7732 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int test = Integer.parseInt(br.readLine());

		for (int count = 1; count <= test; count++) {
			sb.append("#" + count + " ");
			
			st = new StringTokenizer(br.readLine(), ":");
			int h1 = Integer.parseInt(st.nextToken());
			int m1 = Integer.parseInt(st.nextToken());
			int s1 = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine(), ":");
			int h2 = Integer.parseInt(st.nextToken());
			int m2 = Integer.parseInt(st.nextToken());
			int s2 = Integer.parseInt(st.nextToken());
			
			int h, m, s;
			// 현재 시각이 약속 시간보다 늦은 경우
			if (h1 > h2 || (h1 == h2 && m1 > m2) || (h1 == h2 && m1 == m2 && s1 > s2)) {
				s = 24 * 60 * 60 - (h1 * 60 * 60 + m1 * 60 + s1) + h2 * 60 * 60 + m2 * 60 + s2;
				m = s / 60;
				h = m / 60;
				s %= 60;
				m %= 60;
			} else {
				s = (h2 * 60 * 60 + m2 * 60 + s2) - (h1 * 60 * 60 + m1 * 60 + s1);
				m = s / 60;
				h = m / 60;
				s %= 60;
				m %= 60;
			}
			
			sb.append(String.format("%02d", h) + ":").append(String.format("%02d", m) + ":").append(String.format("%02d", s) + "\n");
		}
		
		System.out.println(sb.toString());
	}
}
