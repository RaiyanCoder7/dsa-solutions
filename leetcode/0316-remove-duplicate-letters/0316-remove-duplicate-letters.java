class Solution {
    public String removeDuplicateLetters(String s) {
        int[] lastIndex = new int[26];
        boolean[] inStack = new boolean[26];

        // Record the last index of every character
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int idx = ch - 'a';

            // Already in stack -> skip to avoid duplicates and preserve order
            if (inStack[idx]) {
                continue;
            }

            // Pop larger characters on top if they appear again later in s
            while (!stack.isEmpty() && stack.peek() > ch && lastIndex[stack.peek() - 'a'] > i) {
                char popped = stack.pop();
                inStack[popped - 'a'] = false;
            }

            stack.push(ch);
            inStack[idx] = true;
        }

        // Build result from bottom to top of the stack
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.removeLast());
        }

        return sb.toString();
    }
}