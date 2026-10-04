class Solution {
    public int splitArray(int[] nums, int k) {
        long low = 0;
        long high = 0;
        for(int num : nums) {
            low = Math.max(low, num);
            high+= num;
        }
        long ans = high;
        while(low <= high) {
            long mid = low + (high-low) / 2;
            if(CanSplit(nums, mid, k)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return (int) ans;
    }

    private boolean CanSplit(int[] nums, long maxSumLimit, int k) {
        int subArrayCount = 1;
        long currentSum = 0;
        for(int num : nums) {
            if(currentSum + num > maxSumLimit) {
                subArrayCount++;
                currentSum = num;
            } else {
                currentSum+= num;
            }
        }
        return subArrayCount <= k;
    }
}