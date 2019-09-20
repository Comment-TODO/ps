// https://programmers.co.kr/learn/courses/30/lessons/42884

package programmers;

import java.util.Arrays;
import java.util.Comparator;

class SpeedCamera {
    public int solution(int[][] routes) {

        Arrays.sort(routes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int count = 1;
        int limitStart = routes[0][0];
        int limitEnd = routes[0][1];

        for (int i = 1; i < routes.length; i++) {
            if (routes[i][0] > limitEnd) {
                count++;
                limitStart = routes[i][0];
                limitEnd = routes[i][1];
            } else {
                limitStart = routes[i][0];
                limitEnd = Math.min(limitEnd, routes[i][1]);
            }
        }

        return count;
    }
}
