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
        if(head == null) {
            return newNode;
        }
        int count = 0;
        Node temp =  head;
        while(temp != null) {
            count++;
            temp = temp.next;
        }
        int mid = (count + 1) / 2;
        Node current = head;
        for(int i = 1; i < mid; i++) {
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
        return head;
    }
}