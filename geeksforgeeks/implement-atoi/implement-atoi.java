class Solution {
    public int myAtoi(String s) {
        // code here
        if(s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int i = 0;
        // skip space
        while(i < n && s.charAt(i) == ' ') {
            i++;
        }
        if(i == n) {
            return 0;
        }
        //read sign
        int sign = 1;
        if(s.charAt(i) == '-' || s.charAt(i) == '+') {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }
        // recurse through digits
        return helper(s, i, 0, sign);
    }
    
    private int helper(String s, int i, int current, int sign) {
        //end of string or non digit encountered
        if(i >= s.length() || !Character.isDigit(s.charAt(i))) {
            return current * sign;
        }
        int digit = s.charAt(i) - '0';
        //overflow check
        if(current > Integer.MAX_VALUE / 10 || (current == Integer.MAX_VALUE / 10 && digit > 7)) {
            return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        return helper(s, i+1, current * 10 + digit, sign);
    }
}