import java.util.*;

class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> stack = new Stack<>();

        // First pass: mark invalid ')'
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else if (c == ')') {
                if (!stack.isEmpty()) {
                    stack.pop(); // matched '('
                } else {
                    sb.setCharAt(i, '*'); // mark invalid ')'
                }
            }
        }

        // Second pass: mark leftover '('
        while (!stack.isEmpty()) {
            sb.setCharAt(stack.pop(), '*');
        }

        // Build final string without '*'
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) != '*') {
                result.append(sb.charAt(i));
            }
        }

        return result.toString();
    }
}