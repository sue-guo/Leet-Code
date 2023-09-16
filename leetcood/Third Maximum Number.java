Given an integer array nums, return the third distinct maximum number in this array. If the third maximum does not exist, return the maximum number.
-find an O(n) solution.

//method One : runtime is 28%, memory usage is 92%
class Solution {
    public int thirdMax(int[] nums) {
       //add to a set
        Set<Integer> set = new HashSet<>();
        for(int a :nums){
            set.add(a);
        }
        //set toarray
        Integer[] arr = set.toArray(new Integer[set.size()]);
        //array sort
        Arrays.sort(arr);
        
        if(arr.length >= 3){
            return arr[arr.length-3];
        }else{
            return arr[arr.length-1];
        }
        
    }
}



// method two : 3 variables,

class Solution {
    public int thirdMax(int[] nums) { 
        Integer firstM= null,secodeM=null,thirdM=null ;
        for(Integer a:nums){
            if(a.equals(firstM)||a.equals(secodeM) || a.equals(secodeM)){
                continue;
            }
            if(firstM == null || a > firstM){
                thirdM = secodeM;
                secodeM = firstM;
                firstM = a;
            }else if(secodeM == null || a >=secodeM){
                thirdM = secodeM;
                secodeM = a;
            }else if(thirdM ==null || a >=thirdM){
                thirdM = a;
            }
        }
        return thirdM==null? firstM:thirdM;
        
    }
}