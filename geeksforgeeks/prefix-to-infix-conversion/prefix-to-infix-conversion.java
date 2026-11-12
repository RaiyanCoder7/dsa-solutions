class Solution {
    public String preToInfix(String s) {
        Deque<String> stack = new ArrayDeque<>();
        for(int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if(Character.isLetterOrDigit(ch)) {
                stack.push(String.valueOf(ch));
            } else {
                String op1 = stack.pop();
                String op2 = stack.pop();
                String expr = "(" + op1 + ch + op2 + ")";
                stack.push(expr);
            }
        }
        return stack.pop();
    }
}
