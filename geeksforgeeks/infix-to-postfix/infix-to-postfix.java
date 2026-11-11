class Solution {
    private static int precedence(char ch) {
        if(ch == '+' || ch == '-') return 1;
        if(ch == '*' || ch == '/') return 2;
        if(ch == '^') return 3;
        return -1;
    }
    public static String infixToPostfix(String s) {
        StringBuilder result = new StringBuilder();
        Deque<Character> stack = new ArrayDeque<>();
        for(char ch : s.toCharArray()) {
            if(Character.isLetterOrDigit(ch)) {
                result.append(ch);
            } else if(ch == '(') {
                stack.push(ch);
            } else if(ch == ')') {
                while(!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    int topVIP = precedence(stack.peek());
                    int myVIP = precedence(ch);
                    if(topVIP > myVIP || (topVIP == myVIP && ch != '^')) {
                        result.append(stack.pop());
                    } else {
                        break;
                    }
                }
                stack.push(ch);
            }
        }
        while(!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.toString();
    }
}