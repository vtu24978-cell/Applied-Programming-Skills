import java.util.*;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int a : asteroids) {
            boolean destroyed = false;

            while (!stack.isEmpty() && a < 0 && stack.peek() > 0) {
                if (Math.abs(stack.peek()) < Math.abs(a)) {
                    stack.pop(); 
                    continue;
                } 
                else if (Math.abs(stack.peek()) == Math.abs(a)) {
                    stack.pop(); 
                }
                destroyed = true;
                break;
            }

            if (!destroyed) {
                stack.push(a);
            }
        }
        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }
}
