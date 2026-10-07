class Solution {
    public void reverseArray(int arr[]) {
        reverseHelper(arr, 0, arr.length-1);
    }
    
    private void reverseHelper(int[] arr, int left, int right) {
        if(left >= right) {
            return;
        }
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
        reverseHelper(arr, left+1, right-1);
    }
}