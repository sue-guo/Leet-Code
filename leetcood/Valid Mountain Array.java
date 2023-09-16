/**Given an array of integers arr, return true if and only if it is a valid mountain array.

Recall that arr is a mountain array if and only if:

arr.length >= 3
There exists some i with 0 < i < arr.length - 1 such that:
arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
arr[i] > arr[i + 1] > ... > arr[arr.length - 1] */
//Method ： 满足条件必须是 有递增和递减
class Solution {
    public boolean validMountainArray(int[] arr) {
        if(arr.length < 3){
            return false;
        }
        int incr = 0;//递增的标志
        int decr = 0;//递减的标志
        for(int i=1; i<arr.length;i++){
            if(arr[i-1] < arr[i] && decr==0){//增的时候不能有减
                incr ++;
            }else if(arr[i-1] > arr[i] && incr!=0){//减的时候必须有增
                decr++;
            }else{
                return false;
            }
        }
         if(incr>0 && decr>0) return true;
        return false;
    }
}