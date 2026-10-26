/* Structure of a Linked List Node
class Node {
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}*/

class Solution {
    Node divide(Node head) {
        if(head == null || head.next == null) {
            return head;
        }
        Node evenHead = new Node(0);
        Node oddHead = new Node(0);
        Node even = evenHead;
        Node odd = oddHead;
        Node curr = head;
        while(curr != null) {
            if(curr.data % 2 == 0) {
                even.next = curr;
                even = even.next;
            } else {
                odd.next = curr;
                odd = odd.next;
            }
            curr = curr.next;
        }
        even.next = oddHead.next;
        odd.next = null;
        return evenHead.next;
    }
}