class Solution {
    public int maxValue(int arr[]) {
        // code here
        int n = arr.length;
        int max1= Integer.MIN_VALUE, min1 = Integer.MAX_VALUE;
        int max2= Integer.MIN_VALUE, min2 = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            int val1= arr[i] + i;
            max1= Math.max(max1, val1);
            min1= Math.min(min1, val1);
            
            int val2= arr[i] - i;
            max2= Math.max(max2, val2);
            min2= Math.min(min2, val2);
        }
        return Math.max(max1-min1, max2-min2);
    }
};