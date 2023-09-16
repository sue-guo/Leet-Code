// Height Checker
class Solution {
    public int heightChecker(int[] heights) {
        int n = heights.length;
        if(n>1){
            int[] arr = new int[n];
            int k = 0;//num of return;
            for(int i=0;i<n; i++){//new array arr
                arr[i]=heights[i];
            }
            for(int i=0;i<n-1; i++){// sorting arr
              for(int j=i+1;j<n; j++){
                  
                  if(arr[i] > arr[j]){
                      int temp = arr[j];
                      arr[j]=arr[i];
                      arr[i]= temp;
                  }
                  
              }
                
            }
            for(int i=0;i<n; i++){
                if(heights[i] != arr[i]) k++;
            }
            return k;
        }else{
            return 0;
        }
        
        
    }
}
//or use java array method;
class Solution {
    public int heightChecker(int[] heights) {
            int[] arr = new int[heights.length];
            int k = 0;//num of return;
            arr = Arrays.copyOf(heights,heights.length);
            // sorting arr
            Arrays.sort(arr);
            //compare the two array
            for(int i=0;i<heights.length; i++){
                if(heights[i] != arr[i]) k++;
            }
            return k;
        
        
    }
}