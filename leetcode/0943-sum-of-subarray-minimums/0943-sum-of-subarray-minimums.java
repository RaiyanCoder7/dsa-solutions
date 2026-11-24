class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        long mod = 1_000_000_007L;
        long total = 0;

        // Monotonic increasing stack storing indices
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i <= n; i++) {
            // Sentinel 0 at index n flushes all remaining elements
            int currVal = (i == n) ? 0 : arr[i];

            while (!stack.isEmpty() && arr[stack.peek()] >= currVal) {
                int mid = stack.pop();
                int nseIdx = i;
                int pseIdx = stack.isEmpty() ? -1 : stack.peek();

                long leftCount = mid - pseIdx;
                long rightCount = nseIdx - mid;

                long contrib = ((long) arr[mid] * leftCount) % mod;
                contrib = (contrib * rightCount) % mod;
                total = (total + contrib) % mod;
            }

            stack.push(i);
        }

        return (int) total;
    }
}