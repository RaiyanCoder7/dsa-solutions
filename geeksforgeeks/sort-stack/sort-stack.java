class Solution {
    public void sortStack(Stack<Integer> st) {
        if(st.isEmpty()) {
            return;
        }
        int top = st.pop();
        sortStack(st);
        insertCorrectPosition(st, top);
    }
    private void insertCorrectPosition(Stack<Integer> st, int element) {
        if(st.isEmpty() || st.peek() <= element) {
            st.push(element);
            return;
        }
        int top = st.pop();
        insertCorrectPosition(st, element);
        st.push(top);
    }
}