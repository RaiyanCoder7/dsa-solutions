class Solution {
    public String multiplyStrings(String s1, String s2) {
        boolean isNegative = false;
        if (s1.charAt(0) == '-') {
            isNegative = !isNegative;
            s1 = s1.substring(1);
        }
        if (s2.charAt(0) == '-') {
            isNegative = !isNegative;
            s2 = s2.substring(1);
        }

        int n1 = s1.length();
        int n2 = s2.length();
        int[] pos = new int[n1 + n2];

        for (int i = n1 - 1; i >= 0; i--) {
            int d1 = s1.charAt(i) - '0';
            for (int j = n2 - 1; j >= 0; j--) {
                int d2 = s2.charAt(j) - '0'; // Fixed: used 'j' instead of 'i'

                int sum = d1 * d2 + pos[i + j + 1]; // Fixed: d1 * d2 instead of n1 * n2
                pos[i + j + 1] = sum % 10;
                pos[i + j] += sum / 10; // Fixed: += instead of =
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int p : pos) {
            // Fixed: skip '0' only when string is still empty (leading zeros)
            if (!(sb.length() == 0 && p == 0)) {
                sb.append(p);
            }
        }

        if (sb.length() == 0) {
            return "0";
        }

        return isNegative ? "-" + sb.toString() : sb.toString();
    }
}