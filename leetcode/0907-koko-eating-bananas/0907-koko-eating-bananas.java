class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;
        for(int pile : piles) {
            high = Math.max(high, pile);
        }
        int ans = high;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(CanFinish(piles, mid, h)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private boolean CanFinish(int[] piles, int k, int h) {
        long totalHours = 0;
        for(int pile : piles) {
            totalHours+= (pile + k - 1) / k;
            if(totalHours > h) {
                return false;
            }
        }
        return totalHours <= h;
    }
}