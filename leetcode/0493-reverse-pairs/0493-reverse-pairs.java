class Solution {
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        int[] temp = new int[nums.length];
        return mergeSort(nums, temp, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int[] temp, int low, int high) {
        if (low >= high) {
            return 0;
        }

        int mid = low + (high - low) / 2;
        int count = 0;

        count += mergeSort(nums, temp, low, mid);
        count += mergeSort(nums, temp, mid + 1, high);
        count += countPairs(nums, low, mid, high);

        merge(nums, temp, low, mid, high);

        return count;
    }

    private int countPairs(int[] nums, int low, int mid, int high) {
        int count = 0;
        int right = mid + 1;

        // For each element in the left half, advance 'right' as long as condition holds
        for (int i = low; i <= mid; i++) {
            while (right <= high && (long) nums[i] > 2L * nums[right]) {
                right++;
            }
            // All elements from (mid + 1) to (right - 1) satisfy nums[i] > 2 * nums[right]
            count += (right - (mid + 1));
        }

        return count;
    }

    private void merge(int[] nums, int[] temp, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        int k = low;

        while (i <= mid && j <= high) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = nums[i++];
        }

        while (j <= high) {
            temp[k++] = nums[j++];
        }

        // Copy back to nums so subsequent levels receive a sorted subarray
        for (int idx = low; idx <= high; idx++) {
            nums[idx] = temp[idx];
        }
    }
}