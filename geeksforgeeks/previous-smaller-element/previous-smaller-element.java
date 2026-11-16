class Solution {
    public static ArrayList<Integer> prevSmaller(int[] arr) {
        ArrayList<Integer> result = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < arr.length; i++) {
            int current = arr[i];

            // Pop elements from stack that are greater than or equal to current
            while (!stack.isEmpty() && stack.peek() >= current) {
                stack.pop();
            }

            // If stack is empty, no smaller element exists on the left
            if (stack.isEmpty()) {
                result.add(-1);
            } else {
                // Top of the stack is the previous smaller element
                result.add(stack.peek());
            }

            // Push current element onto the stack for future elements
            stack.push(current);
        }

        return result;
    }
}