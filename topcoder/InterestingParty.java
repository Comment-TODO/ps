package topcoder;

import java.util.*;

public class InterestingParty {
	public int bestInvitation(String[] first, String[] second) {
		Map<String, Integer> hm = new HashMap<>();
		
		for (int i = 0; i < first.length; i++) {
			hm.put(first[i], hm.getOrDefault(first[i], 0) + 1);
			hm.put(second[i], hm.getOrDefault(second[i], 0) + 1);
		}
		
		int max = 0;
		for (String key : hm.keySet()) {
			if(hm.get(key) > max) {
				max = hm.get(key);
			}
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		InterestingParty ip = new InterestingParty();
		String[] first = {"variety", "diversity", "loquacity", "courtesy"};
		String[] second = {"talking", "speaking", "discussion", "meeting"};
		
		System.out.println(ip.bestInvitation(first, second));
	}
}
