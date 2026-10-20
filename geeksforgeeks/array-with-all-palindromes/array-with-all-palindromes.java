class Solution {
    public static boolean isPalinArray(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            int original = arr[i];
            int rev = 0;
            int num = arr[i];
            while(num > 0) {
                int digit = num%10;
                rev = (rev * 10) + digit;
                num/= 10;
            }
            if(original != rev) {
                return false;
            }
        }
        return true;
    }
}