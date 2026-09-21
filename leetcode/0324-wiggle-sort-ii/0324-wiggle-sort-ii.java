class Solution {
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        int ptr = n - 1;
        for (int i = 1; i < n; i += 2) {
            nums[i] = sorted[ptr--];
        }
        for (int i = 0; i < n; i += 2) {
            nums[i] = sorted[ptr--];
        }
    }
}