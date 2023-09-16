/**Given an integer array nums, move all the even integers at the beginning of the array followed by all the odd integers.

Return any array that satisfies this condition. */

class Solution {
    public int[] sortArrayByParity(int[] nums) {
        if(nums.length <=1) return nums;
        
        int j = nums.length-1;
        for(int i=0; i<j; i++){
            if(nums[i]%2!=0){//odd
                if(nums[j]%2 !=0){//
                    j--;
                    i--;
                }else{//even
                    int temp= nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                    j--;
                }
            }
        }
        return nums;
    }
}