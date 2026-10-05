class Solution {
    public double minMaxDist(int[] stations, int k) {
        // code here
        int n = stations.length;

        double low = 0.0;
        double high = 0.0;

                // Find the maximum existing gap between adjacent stations
        for (int i = 0; i < n - 1; i++) {
            high = Math.max(high, stations[i + 1] - stations[i]);
        }

                // Precision threshold for 6 decimal places
        double diff = 1e-6;

                // Run until interval is smaller than precision (or use ~80 fixed iterations)
        while (high - low > diff) {
            double mid = low + (high - low) / 2.0;

            if (countRequiredStations(stations, mid) <= k) {
                high = mid; // Feasible to achieve max dist 'mid', try smaller
            } else {
                low = mid;  // Need more than k stations, increase allowed distance
            }
        }

        return high;
    }

    private int countRequiredStations(int[] stations, double dist) {
        int count = 0;
        for (int i = 0; i < stations.length - 1; i++) {
            double gap = stations[i + 1] - stations[i];
            count += (int) (gap / dist);
        }
        return count;
    }
}
