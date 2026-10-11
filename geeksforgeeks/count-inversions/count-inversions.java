class Solution {
    public int inversionCount(int arr[]) {
        // code here
        if(arr == null || arr.length <= 1) {
            return 0;
        }
        int[] temp = new int[arr.length];
        return (int) mergeSortAndCount(arr, temp, 0, arr.length-1);
    }
    
    private long mergeSortAndCount(int[] arr, int[] temp, int low, int high) {
        long count = 0;
        if(low < high) {
            int mid = low + (high - low) / 2;
            count+= mergeSortAndCount(arr, temp, low, mid);
            count+= mergeSortAndCount(arr, temp, mid+1, high);
            count+= mergeAndCount(arr, temp, low, mid, high);
        }
        return count;
    }
    
    private long mergeAndCount(int[] arr, int[] temp, int low, int mid, int high) {
        int i = low;
        int j = mid+1;
        int k = low;
        long invCount = 0;
        while(i <= mid && j <= high) {
            if(arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                invCount+= (mid-i+1);
                temp[k++] = arr[j++];
            }
        }
        while(i <= mid) {
            temp[k++] = arr[i++];
        }
        while(j <= high) {
            temp[k++] = arr[j++];
        }
        for(int idx = low; idx <= high;idx++) {
            arr[idx] = temp[idx];
        }
        return invCount;
    }
}