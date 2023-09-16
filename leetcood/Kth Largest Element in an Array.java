/** Given an integer array nums and an integer k, return the kth largest element in the array.

Note that it is the kth largest element in the sorted order, not the kth distinct element.*/


//Method : 先使用maxHeap排序，再返回0下标的数字
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        for(int i = n/2-1; i>=0;i--){
            maxHeapify(nums, n , i);
        }
        int j = 0;
        for(int i=n-1; i>=0; i--){
            //System.out.println(Arrays.toString(nums));
            j++; 
            if(j != k){
                int temp = nums[0];
                nums[0] = nums[i];
                nums[i] = temp; 
                maxHeapify(nums,i,0);      
            }else{
                break;
            }
        }
        return nums[0];
    }
    
    // //MaxHeap 算法
    void maxHeapify(int[] arr,int len,int index){
        int left = index*2 +1;
        int right = index*2+2;
        int greatest = index;
        if(left < len && arr[left] > arr[greatest]){
            greatest = left;
        }
        if(right < len && arr[right] > arr[greatest]){
            greatest = right;
        }
        if(greatest != index){
            int temp = arr[index];
            arr[index] = arr[greatest];
            arr[greatest] = temp;
            
            maxHeapify(arr, len , greatest);
        }
    }
    //MinHeap 算法
//     void minHeapify(int[] arr, int len, int index){
//         int left = index*2 +1;
//         int right = index*2+2;
//         int smallest = index;
//         if(left < len && arr[left] < arr[smallest]){
//             smallest = left;
//         }
//         if(right < len && arr[right] < arr[smallest]){
//             smallest = right;
//         }
//         if(smallest != index){
//             int temp = arr[index];
//             arr[index] = arr[smallest];
//             arr[smallest] = temp;
            
//             minHeapify(arr, len , smallest);
//         }
//     }
}