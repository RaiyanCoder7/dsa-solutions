/* Structure of a link list node
class Node {
    int data;  // value stored in node
    Node next;
    Node prev;

    Node(int value) {
        data = value;
        next = null;
        prev = null;
    }
}
*/
class Solution {
    Node removeDuplicates(Node headRef) {
        if(headRef == null || headRef.next == null) {
            return headRef;
        }
        Node curr = headRef;
        while(curr != null && curr.next != null) {
            if(curr.data == curr.next.data) {
                Node nextUnique = curr.next;
                while(nextUnique != null && nextUnique.data == curr.data) {
                    nextUnique = nextUnique.next;
                }
                curr.next = nextUnique;
                if(nextUnique != null) {
                    nextUnique.prev = curr;
                }
            }
            curr = curr.next;
        }
        return headRef;
    }
}