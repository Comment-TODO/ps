package programmers;

import java.util.*;

class TruckOnBridge {
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> que = new LinkedList<>();
        int used_weight = 0;
        int truck_idx = 0;
        int time = 0;
        
        for (int i = 0; i < bridge_length; i++) {
            que.add(0);
        }
        
        while (truck_idx < truck_weights.length) {
        	int temp = que.poll();
        	if (temp != 0) {
        		used_weight -= temp;
        	}
        	
        	if (used_weight + truck_weights[truck_idx] <= weight) {
        		que.add(truck_weights[truck_idx]);
        		used_weight += truck_weights[truck_idx];
            	truck_idx++;
        	} else {
        		que.add(0);
        	}
        	
        	time++;
        }
        time += bridge_length;
        
        return time;
    }
}