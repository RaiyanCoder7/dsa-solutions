class Solution {
    public int findPages(int[] arr, int k) {
        // code here
        int n = arr.length;
        if(k > n) {
            return -1;
        }
        long low = 0;
        long high = 0;
        for(int pages : arr) {
            low = Math.max(low, pages);
            high+= pages;
        }
        long ans = -1;
        while(low <= high) {
            long mid = low + (high - low) / 2;
            if(CanAllocate(arr, mid, k)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return (int) ans;
    }
    
    private boolean CanAllocate(int[] arr, long maxPagesLimit, int k) {
        int studentsCount = 1;
        long currentPages = 0;
        for(int pages : arr) {
            if(currentPages + pages > maxPagesLimit) {
                studentsCount++;
                currentPages = pages;
            } else {
                currentPages+= pages;
            }
        }
        return studentsCount <= k;
    }
}