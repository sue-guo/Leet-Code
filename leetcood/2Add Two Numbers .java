/** You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.*/

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

//method : 
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();//返回list 的头
        ListNode prs = head;//当前node
        boolean b = true;//控制循环
        int a = 0;//进位
        ListNode zeroNode = new ListNode(0);
        while(b){
            int sum = l1.val + l2.val+ a;
            if(sum >= 10){
                prs.val = sum-10;
                a = 1;
            }else{
                prs.val = sum;
                a = 0;
            }
            if (l1.next != null || l2.next != null || a == 1){
                l1 = l1.next == null? zeroNode:l1.next;
                l2 = l2.next == null? zeroNode:l2.next;
                prs.next = new ListNode();
                prs = prs.next;
            }else{
                b = false;
            }
            
        }
        return head;
    }
}