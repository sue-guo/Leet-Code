/**Given an array of integers nums, sort the array in ascending order and return it.

You must solve the problem without using any built-in functions in O(nlog(n)) time complexity and with the smallest space complexity possible. */

// 一般使用树结构的time complexity 是 logn

class Solution {
    public int[] sortArray(int[] nums) {
        int len = nums.length;
        // 把数据变成max heap，不用处理叶子node（len/2的数据是叶子数组） 
        for(int i =len/2-1; i>=0; i--){
            maxHeapify(nums,len,i);
        }
        for(int i= len-1; i>=0 ; i--){
            //先交换 0 与最大数
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;
            //
            maxHeapify(nums,i,0);
        }
        return nums;
    }
//生成maxheap
    void maxHeapify(int[] arr, int len, int index){
        int left = 2*index+1;
        int right = 2*index+2;
        int largest = index;
        if(left < len && arr[left]>arr[largest]){
            largest = left;
        }
        if(right < len && arr[right] > arr[largest]){
            largest = right;
        }
        //
        if(largest != index){
            int temp = arr[index];
            arr[index] = arr[largest];
            arr[largest] = temp;
            maxHeapify(arr, len, largest);
        }
    }
}