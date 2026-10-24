/* Structure of linked list Node
class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}
*/
class Solution {
    public Node addOne(Node head) {
        if(head == null) {
            return new Node(1);
        }
        head = reverse(head);
        Node curr = head;
        Node prev = null;
        int carry = 1;
        while(curr != null && carry > 0) {
            int sum = curr.data + carry;
            curr.data = sum % 10;
            carry = sum / 10;
            prev = curr;
            curr = curr.next;
        }
        if(carry > 0) {
            prev.next = new Node(carry);
        }
        return reverse(head);
    }
    private Node reverse(Node head) {
        Node prev = null;
        Node curr = head;
        while(curr != null) {
            Node nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
    
}