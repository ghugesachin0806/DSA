package Array.Sliding_Window;

// https://leetcode.com/problems/max-consecutive-ones-iii/description/

// we can solve this problem by saying that longest subarray at most K zeroes.

class Solution {
    public int longestOnes(int[] nums, int k) {

        int res = 0;
        int lastPtr = 0;
        int cnt = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                cnt++;

            while (cnt > k && lastPtr <= i) {
                if (nums[lastPtr] == 0)
                    cnt--;

                lastPtr++;
            }

            res = Math.max(res, i - lastPtr + 1);
        }
        return res;
    }
}
