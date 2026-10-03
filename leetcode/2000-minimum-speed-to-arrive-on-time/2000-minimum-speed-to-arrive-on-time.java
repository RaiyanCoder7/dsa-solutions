class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int n = dist.length;

        // If hours available is <= n - 1, we can never take n trains
        if (hour <= n - 1) {
            return -1;
        }

        int low = 1;
        int high = 10_000_000;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canReach(dist, mid, hour)) {
                ans = mid;         // speed works, try to find a smaller speed
                high = mid - 1;
            } else {
                low = mid + 1;     // too slow, increase speed
            }
        }

        return ans;
    }

    private boolean canReach(int[] dist, int speed, double hour) {
        double totalTime = 0.0;
        int n = dist.length;

        // First n - 1 rides must wait for integer hours (ceil)
        for (int i = 0; i < n - 1; i++) {
            totalTime += (dist[i] + speed - 1) / speed;
        }

        // The final ride does not incur waiting time
        totalTime += (double) dist[n - 1] / speed;

        return totalTime <= hour;
    }
}