/* Structure of Linked List Node
class Node {
    int data;
    Node next;
    Node bottom;

    Node(int x) {
        data = x;
        next = null;
        bottom = null;
    }
}*/

class Solution {
    public Node flatten(Node head) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.data - b.data);
        Node temp = head;
        while(temp != null) {
            pq.add(temp);
            temp = temp.next;
        }
        Node dummy = new Node(0);
        Node tail = dummy;
        while(!pq.isEmpty()) {
            Node minNode = pq.poll();
            tail.bottom = minNode;
            tail = tail.bottom;
            if(minNode.bottom != null) {
                pq.add(minNode.bottom);
            }
        }
        return dummy.bottom;
    }
}