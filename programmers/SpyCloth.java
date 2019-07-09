package programmers;

import java.util.*;

class SpyCloth {
    public int solution(String[][] clothes) {
        Hashtable<String, Integer> ht = new Hashtable<>();
        
        for (int i = 0; i < clothes.length; i++) {
            ht.put(clothes[i][1], ht.getOrDefault(clothes[i][1], 0) + 1);
        }
        
        int count = 1;
        for (String str : ht.keySet()) {
            count *= ht.get(str) + 1;
        }
        return count;
    }
}