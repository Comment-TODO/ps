package programmers;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

class NewsClustering {
	public int solution(String str1, String str2) {

		Map<String, Integer> firstMap = new HashMap<String, Integer>();
		Map<String, Integer> secondMap = new HashMap<String, Integer>();
		Map<String, Integer> union = new HashMap<String, Integer>();
		Map<String, Integer> intersection = new HashMap<String, Integer>();

		for (int i = 0; i < str1.length() - 1; i++) {
			String key = str1.substring(i, i + 2).toLowerCase();
			if (Pattern.matches("[a-zA-Z]*", key)) {
				firstMap.put(key, firstMap.getOrDefault(key, 0) + 1);
			}
		}

		for (int i = 0; i < str2.length() - 1; i++) {
			String key = str2.substring(i, i + 2).toLowerCase();
			if (Pattern.matches("[a-zA-Z]*", key)) {
				secondMap.put(key, secondMap.getOrDefault(key, 0) + 1);
			}
		}

		for (String str : firstMap.keySet()) {
			union.put(str, Math.max(firstMap.get(str), secondMap.getOrDefault(str, 0)));

			if (secondMap.containsKey(str)) {
				intersection.put(str, Math.min(firstMap.get(str), secondMap.get(str)));
			}
		}

		for (String str : secondMap.keySet()) {
			if (!union.containsKey(str))
				union.put(str, secondMap.get(str));
		}

		int i = 0;
		int u = 0;
		for (String str : intersection.keySet())
			i += intersection.get(str);
		for (String str : union.keySet())
			u += union.get(str);

		double answer = u > 0 ? (double) i / u : 1;

		return (int) (answer * 65536);
	}

}
