class Solution {
    public int evalRPN(String[] tokens) {
        int[] stack = new int[tokens.length];
        int top = -1;
        for(String token : tokens) {
            switch(token) {
                case "+" :
                    stack[top - 1] = stack[top - 1] + stack[top];
                    top--;
                    break;
                case "-" :
                    stack[top - 1] = stack[top - 1] - stack[top];
                    top--;
                    break;
                case "*" :
                    stack[top - 1] = stack[top - 1] * stack[top];
                    top--;
                    break;
                case "/" :
                    stack[top - 1] = stack[top - 1] / stack[top];
                    top--;
                    break;
                default :
                    top++;
                    stack[top] = Integer.parseInt(token);
                    break;
            }
        }
        return stack[top];
    }
}