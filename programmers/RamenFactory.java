package programmers;

import java.util.*;

class RamenFactory {
    public int solution(int stock, int[] dates, int[] supplies, int k) {
        PriorityQueue<Integer> pque = new PriorityQueue<>(dates.length, new Comparator<Integer>(){
            @Override
            public int compare(Integer a1, Integer a2) {
               return (a1 > a2) ? -1 : 1;
            }
        });
        
        int count = 0;
        int j = 0;
        for (int i = 1; i < k; i++) {
            stock--;
            if (j < dates.length && i == dates[j]) {
                pque.offer(supplies[j]);
                j++;
            }
            if (stock == 0) {
                stock += pque.poll();
                count++;
            }
        }

        return count;
    }
}