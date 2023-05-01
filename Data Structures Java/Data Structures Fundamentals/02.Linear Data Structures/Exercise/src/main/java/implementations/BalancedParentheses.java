package implementations;

import interfaces.Solvable;

import java.util.ArrayDeque;

public class BalancedParentheses implements Solvable {
    private String parentheses;

    public BalancedParentheses(String parentheses) {
        this.parentheses = parentheses;
    }

    @Override
    public Boolean solve() {
        ArrayDeque<Character> parenthesesStack = new ArrayDeque<>();

        for (int i = 0; i < this.parentheses.length(); i++) {
            char current = parentheses.charAt(i);
            if (current == '{' || current == '[' || current == '(') {
                parenthesesStack.push(current);
            } else {
                if (parenthesesStack.isEmpty()) {
                    return false;
                } else {
                    char lastParentheses = parenthesesStack.pop();
                    if (current != getOpposite(lastParentheses)) {
                        return false;
                    }
                }
            }
        }
        if (!parenthesesStack.isEmpty()) {
            return false;
        }
        return true;
    }

    private char getOpposite(char c) {
        switch (c) {
            case '(':
                return ')';
            case '[':
                return ']';
            case '{':
                return '}';
            default:
                return 0;
        }
    }
}
