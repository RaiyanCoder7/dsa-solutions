/* Structure of a linked list node
class Node {
    int data;
    Node next;

    public Node(int data){
        this.data = data;
        this.next = null;
    }
}
*/

class Solution {
    public Node insertInMiddle(Node head, int x) {
        // code here
        Node newNode = new Node(x);

        // Edge case: Empty list
        if (head == null) {
            return newNode;
        }

        Node slow = head;
        Node fast = head.next;

        // Advance slow by 1 and fast by 2
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Insert newNode after slow
        newNode.next = slow.next;
        slow.next = newNode;

        return head;
    }
}