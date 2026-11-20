class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (int ast : asteroids) {
            boolean alive = true;

            // Collision happens only when current asteroid moves left (ast < 0)
            // and top of stack is moving right (stack.peek() > 0)
            while (alive && ast < 0 && !stack.isEmpty() && stack.peek() > 0) {
                int top = stack.peek();
                int absAst = -ast;

                if (top < absAst) {
                    // Stack's right-moving asteroid is smaller: it explodes
                    stack.pop();
                } else if (top == absAst) {
                    // Equal sizes: both explode
                    stack.pop();
                    alive = false;
                } else {
                    // Current left-moving asteroid is smaller: it explodes
                    alive = false;
                }
            }

            if (alive) {
                stack.push(ast);
            }
        }

        // Convert stack to array in left-to-right order (bottom to top)
        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }
}