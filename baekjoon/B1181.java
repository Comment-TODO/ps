package baekjoon;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class B1181 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Set<String> ts = new TreeSet<>(new Comp());

		int wordNum = Integer.parseInt(br.readLine());

		for (int i = 0; i < wordNum; i++) {
			ts.add(br.readLine());
		}

		Iterator<String> itr = ts.iterator();

		for (int i = 0; i < ts.size(); i++) {
			System.out.println(itr.next());
		}
	}
}

class Comp implements Comparator<String> {
	public int compare(String str1, String str2) {
		return str1.length() > str2.length() ? 1 : (str1.length() == str2.length() ? str1.compareTo(str2) : -1);
	}
}
