class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int bestRow = 0;
        int maxOnes = -1;
        for(int i = 0; i < mat.length; i++) {
            int currentOnes = 0;
            for(int j = 0; j < mat[i].length; j++) {
                currentOnes+= mat[i][j];
                if(currentOnes > maxOnes) {
                    maxOnes = currentOnes;
                    bestRow = i;
                }
            }
        }
        return new int[]{bestRow, maxOnes};
    }
}