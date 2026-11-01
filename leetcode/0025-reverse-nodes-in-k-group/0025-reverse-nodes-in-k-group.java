/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k == 1) {
            return head;
        }
        ListNode dummy = new ListNode(0, head);
        ListNode prevNode = dummy;
        while(true) {
            ListNode kthNode = getKthNode(prevNode, k);
            if(kthNode == null) {
                break;
            }
            ListNode nextGroupHead = kthNode.next;
            ListNode groupHead = prevNode.next;
            ListNode prev = nextGroupHead;
            ListNode curr = groupHead;
            while(curr != nextGroupHead) {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }
            prevNode.next = kthNode;
            prevNode = groupHead;
        }
        return dummy.next;
    }

    private ListNode getKthNode(ListNode start, int k) {
        while(start != null && k > 0) {
            start = start.next;
            k--;
        }
        return start;
    }
}