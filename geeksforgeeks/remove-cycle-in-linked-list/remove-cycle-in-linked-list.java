/* Structure of Linked List Node
class Node {
    int data;
    Node next;
    Node(int val) {
        data = val;
        next = null;
    }
} */
class Solution {
    public static void removeLoop(Node head) {
        if(head == null || head.next == null) {
            return;
        }
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                break;
            }
        }
        if(slow != fast) {
            return;
        }
        //case 1 : loop starts at head
        if(slow == head) {
            while(fast.next != head) {
                fast = fast.next;
            }
            fast.next = null;
            return;
        }
        //case 2 : loop starts other than head
        slow = head;
        while(slow.next != fast.next) {
            slow = slow.next;
            fast = fast.next;
        }
        fast.next = null;
    }
}