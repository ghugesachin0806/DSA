package Array.Binary_Search;

// https://leetcode.com/problems/search-in-rotated-sorted-array/description/

class Solution {

    public int findPivotIndex(int[] nums) {

        if (nums.length == 1 || nums[0] < nums[nums.length - 1])
            return 0;

        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] >= nums[0])
                start = mid + 1;
            else
                end = mid;
        }
        return start;
    }

    public int search(int[] nums, int target) {

        int pivotIndex = findPivotIndex(nums);
        int start = 0;
        int end = nums.length - 1;

        if (target <= nums[nums.length - 1])
            start = pivotIndex;
        else
            end = pivotIndex - 1;

        if (end < 0)
            return -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target)
                return mid;
            else if (nums[mid] > target)
                end = mid - 1;
            else
                start = mid + 1;
        }

        return -1;
    }
}
