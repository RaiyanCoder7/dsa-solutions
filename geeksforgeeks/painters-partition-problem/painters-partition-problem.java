class Solution {
    public int minTime(int[] arr, int k) {
        // code here
        long low = 0;
        long high = 0;
        for(int board : arr) {
            low = Math.max(low, board);
            high+= board;
        }
        long ans = high;
        while(low <= high) {
            long mid = low + (high - low) / 2;
            if(CanPaint(arr, mid, k)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return (int) ans;
    }
    
    private boolean CanPaint(int[] arr, long maxTimeLimit, int k) {
        int paintersNeeded = 1;
        long currentTime = 0;
        for(int board : arr) {
            if(currentTime + board > maxTimeLimit) {
                paintersNeeded++;
                currentTime = board;
            } else {
                currentTime+= board;
            }
        }
        return paintersNeeded <= k;
    }
}
