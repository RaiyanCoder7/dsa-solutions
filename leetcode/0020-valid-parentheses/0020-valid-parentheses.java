class Solution {
    public boolean isValid(String s) {
        if(s.length() % 2 != 0) {
            return false;
        }
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for(char ch : s.toCharArray()) {
            if(ch == '(') {
                stack.push(')');
            } else if(ch == '{') {
                stack.push('}');
            } else if(ch == '[') {
                stack.push(']');
            } else {
                if(stack.isEmpty() || stack.pop() != ch) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}