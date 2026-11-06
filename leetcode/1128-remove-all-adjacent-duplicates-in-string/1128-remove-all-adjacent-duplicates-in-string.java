class Solution {
    public String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder();

        for (char ch : s.toCharArray()) {
            int len = sb.length();

            // If stack is not empty and top equals current character, pop
            if (len > 0 && sb.charAt(len - 1) == ch) {
                sb.deleteCharAt(len - 1);
            } else {
                // Otherwise, push current character
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}