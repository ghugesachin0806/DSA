package Array.Binary_Search;

// https://www.geeksforgeeks.org/problems/binary-search-1587115620/1

class Solution {
    public int binarysearch(int[] arr, int k) {

        int start = 0;
        int end = arr.length - 1;

        int ans = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == k) {
                ans = mid;
                end = mid - 1;
            } else if (arr[mid] > k)
                end = mid - 1;
            else
                start = mid + 1;

        }

        return ans;
    }
}