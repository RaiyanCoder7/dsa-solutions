class Solution {
    public int nthRoot(int n, int m) {
        // code here
        if(m == 0) return 0;
        if(m == 1 || n == 1) return m;
        int low = 1;
        int high = m;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            int status = Checkpower(mid, n, m);
            if(status == 1) {
                return mid;
            } else if(status == 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
    
    private int Checkpower(int mid, int n, int m) {
        long prod = 1;
        for(int i = 1; i <= n; i++) {
            prod*= mid;
            if(prod > m) {
                return 2;
            }
        }
        if(prod == m) return 1;
        return 0;
    }
}