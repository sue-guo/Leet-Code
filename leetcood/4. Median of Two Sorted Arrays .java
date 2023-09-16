
/**
 * 4. Median of Two Sorted Arrays
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).
 */
//Median = X[(l-1)/2] if length is odd; (X[l/2]+X[l/2 - 1])/2 if length is even

//方法一： 两个指针，分别遍历两个数组，比较大小放入新的数组中,只用遍历l/2的长度就行，然后再计算（运行时间2ms）
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int l = m+n;
        double r = 0;
        int index = 0,i=0, j=0;//index 表示新数组的下标
        int[] arr = new int[l/2+1];
        while(index <= l/2){
            if(i==m){//nums1 遍历完了
                arr[index] = nums2[j];
                j++;
            }else if(j== n){//nums2 done
                arr[index] = nums1[i];
                i++;
            }else{
                if(nums1[i]<=nums2[j]){
                    arr[index] = nums1[i];
                    i++;
                }else{               
                    arr[index] = nums2[j];
                    j++;              
                }
            }
            
            index++;
        }
        //System.out.println(Arrays.toString(arr));
        if((m+n)%2==0){//even
        //System.out.println("even"+arr[l/2]+"+"+arr[l/2-1]);
            r = (double)(arr[l/2]+arr[l/2-1])/2;
        }else{//odd
            r = arr[(m+n-1)/2];
        }
        return r;
    }

}

//方法二： 类似方法一，只是不用创建新数组存放数据，只需要得到中间位置的两个数即可，运行时间1ms
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int l = m+n;
        double r = 0;
        int index = 1,i=0, j=0; //index 表示当前操作步骤数
        int currntVal = 0,lastVal = 0;    
        while(index <= l/2+1){
            
            if(i==m){//nums1 遍历完了
                lastVal = currntVal;
                currntVal = nums2[j]; 
                j++;
            }else if(j== n){//nums2 done  
                lastVal = currntVal;  
                currntVal = nums1[i];          
                i++;
            }else{
                if(nums1[i]<=nums2[j]){ 
                    lastVal = currntVal;
                    currntVal = nums1[i];                 
                    i++;
                }else{  
                    lastVal = currntVal;  
                    currntVal = nums2[j];                             
                    j++;              
                }
            }          
            index++;          
        }

        if(l%2==0){//even
            r = (double)(currntVal+lastVal)/2;
        }else{//odd
            r = currntVal;
        }
        return r;
    }
}