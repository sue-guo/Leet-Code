/**You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.

Merge nums1 and nums2 into a single array sorted in non-decreasing order.

The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n. */

//Method

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
       if(m==0){//nums1 is null, nums2 复制给nums1；nums2 is null，不用操作
           for(int i=0; i<n;i++){
            nums1[i]=nums2[i];
           }
       }else if(m>0 && n>0){
           
           for(int i=0; i<n;i++){
               int in = m-1+i;//nums1非零最后一位 所在得下标，遍历nums2，对比大小
               if(nums1[in]<=nums2[i]){
                  nums1[in+1]=nums2[i];
               }else{
                   
                  while(nums1[in]>nums2[i]){
                       nums1[in+1] = nums1[in];
                       in--;
                      if (in<0){
                          break;
                      }
                      //System.out.println("Count is: " + in);
                   }
                   
                   
                  nums1[in+1]=nums2[i];
               }
           }
       }
        
    }
}