class Solution {
    public String removeKdigits(String num, int k) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char ch : num.toCharArray()) {
            // Remove larger preceding digits while k > 0
            while (!stack.isEmpty() && k > 0 && stack.peek() > ch) {
                stack.pop();
                k--;
            }
            stack.push(ch);
        }

        // If k removals remain, pop from the top (largest digits at the end)
        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }

        // Build string from bottom to top of the stack
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.removeLast());
        }

        // Strip leading zeros
        int idx = 0;
        while (idx < sb.length() && sb.charAt(idx) == '0') {
            idx++;
        }

        String result = sb.substring(idx);
        return result.isEmpty() ? "0" : result;
    }
}