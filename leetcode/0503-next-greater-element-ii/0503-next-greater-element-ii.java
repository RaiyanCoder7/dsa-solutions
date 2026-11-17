class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        // We iterate from 2n - 1 down to 0 to simulate the circular array twice
        for (int i = 2 * n - 1; i >= 0; i--) {
            int currIndex = i % n;
            int current = nums[currIndex];

            // Pop all elements from stack that are smaller than or equal to current
            while (!stack.isEmpty() && stack.peek() <= current) {
                stack.pop();
            }

            // For the second half of the loop (actual valid indices from n-1 down to 0)
            if (i < n) {
                if (stack.isEmpty()) {
                    result[currIndex] = -1;
                } else {
                    result[currIndex] = stack.peek();
                }
            }

            // Push current element onto the stack
            stack.push(current);
        }

        return result;
    }
}