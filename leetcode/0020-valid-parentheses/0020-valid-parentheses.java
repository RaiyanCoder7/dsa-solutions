class Solution {
    public boolean isValid(String s) {
        // Odd length strings can never be balanced
        if (s.length() % 2 != 0) {
            return false;
        }

        Deque<Character> stack = new ArrayDeque<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push(')');
            } else if (ch == '{') {
                stack.push('}');
            } else if (ch == '[') {
                stack.push(']');
            } else {
                // Encountered a closing bracket:
                // 1. stack is empty (extra closing bracket)
                // 2. top doesn't match current closing bracket
                if (stack.isEmpty() || stack.pop() != ch) {
                    return false;
                }
            }
        }

        // Stack must be empty at the end (all opened were closed)
        return stack.isEmpty();
    }
}