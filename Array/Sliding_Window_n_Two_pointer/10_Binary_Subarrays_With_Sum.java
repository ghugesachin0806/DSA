package Array.Sliding_Window_n_Two_pointer;

// https://leetcode.com/problems/binary-subarrays-with-sum/description/

// here, find the sum <= goal and then do subtraction.

class Solution {
    public int solve(int[] nums, int goal) {
        if (goal < 0)
            return 0;

        int res = 0;
        int lastPtr = 0;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (sum <= goal) {
                res += i - lastPtr + 1;
            } else {
                while (sum > goal && lastPtr <= i) {
                    sum -= nums[lastPtr];
                    lastPtr++;
                }
                res += i - lastPtr + 1;
            }
        }
        return res;
    }

    public int numSubarraysWithSum(int[] nums, int goal) {
        return solve(nums, goal) - solve(nums, goal - 1);
    }
}
