

class Solution {
    public int removeElement(int[] nums, int val) {
        int numofV = 0;
        int i = 0,j = nums.length-1;//i j 分别从两边遍历
        while(i<=j){
            if(nums[i]== val && nums[j] !=val){//当前是要找的数字，最后一位不是 switft。
                
                // System.out.println(i);
                nums[i]=nums[j];
                nums[j]=val;
                i++;
                j--;
                numofV++;
            }else if(nums[i] == val && nums[j] == val){// 最后一位是要找的数字，j--
                j--;
                numofV++;
            }else if(nums[i]!= val){
                i++;
            }
        }
        //System.out.println(numofV);
        return nums.length-numofV;
    }
}