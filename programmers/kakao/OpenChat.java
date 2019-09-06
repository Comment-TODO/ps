package programmers;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class OpenChat {

	public String[] solution(String[] record) {

		Map<String, String> uid = new HashMap<String, String>();
		List<String> list = new LinkedList<String>();

		for (int i = 0; i < record.length; i++) {
			String[] curr = record[i].split(" ");
			if (curr[0].equals("Enter") || curr[0].equals("Change")) {
				uid.put(curr[1], curr[2]);
			}
		}

		for (int i = 0; i < record.length; i++) {
			String[] curr = record[i].split(" ");
			switch (curr[0]) {
			case "Enter":
				list.add(uid.get(curr[1]) + "님이 들어왔습니다.");
				break;
			case "Leave":
				list.add(uid.get(curr[1]) + "님이 나갔습니다.");
				break;
			}
		}

		String[] answer = list.toArray(new String[0]);

		return answer;
	}
}
