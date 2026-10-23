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
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode curr = head;
        ListNode prev = null;
        int pos = 1;
        while(pos < left){
            prev = curr;
            curr = curr.next;
            pos++;
        }
        ListNode bridge1 = prev; //nod inaite de secventa
        ListNode bridge2 = curr; //ultimul nod din secventa
        prev = null;
        while(pos <= right){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
            pos++;
        }
        bridge2.next = curr;
        if(bridge1 != null){
            bridge1.next = prev;
        }else{
            head = prev;
        }
        return head;
    }
}