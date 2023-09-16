/**Given the head of a singly linked list, sort the list using insertion sort, and return the sorted list's head.

The steps of the insertion sort algorithm:

Insertion sort iterates, consuming one input element each repetition and growing a sorted output list.
At each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list and inserts it there.
It repeats until no input elements remain. */


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */


//Method GTP: dummy是返回链表的头，确定要插入的值在 prev和prev.next之间 
class Solution {
    public ListNode insertionSortList(ListNode head) {
        
        if (head == null || head.next == null) {
            return head; // Already sorted or empty list
        }

        ListNode dummy = new ListNode(); // Dummy node to hold the sorted list
        ListNode current = head;

        while (current != null) {
            ListNode next = current.next;
            ListNode prev = dummy;

            while (prev.next != null && prev.next.val < current.val) {
                prev = prev.next;
            }

            current.next = prev.next;
            prev.next = current;

            current = next;
        }

        return dummy.next; 
        }
}


//METHOD of mine: 太复杂， 创建了新的ListNode 
class Solution {
    public ListNode insertionSortList(ListNode head) {
  ListNode rhead = null;

        while(head != null ){
            //System.out.println("head="+head.val);     
            if(rhead!=null){//rhead is null,rhead 是递增的所以rhead一直指向最小的
                ListNode currentNode = rhead;
                //System.out.println("rhead="+rhead.val);
                while(currentNode != null){
                    //System.out.println("currentNode="+currentNode.val);
                    if(currentNode.val > head.val){
                         rhead =new ListNode(head.val,currentNode);
                         //System.out.println("小于当前node");
                         break;
                    }else if(currentNode.val < head.val){
                            if(currentNode.next != null && currentNode.next.val > head.val){
                                //System.out.println("两点之间:");
                                currentNode.next = new ListNode(head.val,currentNode.next);             
                                break;
                            }else if(currentNode.next == null){
                                currentNode.next = new ListNode(head.val);             
                                break;
                            }
                            
                    }else if(currentNode.val == head.val){
                        if(currentNode.next != null){
                            currentNode.next = new ListNode(head.val,currentNode.next); 
                        }else{
                            currentNode.next = new ListNode(head.val);
                        }
                        //System.out.println("相等");    
                        break;
                    }
                    
                    currentNode = currentNode.next;
                }
            }else{//the first node
                rhead=new ListNode(head.val);
            }
            // System.out.println("rhead 值"+rhead.val);
            head = head.next;
        }
       
        return rhead;
    }
}