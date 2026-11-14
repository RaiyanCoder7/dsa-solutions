class Solution {
    static int prec(char c) {
        switch (c) {
            case '^': return 3;
            case '*':
            case '/': return 2;
            case '+':
            case '-': return 1;
        }
        return -1;
    }

    static String infixToPrefix(String s) {
        int n = s.length();

        // Step 1: reverse and swap brackets
        char[] rev = new char[n];
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(n - 1 - i);
            if (ch == '(') rev[i] = ')';
            else if (ch == ')') rev[i] = '(';
            else rev[i] = ch;
        }

        // Step 2: infix -> postfix (with modified associativity rule)
        StringBuilder out = new StringBuilder();
        Deque<Character> stack = new ArrayDeque<>();

        for (char ch : rev) {
            if (Character.isLetterOrDigit(ch)) {
                out.append(ch);
            } else if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    out.append(stack.pop());
                }
                stack.pop(); // remove '('
            } else {
                if (ch == '^') {
                    while (!stack.isEmpty() && stack.peek() != '('
                            && prec(stack.peek()) >= prec(ch)) {
                        out.append(stack.pop());
                    }
                } else {
                    while (!stack.isEmpty() && stack.peek() != '('
                            && prec(stack.peek()) > prec(ch)) {
                        out.append(stack.pop());
                    }
                }
                stack.push(ch);
            }
        }

        while (!stack.isEmpty()) {
            out.append(stack.pop());
        }

        // Step 3: reverse postfix to get prefix
        return out.reverse().toString();
    }
}