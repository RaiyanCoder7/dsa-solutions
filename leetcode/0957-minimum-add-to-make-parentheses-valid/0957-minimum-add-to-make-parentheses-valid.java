class Solution {
    public int minAddToMakeValid(String s) {
        int openCount = 0;
        int insertions = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                openCount++;
            } else { // ch == ')'
                if (openCount > 0) {
                    openCount--; // Successfully matched with a prior '('
                } else {
                    insertions++; // Needs an inserted '(' before it
                }
            }
        }

        // Remaining unmatched '(' also need matching ')'
        return insertions + openCount;
    }
}