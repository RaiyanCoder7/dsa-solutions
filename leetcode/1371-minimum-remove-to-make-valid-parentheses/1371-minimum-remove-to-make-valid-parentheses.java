class Solution {
    public String minRemoveToMakeValid(String s) {
        char[] arr = s.toCharArray();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == '(') {
                stack.push(i);
            } else if(arr[i] == ')') {
                if(!stack.isEmpty()) {
                    stack.pop();
                } else {
                    arr[i] = '*';
                }
            }
        }
        while(!stack.isEmpty()) {
            arr[stack.pop()] = '*';
        }
        StringBuilder result = new StringBuilder();
        for(char ch : arr) {
            if(ch != '*') {
                result.append(ch);
            }
        }
        return result.toString();
    }
}