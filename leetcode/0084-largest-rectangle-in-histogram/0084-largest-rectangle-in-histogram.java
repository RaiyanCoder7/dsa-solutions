class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Deque<Integer> stack = new ArrayDeque<>(); // Stores indices in increasing height order
        int maxArea = 0;

        for (int i = 0; i <= n; i++) {
            // Use height 0 at index n as a sentinel to pop all remaining bars
            int currHeight = (i == n) ? 0 : heights[i];

            while (!stack.isEmpty() && heights[stack.peek()] > currHeight) {
                int height = heights[stack.pop()];
                int nseIdx = i;
                int pseIdx = stack.isEmpty() ? -1 : stack.peek();
                int width = nseIdx - pseIdx - 1;
                maxArea = Math.max(maxArea, height * width);
            }

            stack.push(i);
        }

        return maxArea;
    }
}