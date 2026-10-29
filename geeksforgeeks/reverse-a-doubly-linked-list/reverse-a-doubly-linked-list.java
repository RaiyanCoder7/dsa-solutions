/* Structure of Doubly Linked List Node
class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
*/
class Solution {
    public Node reverse(Node head) {
        if(head == null || head.next == null) {
            return head;
        }
        Node curr = head;
        Node tail = null;
        while(curr != null) {
            Node temp = curr.prev;
            curr.prev = curr.next;
            curr.next = temp;
            tail = curr;
            curr = curr.prev;
        }
        return tail;
    }
}