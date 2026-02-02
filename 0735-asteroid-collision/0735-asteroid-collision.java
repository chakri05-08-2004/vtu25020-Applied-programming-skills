import java.util.*;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {
            boolean alive = true;

            // Handle collisions only when stack top is moving right (positive)
            // and current asteroid is moving left (negative)
            while (alive && !stack.isEmpty() && stack.peek() > 0 && asteroid < 0) {
                int top = stack.peek();

                if (top < -asteroid) {
                    // Top asteroid explodes, continue checking
                    stack.pop();
                } else if (top == -asteroid) {
                    // Both explode
                    stack.pop();
                    alive = false;
                } else {
                    // Current asteroid explodes
                    alive = false;
                }
            }

            if (alive) {
                stack.push(asteroid);
            }
        }

        // Convert stack to array
        int[] result = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;
    }
}