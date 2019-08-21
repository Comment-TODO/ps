package programmers.kakao;

import java.util.LinkedList;

class Cache {

	public int solution(int cacheSize, String[] cities) {

		if (cacheSize == 0) {
			return cities.length * 5;
		}

		LinkedList<String> cache = new LinkedList<String>();
		int timeLapse = 0;

		for (int i = 0; i < cities.length; i++) {
			boolean onCache = false;

			for (int j = 0; j < cache.size(); j++) {
				if (cities[i].toLowerCase().equals(cache.get(j))) {
					onCache = true;
					cache.remove(j);
					cache.addFirst(cities[i].toLowerCase());
					timeLapse++;
					break;
				}
			}

			if (!onCache) {
				if (cache.size() == cacheSize)
					cache.removeLast();
				cache.addFirst(cities[i].toLowerCase());
				timeLapse += 5;
			}
		}

		return timeLapse;
	}
}
