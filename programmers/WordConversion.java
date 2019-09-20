package programmers;

import java.util.LinkedList;
import java.util.Queue;

class WordConversion {
    public int solution(String begin, String target, String[] words) {

        Queue<String> word = new LinkedList<>();
        Queue<Integer> count = new LinkedList<>();
        word.offer(begin);
        count.offer(0);

        while (!word.isEmpty()) {
            String currWord = word.poll();
            int currCount = count.poll();
            if (currCount > words.length) {
                return 0;
            }

            if (currWord.equals(target)) {
                return currCount;
            }

            for (String s : words) {
                if (!s.equals(currWord) && isChangeable(currWord, s)) {
                    word.offer(s);
                    count.offer(currCount + 1);
                }
            }
        }

        return 0;
    }

    private boolean isChangeable(String ori, String target) {
        if (ori.equals(target))
            return false;

        int diff = 0;

        for (int i = 0; i < ori.length(); i++) {
            if (ori.charAt(i) != target.charAt(i)) {
                diff++;
            }

            if (diff > 1)
                return false;
        }

        return true;
    }
}
