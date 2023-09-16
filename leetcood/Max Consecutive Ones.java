//Given a binary array nums, return the maximum number of consecutive 1's in the array.

/*Method one：找到1连续的数量，使用两个指针的方法*/
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCon = 0;
        int curCon = 0;//current  index
        
        for(int i=0; i<nums.length; i++){
            if( nums[i] ==1 && curCon ==0){
                curCon = 1;
            }else if( nums[i] == 1 && curCon >0){
                curCon++;
            }else{
                if(maxCon < curCon){
                    maxCon = curCon;
                }
                curCon = 0;
            }
        }
        if(maxCon < curCon){
            maxCon = curCon;
        }
      return maxCon;  
    }
}