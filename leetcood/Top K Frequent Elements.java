/**Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order. */

/**使用桶排序的思想（Bucket sort），
先把元素+频率放入map，
再在把map 存入List<>[nums.length+1]数组，数组的下标就是频率，相同的频率的数字存放在list中,
最后从数组最大下标开始找出前k个数据就行了。*/

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        Map<Integer,Integer> map = new HashMap<>();
        for(int a :nums){
            if(map.get(a)==null){
                map.put(a,1);
            }else{
                map.put(a,map.get(a)+1);
            }
        }
        //频率做下标， 数据用list表示
        List<Integer>[] frequents = new List[nums.length+1];
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int frequent = entry.getValue();
            if(frequents[frequent] == null){
                frequents[frequent] = new ArrayList();
            }
            frequents[frequent].add(entry.getKey());
        }
        //返回数组
        int[] arr = new int[k];
        int index = 0;
        for(int i= nums.length; i>=0 && index<k; i--){
            if(frequents[i] == null) continue;
            
            for(int a:frequents[i]){
                
                arr[index++] = a;
            }
        }
        return arr;
    }
}