/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null)
            return null;
        Node curr = head;
        while(curr != null){
            Node copy = new Node(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            curr = copy.next;
        }
        curr = head;
        while(curr != null){
            if(curr.random != null)
                curr.next.random = curr.random.next;
            curr = curr.next.next;
        }
        curr = head;
        Node head1 = new Node(0);
        Node cloneCurr = head1;
        while(curr != null){
            Node nextOriginal = curr.next.next;
            cloneCurr.next = curr.next;
            cloneCurr = cloneCurr.next;
            curr.next = nextOriginal;
            curr = nextOriginal;

        }
        return head1.next;
    }
}
