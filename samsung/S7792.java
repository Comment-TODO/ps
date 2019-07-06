package samsung;

import java.io.*;
import java.util.Arrays;
import java.util.Hashtable;

public class S7792 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		Hashtable<Character, Integer> ht = new Hashtable<Character, Integer>();
		// testcase: T
		int T = Integer.parseInt(br.readLine());
		// has most alphabet: maxName
		int maxName = 0;
		for (int t = 1; t <= T; t++) {
			// Each testcase
			String input = "";
			int N = Integer.parseInt(br.readLine()); // student number: N
			for (int n = 0; n < N; n++) {
				String tmp = br.readLine();
				for (char chr : tmp.toCharArray()) {
					if (chr != ' ')
						ht.put(chr, 0);
				}
				if (ht.size() > maxName) {
					maxName = ht.size();
					input = tmp;
					// when alphabet number is same
				} else if (ht.size() == maxName) {
					// order by alphabetically
					String[] dic = new String[2];
					dic[0] = input;
					dic[1] = tmp;
					Arrays.sort(dic);
					input = dic[0];
					dic = null;
				}
				ht.clear();
			}
			maxName = 0;
			sb.append("#").append(t).append(" ").append(input).append("\n");
		}

		System.out.print(sb.toString());
	}
}