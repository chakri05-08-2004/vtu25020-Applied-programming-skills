import java.util.*;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                // check distance between duplicate indices
                if (i - map.get(nums[i]) <= k) {
                    return true;
                }
            }
            // update last seen index
            map.put(nums[i], i);
        }

        return false;
    }
}