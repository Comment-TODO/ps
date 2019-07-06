package topcoder;

public class FriendScore {
	public int highestScore(String[] friends) {
		boolean[] chkFriend = new boolean[friends.length];
		int[] twoFriend = new int[friends.length];

		for (int i = 0; i < friends.length; i++) {
			for (int j = 0; j < friends.length; j++)
				chkFriend[j] = false;

			for (int j = 0; j < friends.length; j++) {
				if (friends[i].charAt(j) == 'Y') {
					twoFriend[i]++;
					chkFriend[j] = true;
				}
			}

			for (int j = 0; j < friends.length; j++) {
				if (friends[i].charAt(j) == 'Y') {
					for (int k = 0; k < friends.length; k++) {
						if (friends[j].charAt(k) == 'Y' && !chkFriend[k] && k != i) {
							twoFriend[i]++;
						}
					}
				}
			}
		}

		int max = 0;
		for (int i = 0; i < friends.length; i++) {
			if (max < twoFriend[i])
				max = twoFriend[i];
		}
		return max;
	}

	public static void main(String[] args) {
		FriendScore fs = new FriendScore();
		String[] friends = { "NYNNN", "YNYNN", "NYNYN", "NNYNY", "NNNYN" };
		System.out.println(fs.highestScore(friends));
	}
}
