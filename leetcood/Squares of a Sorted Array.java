Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
could you find an O(n) solution using a different approach？

Method one : 遍历数组，如果是负数就放在栈中（先进后出），因为负数的平方是递减的，如果是正数就放在队列中（先进先出），然后对比栈和队列的首个元素，小的先放进return中
class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] r = new int[nums.length];//输出数组
        int j = 0; //输出数字下标
        Deque<Integer> deque = new ArrayDeque<Integer>();//实现stack功能
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int a : nums){
            if(a<0){
                deque.push(Math.abs(a));
            }else{
               queue.add(a);
            }
        }
        int o = nums.length;
        while(o >= 1){
            if(deque != null && deque.size()!=0){
                if(queue!=null && queue.size() != 0){
                    Integer de = deque.peek();//第一的位置的元素
                    Integer qu = queue.peek();//第一的位置的元素
                    if(de > qu){
                         r[j]=qu*qu;
                         queue.remove();
                    }else{
                         r[j]=de*de;
                         deque.remove();
                    }
                }else{
                    Integer de = deque.peekFirst();
                    r[j]=de*de;
                    deque.remove();
                }
            }else if(queue!=null){
                Integer qu = queue.peek();
                r[j]=qu*qu;
                queue.remove();
            }
            j++;
            o--;
        }
        return r;
    }
}