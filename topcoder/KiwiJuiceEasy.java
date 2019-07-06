package topcoder;

import java.util.Arrays;

public class KiwiJuiceEasy {
	public int[] thePouring(int[] capacities, int[] bottles, int[] fromId, int[] toId) {		 
		 for (int i = 0; i < fromId.length; i++) {
			 int toBott = bottles[toId[i]];
			 int fromBott = bottles[fromId[i]];
			 int toCapa = capacities[toId[i]];
			 
			 if (toCapa >= toBott + fromBott) {	// 용량이 충분하면
				 toBott += fromBott;
				 bottles[toId[i]] = toBott;
				 bottles[fromId[i]] = 0;
			 } else {	// 용량이 부족하면
				 bottles[toId[i]] = toCapa;
				 bottles[fromId[i]] = fromBott - (toCapa - toBott);
			 }
		 }
		 
		 return bottles;
	 }
	
	public static void main(String[] args) {
		KiwiJuiceEasy kw = new KiwiJuiceEasy();
		int[] capacities = {14, 35, 86, 58, 25, 62};
		int[] bottles = {6, 34, 27, 38, 9, 60};
		int[] fromId = {1, 2, 4, 5, 3, 3, 1, 0};
		int[] toId = {0, 1, 2, 4, 2, 5, 3, 1};
		System.out.println(Arrays.toString(kw.thePouring(capacities, bottles, fromId, toId)));
	}
}
