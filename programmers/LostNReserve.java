package programmers;

import java.util.ArrayList;

class LostNReserve {
    public int solution(int n, int[] lost, int[] reserve) {
        ArrayList<Integer> lostCopy = new ArrayList<>(lost.length);
        ArrayList<Integer> reserveCopy = new ArrayList<>(reserve.length);

        for (int i : lost) {
            lostCopy.add(i);
        }

        for (int i : reserve) {
            if (lostCopy.contains(i)) {
                lostCopy.remove(Integer.valueOf(i));
            } else {
                reserveCopy.add(i);
            }
        }

        for (int i = 0; i < lost.length; i++) {
           if (lostCopy.contains(lost[i])) {
               if (reserveCopy.contains(lost[i] - 1)) {
                   lostCopy.remove(Integer.valueOf(lost[i]));
                   reserveCopy.remove(Integer.valueOf(lost[i] - 1));
               } else if (reserveCopy.contains(lost[i] + 1)) {
                   lostCopy.remove(Integer.valueOf(lost[i]));
                   reserveCopy.remove(Integer.valueOf(lost[i] + 1));
               }
           }
        }

        return n - lostCopy.size();
    }
}
