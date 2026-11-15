class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> nextGreaterMap = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();

        // 1. Traverse nums2 from right to left
        for (int i = nums2.length - 1; i >= 0; i--) {
            int current = nums2[i];

            // Pop all smaller or equal elements from stack
            while (!stack.isEmpty() && stack.peek() <= current) {
                stack.pop();
            }

            // If stack is empty, no greater element exists to the right
            if (stack.isEmpty()) {
                nextGreaterMap.put(current, -1);
            } else {
                // Top of stack is the next greater element
                nextGreaterMap.put(current, stack.peek());
            }

            // Push current element onto the stack for future left elements
            stack.push(current);
        }

        // 2. Build result for nums1 using the precalculated map
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = nextGreaterMap.get(nums1[i]);
        }

        return result;
    }
}