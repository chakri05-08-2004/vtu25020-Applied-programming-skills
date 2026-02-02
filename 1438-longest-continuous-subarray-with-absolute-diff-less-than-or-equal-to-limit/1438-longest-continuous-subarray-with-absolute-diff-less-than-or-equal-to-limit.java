import java.util.*;

class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxDeque = new LinkedList<>(); // decreasing order
        Deque<Integer> minDeque = new LinkedList<>(); // increasing order
        int left = 0, result = 0;

        for (int right = 0; right < nums.length; right++) {
            int num = nums[right];

            // Maintain decreasing order for maxDeque
            while (!maxDeque.isEmpty() && nums[maxDeque.peekLast()] < num) {
                maxDeque.pollLast();
            }
            maxDeque.offerLast(right);

            // Maintain increasing order for minDeque
            while (!minDeque.isEmpty() && nums[minDeque.peekLast()] > num) {
                minDeque.pollLast();
            }
            minDeque.offerLast(right);

            // Shrink window if condition violated
            while (nums[maxDeque.peekFirst()] - nums[minDeque.peekFirst()] > limit) {
                left++;
                if (maxDeque.peekFirst() < left) maxDeque.pollFirst();
                if (minDeque.peekFirst() < left) minDeque.pollFirst();
            }

            // Update result
            result = Math.max(result, right - left + 1);
        }

        return result;
    }
}