Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.
-Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.


Method One: Use set to remove dulipcates, then traverse 1-n, compare with set;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int a : nums){
            set.add(a);
        }
        for(int i=1; i<= nums.length; i++){
            if(!set.contains(i)){
                set.add(i);
            }else{
                set.remove(i);
            }
        }
        List<Integer> list = List.copyOf(set);
        return list;
    }
} 

Method Two:  in-place option. runtime is very long. 思路就是遍历数组 数组i的值对应的位置赋0 ， 不为0就是没有这个数字

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for(int i=0; i< nums.length; i++){
            if(nums[i] !=0 && nums[nums[i]-1]!=0){
                int temp = nums[i];
                nums[i] = nums[nums[i]-1]; 
                nums[temp-1] = 0;
                i--;
            }
           
        }
        List<Integer> list = new ArrayList<Integer>();
        for(int i=0; i< nums.length; i++){
            System.out.println(nums[i]);
            if(nums[i] !=0){
                list.add(i+1);
            }
        }
                return list;
    }
} 