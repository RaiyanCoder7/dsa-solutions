class StockSpanner {
    // Stack stores int[] where:
    // element[0] = price
    // element[1] = accumulated span for that price
    private Deque<int[]> stack;

    public StockSpanner() {
        stack = new ArrayDeque<>();
    }
    
    public int next(int price) {
        int span = 1;

        // While stack has previous prices <= current price, absorb their spans
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            span += stack.pop()[1];
        }

        // Push current price and its calculated span onto the stack
        stack.push(new int[] { price, span });

        return span;
    }
}