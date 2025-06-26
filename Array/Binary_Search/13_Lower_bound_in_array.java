package Array.Binary_Search;

// https://www.geeksforgeeks.org/problems/implement-lower-bound/1

// it will points to nums[index] >= target_element , from left to right , whichever comes first.

// Input:  arr[] = [2, 3, 7, 10, 11, 11, 25], target = 9
// Output: 3

// Input: arr[] = [2, 3, 7, 10, 11, 11, 25], target = 11
// Output: 4

// Input: arr[] = [2, 3, 7, 10, 11, 11, 25], target = 100
// Output: 7 // not found, then return length of array

class Solution {
    int lowerBound(int[] arr, int target) {
        // code here
        int start = 0;
        int end = arr.length - 1;

        int ans = arr.length;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] >= target) {
                ans = mid;
                end = mid - 1;
            } else
                start = mid + 1;
        }
        return ans;
    }
}
