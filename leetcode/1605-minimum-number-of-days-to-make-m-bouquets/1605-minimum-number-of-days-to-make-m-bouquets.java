class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if((long) m*k > bloomDay.length) {
            return -1;
        }
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        for(int day : bloomDay) {
            low = Math.min(low, day);
            high = Math.max(high, day);
        }
        int ans = -1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(CanMakeBouquets(bloomDay, mid, m, k)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private boolean CanMakeBouquets(int[] bloomDay, int day, int m, int k) {
        int bouquets= 0;
        int consecutive = 0;
        for(int b : bloomDay) {
            if(b <= day) {
                consecutive++;
                if(consecutive ==k) {
                    bouquets++;
                    consecutive = 0;
                }
            } else {
                consecutive = 0;
            }
        }
        return bouquets >= m;
    }
}