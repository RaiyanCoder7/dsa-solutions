class Solution {
    public int[] sortArray(int[] nums) {
        if(nums == null || nums.length <= 1) {
            return nums;
        }
        int[] temp = new int[nums.length];
        mergeSort(nums, 0, nums.length-1, temp);
        return nums;
    }

    private void mergeSort(int[] nums, int low, int high, int[] temp) {
        if(low >= high) {
            return;
        }
        int mid = low + (high - low) / 2;
        mergeSort(nums, low, mid, temp);
        mergeSort(nums, mid+1, high, temp);
        merge(nums, low, mid, high, temp);
    }

    private void merge(int[] nums, int low, int mid, int high, int[] temp) {
        int i = low;
        int j = mid+1;
        int k = low;
        while(i <= mid && j <= high) {
            if(nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }
        while(i <= mid) {
            temp[k++] = nums[i++];
        }
        while(j <= high) {
            temp[k++] = nums[j++];
        }
        for(int idx = low; idx <= high; idx++) {
            nums[idx] = temp[idx];
        }
    }
}