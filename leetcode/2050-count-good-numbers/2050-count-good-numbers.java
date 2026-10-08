class Solution {
    private long MOD = 1_000_000_007L; 
    public int countGoodNumbers(long n) {
        long evenCount = (n + 1) / 2;
        long oddCount = n / 2;
        long waysEven = power(5, evenCount);
        long waysOdd = power(4, oddCount);
        return (int) ((waysEven * waysOdd) % MOD);
    }

    private long power(long base, long exp) {
        if(exp == 0) {
            return 1L;
        }
        long half = power(base, exp / 2);
        long halfSquare = (half * half) % MOD;
        if(exp % 2 == 1) {
            return (base * halfSquare) % MOD;
        }
        return halfSquare;
    }
}