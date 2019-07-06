package samsung;

import java.io.*;
import java.util.Hashtable;
import java.util.Map;
import java.util.StringTokenizer;

public class S1204 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		Map<String, Integer> ht = new Hashtable<String, Integer>();
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			br.readLine();
			st = new StringTokenizer(br.readLine());
			while (st.hasMoreTokens()) {
				String num = st.nextToken();
				ht.put(num, ht.getOrDefault(num, 0) + 1);
			}
			
			int max = 0;
			String max_key = "";
			for (String key : ht.keySet()) {
				if (ht.get(key) > max) {
					max = ht.get(key);
					max_key = key;
				}
			}
			sb.append("#").append(t).append(" ").append(max_key).append("\n");
			ht.clear();
		}
		
		System.out.print(sb.toString());
	}
}
