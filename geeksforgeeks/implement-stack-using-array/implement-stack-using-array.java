class myStack {
    private int[] arr;
    private int top;
    private int capacity;

    public myStack(int n) {
        this.capacity = n;
        this.arr = new int[capacity];
        this.top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == capacity - 1;
    }

    public void push(int x) {
        if (!isFull()) {
            top++;
            arr[top] = x;
        }
    }

    public void pop() {
        if (!isEmpty()) {
            top--;
        }
    }

    public int peek() {
        if (isEmpty()) {
            return -1;
        }
        return arr[top];
    }
}