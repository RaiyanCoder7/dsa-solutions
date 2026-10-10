class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length <= 1) {
            return intervals;
        }
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> merged = new ArrayList<>();
        int[] currentIntervals = intervals[0];
        merged.add(currentIntervals);
        for(int i = 1; i < intervals.length; i++) {
            int nextStart = intervals[i][0];
            int nextEnd = intervals[i][1];
            if(nextStart <= currentIntervals[1]) {
                currentIntervals[1] = Math.max(currentIntervals[1], nextEnd);
            } else {
                currentIntervals = intervals[i];
                merged.add(currentIntervals);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}