package topcoder;

import java.util.ArrayList;
import java.util.List;

public class NumberMagicEasy {

    public int theNumber(String answer) {

        List<int[]> cards = new ArrayList<>();
        int[] card1 = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] card2 = {1, 2, 3, 4, 9, 10, 11, 12};
        int[] card3 = {1, 2, 5, 6, 9, 10, 13, 14};
        int[] card4 = {1, 3, 5, 7, 9, 11, 13, 15};
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);


        for (int i = 1; i <= 15; i++) {
            int curr = 0; // card select
            boolean isAnswer = true;
            for (char ans : answer.toCharArray()) {
                boolean isValid = false;
                if (ans == 'Y') {
                    for (int item : cards.get(curr)) {
                        if (item == i) {
                            isValid = true;
                            break;
                        }
                    }
                } else {
                    isValid = true;
                    for (int item : cards.get(curr)) {
                        if (item == i) {
                            isValid = false;
                        }
                    }
                }
                curr++;

                if (!isValid) {
                    isAnswer = false;
                    break;
                }
            }

            if (isAnswer)
                return i;
        }

        return 16;
    }
}
