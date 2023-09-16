/**Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
You must solve this problem without using the library's sort function. */

//Method
class Solution {
    public void sortColors(int[] nums) {
        int num0 = 0;
        int num1 = 0;
        int num2 = 0;
        for(int a:nums){
            if(a==0){
                num0++;
            }else if(a==1){
                num1++;
            }else{
                num2++;
            }
        }
        
        for(int i=0; i<nums.length; i++){
            if(i< num0){
                nums[i] = 0;
            }else if(i>= nums.length-num2){
                nums[i] = 2;
            }else{
                nums[i] = 1;
            }
        }
    }
}