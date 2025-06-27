package Array.Sliding_Window_n_Two_pointer;

// https://leetcode.com/problems/count-number-of-nice-subarrays/description/

class Solution {

    public int solve(int[] nums, int k) {
        if (k < 0)
            return 0;

        int res = 0;
        int cnt = 0;
        int lastPtr = 0;

        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & 1) == 1)
                cnt++;

            while (cnt > k && lastPtr <= i) {
                if ((nums[lastPtr] & 1) == 1)
                    cnt--;
                lastPtr++;
            }
            res += i - lastPtr + 1;
        }

        return res;
    }

    public int numberOfSubarrays(int[] nums, int k) {

        return solve(nums, k) - solve(nums, k-1);
    }
}