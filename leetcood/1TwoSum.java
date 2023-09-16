/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.
 */

// Mrthod 1: 数组遍历 运行时间长(45ms) o(n*n)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] a =new int[2];
        boolean b = true;
        for(int i=0; i<nums.length-1 && b ; i++){         
            for(int j = i+1; j<nums.length; j++){            
                if(nums[i]+nums[j] == target){
                    a[0]=i;
                    a[1]=j;
                    b = false;
                    break;
                }
            }
        }
        return a;
    }
}

//Method 2: 使用map 运行时间短（2ms） o(n);
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] a =new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<nums.length ; i++){    
            if(map.containsKey(target-nums[i])){
                a[0] = i;
                a[1] = map.get(target-nums[i]);
                break;
            }     
            map.put(nums[i],i);
        }
        return a;
    }
}