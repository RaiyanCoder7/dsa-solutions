/* Structure of linked list Node
class Node {
    int data;
    Node next;

    Node(int val) {
        data = val;
        next = null;
    }
}*/

class myStack {
    // Node definition
    private class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node top;
    private int currentSize;

    public myStack() {
        this.top = null;
        this.currentSize = 0;
    }

    // check if the stack is empty
    public boolean isEmpty() {
        return top == null;
    }

    // Adds an element x at the top of the stack
    public void push(int x) {
        Node newNode = new Node(x);
        newNode.next = top;
        top = newNode;
        currentSize++;
    }

    // Removes the top element of the stack
    public void pop() {
        if (!isEmpty()) {
            top = top.next;
            currentSize--;
        }
    }

    // Returns the top element of the stack. If stack is empty, return -1.
    public int peek() {
        if (isEmpty()) {
            return -1;
        }
        return top.data;
    }

    // Returns the current size of the stack
    public int size() {
        return currentSize;
    }
}