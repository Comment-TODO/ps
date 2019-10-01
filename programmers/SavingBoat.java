// https://programmers.co.kr/learn/courses/30/lessons/42885?language=java

package programmers;

import java.util.Arrays;

class SavingBoat {
    public int solution(int[] people, int limit) {
        int[] peopleArr = people.clone();
        int boat = 0;

        Arrays.sort(peopleArr);

        int left = 0;
        int right = peopleArr.length - 1;

        while (left < right) {
            int heavier = peopleArr[right];
            int lighter = peopleArr[left];

            boat++;

            if (heavier + lighter <= limit) {
                right--;
                left++;
            } else {
                right--;
            }

            if (left == right)
                boat++;
        }

        return boat;
    }
}
