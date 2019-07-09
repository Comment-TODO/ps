package programmers;

import java.util.*;

class BestAlbum {
	static String mostGenre(Map<String, Integer> map) {
		int max = 0;
		String max_key = "";
		for (String str : map.keySet()) {
			if (map.get(str) > max) {
				max = map.get(str);
				max_key = str;
			}
		}
		return max_key;
	}

	static int mostPlayed(String[] genres, int[] plays, String genre) {
		int idx = -1;
		int max = 0;
		for (int i = 0; i < plays.length; i++) {
			if (genres[i].equals(genre)) {
				if (plays[i] > max) {
					idx = i;
					max = plays[i];
				}
			}
		}
		return idx;
	}

	public int[] solution(String[] genres, int[] plays) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		Map<String, Integer> ht = new Hashtable<String, Integer>();
		for (int i = 0; i < plays.length; i++)
			ht.put(genres[i], ht.getOrDefault(genres[i], 0) + plays[i]);

		while (ht.size() > 0) {
			String mg = mostGenre(ht);
			for (int i = 0; i < 2; i++) {
				int mp = mostPlayed(genres, plays, mg);
				if (mp == -1)
					break;
				list.add(mp);
				plays[mp] = -1;
			}
			ht.remove(mg);
		}
		
		int[] answer = new int[list.size()];
		for (int i = 0; i < list.size(); i++)
			answer[i] = list.get(i);
		return answer;
	}
}
