class Solution {
    public int aggressiveCows(int[] arr, int k) {
        // code here
        Arrays.sort(arr);
        int n = arr.length;
        int low = 1;
        int high = arr[n-1]-arr[0];
        int ans = 1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(CanWePlace(arr, mid, k)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
    
    private boolean CanWePlace(int[] arr, int dist, int k) {
        int cowsCount = 1;
        int lastStall = arr[0];
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] - lastStall >= dist) {
                cowsCount++;
                lastStall = arr[i];
            }
            if(cowsCount >= k) {
                return true;
            }
        }
        return false;
    }
}