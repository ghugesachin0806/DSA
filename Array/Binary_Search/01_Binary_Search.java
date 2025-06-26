package Array.Binary_Search;

// https://leetcode.com/problems/binary-search/description/

// remeber the way of binary search here.

class Solution {
    public int search(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2; // to avoid overflow for larger number

            if (nums[mid] == target)
                return mid;

            if (nums[mid] > target)
                end = mid - 1;
            else
                start = mid + 1;
        }

        return -1;
    }
}