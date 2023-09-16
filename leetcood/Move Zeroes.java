/**Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
Note that you must do this in-place without making a copy of the array.*/

class Solution {
    public void moveZeroes(int[] nums) {
        
        int firstZ =-1;//first 0 index ;
        for(int i=0; i<nums.length;i++){
            if(firstZ ==-1 && nums[i]==0){//find the first 0 index;
                firstZ = i;
            }else if(firstZ != -1 && nums[i] != 0){
                nums[firstZ] = nums[i];
                nums[i]=0;
                firstZ++;
            }
        }
    }
}