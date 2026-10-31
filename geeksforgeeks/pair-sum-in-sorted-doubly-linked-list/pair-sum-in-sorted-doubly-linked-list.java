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
        if(head == null || head.next == null) {
            return result;
        }
        Node left = head;
        Node right = head;
        while(right.next != null) {
            right = right.next;
        }
        while(left != null && right != null && left != right && right.next != left) {
            int sum = left.data + right.data;
            if(sum == target) {
                ArrayList<Integer> pair = new ArrayList<>();
                pair.add(left.data);
                pair.add(right.data);
                result.add(pair);
                left = left.next;
                right = right.prev;
            } else if(sum < target) {
                left = left.next;
            } else {
                right = right.prev;
            }
        }
        return result;
    }
}