class Solution {
    public double myPow(double x, int n) {
        long exp = n;
        if(exp < 0) {
            exp = -exp;
            return 1.0 / powerHelper(x, exp);
        }
        return powerHelper(x, exp); 
    }

    private double powerHelper(double x, long exp) {
        if(exp == 0) {
            return 1.0;
        }
        double half = powerHelper(x, exp / 2);
        if(exp % 2 == 0) {
            return half * half;
        } else {
            return x * half * half;
        }
    }
}