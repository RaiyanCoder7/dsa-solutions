class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int low = 0;
        int high = n-1;
        while(low <= high) {
            int midCol = low + (high - low) / 2;
            int maxRow = 0;
            for(int r = 0; r < m; r++) {
                if(mat[r][midCol] > mat[maxRow][midCol]) {
                    maxRow = r;
                }
            }
            int currVal = mat[maxRow][midCol];
            int leftNeighbor = (midCol > 0) ? mat[maxRow][midCol-1] : -1;
            int rightNeighbor = (midCol < n-1) ? mat[maxRow][midCol+1] : -1;
            if(currVal > leftNeighbor && currVal > rightNeighbor) {
                return new int[]{maxRow, midCol};
            } else if(rightNeighbor > currVal) {
                low = midCol+1;
            } else {
                high = midCol-1;
            }
        }
        return new int[]{-1, -1};
    }
}