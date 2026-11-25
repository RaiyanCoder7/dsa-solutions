class Solution {
    public long subArrayRanges(int[] nums) {
        return sumSubarrayMaxs(nums) - sumSubarrayMins(nums);
    }

    private long sumSubarrayMins(int[] nums) {
        int n = nums.length;
        long total = 0;
        Deque<Integer> stack = new ArrayDeque<>(); // Monotonic increasing indices

        for (int i = 0; i <= n; i++) {
            long currVal = (i == n) ? Long.MIN_VALUE : nums[i];

            while (!stack.isEmpty() && nums[stack.peek()] >= currVal) {
                int mid = stack.pop();
                int nseIdx = i;
                int pseeIdx = stack.isEmpty() ? -1 : stack.peek();

                long left = mid - pseeIdx;
                long right = nseIdx - mid;
                total += (long) nums[mid] * left * right;
            }
            stack.push(i);
        }

        return total;
    }

    private long sumSubarrayMaxs(int[] nums) {
        int n = nums.length;
        long total = 0;
        Deque<Integer> stack = new ArrayDeque<>(); // Monotonic decreasing indices

        for (int i = 0; i <= n; i++) {
            long currVal = (i == n) ? Long.MAX_VALUE : nums[i];

            while (!stack.isEmpty() && nums[stack.peek()] <= currVal) {
                int mid = stack.pop();
                int ngeIdx = i;
                int pgeeIdx = stack.isEmpty() ? -1 : stack.peek();

                long left = mid - pgeeIdx;
                long right = ngeIdx - mid;
                total += (long) nums[mid] * left * right;
            }
            stack.push(i);
        }

        return total;
    }
}