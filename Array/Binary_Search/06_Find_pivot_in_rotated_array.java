package Array.Binary_Search;

// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/

class Solution {
    public int findMin(int[] nums) {

        if (nums.length == 1 || nums[0] < nums[nums.length - 1])
            return nums[0];

        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] >= nums[0])
                start = mid + 1;
            else
                end = mid;
        }

        return nums[start];
    }
}
