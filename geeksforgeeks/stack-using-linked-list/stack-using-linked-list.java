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
    private Node top;
    private int currentSize;

    public myStack() {
        // Initialize your data members
        this.top = null;
        this.currentSize = 0;
    }

    public boolean isEmpty() {
        // check if the stack is empty
        return top == null;
    }

    public void push(int x) {
        // Adds an element x at the rear of the stack.
        Node newNode = new Node(x);
        newNode.next = top;
        top = newNode;
        currentSize++;
    }

    public void pop() {
        // Removes the front element of the stack.
        if(!isEmpty()) {
            top = top.next;
            currentSize--;
        }
    }

    public int peek() {
        // Returns the front element of the stack.
        // If stack is empty, return -1.
        if(isEmpty()) {
            return -1;
        }
        return top.data;
    }

    public int size() {
        // Returns the current size of the stack.
        return currentSize;
    }
}
