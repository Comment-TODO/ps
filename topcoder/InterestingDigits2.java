package topcoder;

import java.util.ArrayList;
import java.util.Arrays;

public class InterestingDigits2 {
	public int[] digits(int base) {
		ArrayList<Integer> v = new ArrayList<>();
		
		for (int n = 2; n < base; n++) {
			boolean ok = true;
			for (int k1 = 0; k1 < base; k1++) {
				for (int k2 = 0; k2 < base; k2++) {
					for (int k3 = 0; k3 < base; k3++) {
						if ((k1 + k2 * base + k3 * base * base) % n == 0 && (k1 + k2 + k3) % n != 0) {
							ok = false;
							break;
						}
					}
					if (!ok) break;
				}
				if (!ok) break;
			}
			if (ok) v.add(n);
		}
		
		int[] ans = new int[v.size()];
		for ( int i = 0; i < v.size(); i++) ans[i] = v.get(i);
		return ans;
	}
	public static void main(String[] args) {
		InterestingDigits id = new InterestingDigits();
		System.out.println(Arrays.toString(id.digits(9)));
	}
}
