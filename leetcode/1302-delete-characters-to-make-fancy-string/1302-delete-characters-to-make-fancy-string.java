class Solution {
    public String makeFancyString(String s) {
       StringBuilder sb = new StringBuilder();
       for(int i = 0; i < s.length(); i++) {
        char ch = s.charAt(i);
        int len = sb.length();
        if(len < 2 || !(sb.charAt(len - 1) == ch && sb.charAt(len - 2) == ch)) {
            sb.append(ch);
        }
       }
       return sb.toString();
    }
}