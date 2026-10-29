/*Structure of the doubly linked list  Node
class Node {
  public int data;
  public Node next;
  public Node prev;

  public Node(int x) {
      data = x;
      next = null;
      prev = null;
  }
};*/

class Solution {
    public Node deleteAllOccurOfX(Node head, int x) {
        Node curr = head;
        while(curr != null) {
            Node nextNode = curr.next;
            if(curr.data == x) {
                if(curr == head) {
                    head = nextNode;
                    if(head != null) {
                        head.prev = null;
                    }
                } else {
                    curr.prev.next = curr.next;
                    if(curr.next != null) {
                        curr.next.prev = curr.prev;
                    }
                }
            }
            curr = nextNode;
        }
        return head;
    }
}