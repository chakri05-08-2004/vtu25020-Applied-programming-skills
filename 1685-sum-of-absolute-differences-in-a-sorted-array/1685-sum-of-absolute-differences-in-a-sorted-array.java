import java.util.*;

class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        // prefix sum of nums
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        for (int i = 0; i < n; i++) {
            // sum of left side differences
            int leftSum = nums[i] * i - prefix[i];
            // sum of right side differences
            int rightSum = (prefix[n] - prefix[i + 1]) - nums[i] * (n - i - 1);
            result[i] = leftSum + rightSum;
        }

        return result;
    }
}