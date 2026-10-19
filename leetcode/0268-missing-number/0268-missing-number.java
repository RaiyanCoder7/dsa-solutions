class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        long expectedSum = (long) n*(n+1)/2;
        int actualSum = 0;
        for(int val : nums) {
            actualSum+= val;
        }
        return (int) (expectedSum - actualSum);
    }
}