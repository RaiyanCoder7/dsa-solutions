/*
class Node {
    int data;
    Node prev, next;
    Node(int data) {
        this.data = data;
        this.prev = this.next = null;
    }
}
*/
class Solution {
    public Node sortedInsert(Node head, int x) {
        Node newNode = new Node(x);
        if(head == null) {
            return newNode;
        }
        if(x <= head.data) {
            newNode.next = head;
            head.prev = newNode;
            return newNode;
        }
        Node curr = head;
        while(curr.next != null && curr.next.data < x) {
            curr = curr.next;
        }
        newNode.next = curr.next;
        newNode.prev = curr;
        if(curr.next != null) {
            curr.next.prev = newNode;
        }
        curr.next = newNode;
        return head;
    }
}