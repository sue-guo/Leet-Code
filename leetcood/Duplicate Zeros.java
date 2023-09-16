//Given a fixed-length integer array arr, duplicate each occurrence of zero, shifting the remaining elements to the right.
//Note that elements beyond the length of the original array are not written. Do the above modifications to the input array in place and do not return anything.

class Solution {
    public void duplicateZeros(int[] arr) {
        for(int i=0; i<arr.length-1; i++){
            
            if(arr[i] == 0){
                for(int j=arr.length-1; j>i; j--){
                    arr[j] = arr[j-1];
                }
                arr[i+1]=arr[i];
                i++;
            }
        }
        
    }
}