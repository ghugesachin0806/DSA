package Array.Prefix_Sum;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/subarray-sum-equals-k/description/

class Solution {
    public int subarraySum(int[] nums, int k) {

        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                res += map.get(sum - k);
            }
            // map.put(sum, map.containsKey(sum) ? map.get(sum) + 1 : 1);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}
