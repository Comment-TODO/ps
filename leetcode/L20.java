import java.util.*;

class L20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            switch (ch) {
                case '(':
                case '{':
                case '[':
                    stack.push(ch);
                    break;
                case ')':
                case '}':
                case ']':
                    if (stack.isEmpty()) return false;
                    
                    char prev = stack.pop();
                    if (!((prev == '(' && ch == ')') ||
                        (prev == '{' && ch == '}') ||
                        (prev == '[' && ch == ']'))) {
                        return false;
                    }
                    break;
            }
        }
        
        if (!stack.isEmpty()) return false;
        return true;
    }
}
