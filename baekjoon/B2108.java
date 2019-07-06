package baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;

public class B2108 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> alist = new ArrayList<>();
		Hashtable<Integer, Integer> ht = new Hashtable<>();

		int testCase = Integer.parseInt(br.readLine());
		int tmp = 0;
		while (testCase-- > 0) {
			tmp = Integer.parseInt(br.readLine());
			alist.add(tmp);
			ht.put(tmp, ht.getOrDefault(tmp, 0) + 1);
		}

		Collections.sort(alist);

		float avg = 0;
		for (int i : alist)
			avg += i;
		avg = Math.round(avg / alist.size());
		int mid = alist.get((alist.size() / 2));

		int freq_max = 0;
		ArrayList<Integer> f_arr = new ArrayList<>();
		for (int key : ht.keySet()) {
			freq_max = (ht.get(key) > freq_max ? ht.get(key) : freq_max);
		}
		for (int key: ht.keySet()) {
			if (ht.get(key) == freq_max) {
				f_arr.add(key);
			}
		}
		
		Collections.sort(f_arr);

		int freq = f_arr.size() >= 2 ? f_arr.get(1) : f_arr.get(0);
		int range = alist.get(alist.size() - 1) - alist.get(0);

		System.out.println((int)avg);
		System.out.println(mid);
		System.out.println(freq);
		System.out.println(range);
	}
}
