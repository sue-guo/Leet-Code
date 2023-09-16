/** hard！！！
 * Given an integer array nums, return the maximum difference between two successive elements in its sorted form. If the array contains less than two elements, return 0.

You must write an algorithm that runs in linear time and uses linear extra space.
 */


//method 1:使用桶排序的思想(没完成)



//Method 2: 直接sort后比较相邻的gap，直到找出最大的

class Solution {
    public int maximumGap(int[] nums) {
        int maxGap = 0;
        if(nums.length < 2){
            return maxGap;
        }
        Arrays.sort(nums);
        
        for(int i=1; i<nums.length; i++){
            int gap = nums[i]-nums[i-1];   
            if(maxGap<gap){
                maxGap = gap;
            }
        }
        return maxGap;
    }
}