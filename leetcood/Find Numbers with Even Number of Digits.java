//Given an array nums of integers, return how many of them contain an even number of digits.


//Method：
class Solution {
    public int findNumbers(int[] nums) {
        int evenNum = 0;
        for (int i=0 ; i< nums.length; i++){
           
            if(findDigits(nums[i]) % 2 == 0){//even digits
                evenNum++;
            }
        }
        return evenNum;
        
    }
    
    int findDigits(int a){ //contains how many digits 查找有几位数
        double b = a;
        int digits= 0;
        
        while(b >=1){
                b /= 10;
                digits++;
        }
        
        return digits;
    }
}