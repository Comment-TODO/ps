package programmers;

import java.util.*;

class OpenChat {
	public String[] solution(String[] record) {
		StringTokenizer st;
		String[] t_result = new String[100000];
		Map<String, String> id_htable = new Hashtable<>();

		int count = 0;
		for (int i = 0; i < record.length; i++) {
			st = new StringTokenizer(record[i]);
			String id;
			switch (st.nextToken()) {
			case "Enter":
				id = st.nextToken();
				id_htable.put(id, st.nextToken());
				t_result[count++] = id + "님이 들어왔습니다.";
				break;
			case "Leave":
				id = st.nextToken();
				t_result[count++] = id + "님이 나갔습니다.";
				break;
			case "Change":
				id = st.nextToken();
				id_htable.put(id, st.nextToken());
				break;
			}
		}
		String[] answer = new String[count];
		for (int i = 0; i < count; i++) {
			answer[i] = id_htable.get(t_result[i].substring(0, t_result[i].indexOf("님")))
					+ t_result[i].substring(t_result[i].indexOf("님"));
		}
		return answer;
	}
}