class Solution {
    static String postToPre(String s) {
        Deque<String> stack = new ArrayDeque<>();

        // Traverse from left to right
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isLetterOrDigit(ch)) {
                // Push operand as a String
                stack.push(String.valueOf(ch));
            } else {
                // Operator encountered: pop top two operands
                String op2 = stack.pop(); // Right operand (pushed later)
                String op1 = stack.pop(); // Left operand (pushed earlier)

                // Combine into Prefix format: "operator + op1 + op2"
                String expr = ch + op1 + op2;
                stack.push(expr);
            }
        }

        return stack.pop();
    }
}
