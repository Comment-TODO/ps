package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class L763 {
    public List<Integer> partitionLabels(String S) {
        List<Integer> answer = new ArrayList<>();
        Alphabet[] alphabets = new Alphabet[26];

        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);

            if (alphabets[ch - 'a'] == null) {
                alphabets[ch - 'a'] = new Alphabet();
                alphabets[ch - 'a'].start = i;
                alphabets[ch - 'a'].end = i;
            } else {
                alphabets[ch - 'a'].end = i;
            }
        }

        Queue<Alphabet> priorityQue = new PriorityQueue<>((o1, o2) -> o1.start - o2.start);
        for (int i = 0; i < 26; i++) {
            if (alphabets[i] != null)
                priorityQue.add(alphabets[i]);
        }

        int start;
        int end;
        if (!priorityQue.isEmpty()) {
            Alphabet alphabet = priorityQue.poll();
            start = alphabet.start;
            end = alphabet.end;
        } else
            return answer;

        while (!priorityQue.isEmpty()) {
            Alphabet alphabet = priorityQue.poll();
            if (alphabet.start <= end) {
                end = Math.max(end, alphabet.end);
            } else {
                answer.add(end - start + 1);
                start = alphabet.start;
                end = alphabet.end;
            }
        }

        answer.add(end - start + 1);

        return answer;
    }
}

class Alphabet {
    int start;
    int end;
}
