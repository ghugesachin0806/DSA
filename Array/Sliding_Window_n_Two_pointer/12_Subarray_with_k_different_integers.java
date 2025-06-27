package Array.Sliding_Window_n_Two_pointer;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/subarrays-with-k-different-integers/description/

// Subarrays with exactly K distinct = 
//     Subarrays with at most K distinct 
//   - Subarrays with at most (K - 1) distinct

class Solution {
    public int solve(int[] nums, int k) {
        if (k < 0)
            return 0;

        int res = 0;
        int lastPtr = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            while (map.size() > k && lastPtr <= i) {
                map.put(nums[lastPtr], map.getOrDefault(nums[lastPtr], 1) - 1);
                if (map.get(nums[lastPtr]) == 0)
                    map.remove(nums[lastPtr]);
                    lastPtr++;
            }
            res += i - lastPtr + 1;
        }
        return res;
    }

    public int subarraysWithKDistinct(int[] nums, int k) {
        return solve(nums, k) - solve(nums, k - 1);
    }
}
