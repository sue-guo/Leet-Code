/**Given an array arr, replace every element in that array with the greatest element among the elements to its right, and replace the last element with -1.

After doing so, return the array. */

class Solution {
    public int[] replaceElements(int[] arr) {
        if(arr.length == 1){
            arr[0] = -1;
            return arr;
        }
        int j = 0;//右边最大值的坐标
        int tempMax = arr[1];
        for(int i=0; i<arr.length-1; i++){
            if(j==0 || j<=i){
               int k=i+1;//i右边开始找最大值，k为坐标
               tempMax = arr[k];
               while(k< arr.length){
                    if (arr[k]>tempMax){
                        tempMax = arr[k];
                        j=k;
                    }
                    k++;
                } 
                
            }
           arr[i] = tempMax;    
        }
        arr[arr.length-1] = -1;
        return arr;
    }
}