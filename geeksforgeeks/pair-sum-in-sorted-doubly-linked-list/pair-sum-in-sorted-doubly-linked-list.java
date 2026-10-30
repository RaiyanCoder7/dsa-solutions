/* Structure of Doubly Linked List Node
class Node {
    public int data;
    public Node next;
    public Node prev;

    public Node(int val) {
        data = val;
        next = null;
        prev = null;
    }
}; */

class Solution {
    public ArrayList<ArrayList<Integer>> givenSumPairs(Node head, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (head == null || head.next == null) {
            return result;
        }

        // Step 1: Find the tail of the DLL
        Node left = head;
        Node right = head;
        while (right.next != null) {
            right = right.next;
        }

        // Step 2: Two-pointer convergence
        // Termination condition: pointers meet (left == right)
        // or cross each other (right.next == left)
        while (left != null && right != null && left != right && right.next != left) {
            int currentSum = left.data + right.data;

            if (currentSum == target) {
                ArrayList<Integer> pair = new ArrayList<>();
                pair.add(left.data);
                pair.add(right.data);
                result.add(pair);

                // Both elements used; advance inward
                left = left.next;
                right = right.prev;
            } else if (currentSum < target) {
                left = left.next;
            } else {
                right = right.prev;
            }
        }

        return result;
    }
}