class Solution {
    public int median(int[][] mat) {
        // code here
        int n = mat.length;
        int m = mat[0].length;
        int low = mat[0][0];
        int high = mat[0][m-1];
        for(int i = 0; i < n; i++) {
            low = Math.min(low, mat[i][0]);
            high = Math.max(high, mat[i][m-1]);
        }
        int required = (n*m+1)/2;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            int count = 0;
            for(int i = 0; i < n; i++) {
                count+= CountSmallerOrEqual(mat[i], mid);
            }
            if(count < required) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return low;
    }
    private int CountSmallerOrEqual(int[] row, int x) {
        int l = 0;
        int h = row.length-1;
        while(l <= h) {
            int mid = l+(h-l)/2;
            if(row[mid] <= x) {
                l= mid+1;
            } else {
                h = mid-1;
            }
        }
        return l;
    }
}