class Solution {
    public List<Integer> majorityElement(int[] nums) {
       int c1 = 0, count1 = 0;
       int c2 = 0, count2 = 0;
       for(int num : nums) {
        if(count1 > 0 && num == c1) {
            count1++;
        } else if(count2 > 0 && num == c2) {
            count2++;
        } else if(count1 == 0) {
            c1 = num;
            count1 = 1;
        } else if(count2 == 0) {
            c2 = num;
            count2 = 1;
        } else {
            count1--;
            count2--;
        }
       }
       count1 = 0;
       count2 = 0;
       for(int num : nums) {
        if(num == c1) {
            count1++;
        } else if(num == c2) {
            count2++;
        }
       }
       List<Integer> result = new ArrayList<>();
       int threshold = nums.length/3;
       if(count1 > threshold) {
        result.add(c1);
       }
       if(count2 > threshold) {
        result.add(c2);
       }
       return result;
    }
}