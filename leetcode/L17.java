package leetcode;

import java.util.ArrayList;
import java.util.List;

class L17 {
    private String[] phoneNumberLetters;
    private List<String> answer;

    {
        phoneNumberLetters = new String[10];
        phoneNumberLetters[2] = "abc";
        phoneNumberLetters[3] = "def";
        phoneNumberLetters[4] = "ghi";
        phoneNumberLetters[5] = "jkl";
        phoneNumberLetters[6] = "mno";
        phoneNumberLetters[7] = "pqrs";
        phoneNumberLetters[8] = "tuv";
        phoneNumberLetters[9] = "wxyz";

        answer = new ArrayList<>();
    }

    public List<String> letterCombinations(String digits) {
        combineDigits(digits, 0, null);

        return answer;
    }

    private void combineDigits(String digits, int idx, StringBuffer combined) {
        if (combined == null) combined = new StringBuffer();

        if (idx == digits.length()) {
            if (combined.length() > 0) answer.add(combined.toString());
            return;
        }

        String phoneNumberLetter = phoneNumberLetters[Character.getNumericValue(digits.charAt(idx))];
        for (int i = 0; i < phoneNumberLetter.length(); i++) {
            combined.append(phoneNumberLetter.charAt(i));
            combineDigits(digits, idx + 1, combined);
            combined.deleteCharAt(combined.length() - 1);
        }
    }
}
