package Array.Binary_Search;

// https://www.geeksforgeeks.org/problems/number-of-occurrence2259/1

class Solution {
    int countFreq(int[] arr, int target) {
        // code here
        int startIndex = -1;
        int endIndex = -1;

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                startIndex = mid;
                end = mid - 1;
            } else if (arr[mid] > target)
                end = mid - 1;
            else
                start = mid + 1;
        }

        start = 0;
        end = arr.length - 1;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                endIndex = mid;
                start = mid + 1;
            } else if (arr[mid] > target)
                end = mid - 1;
            else
                start = mid + 1;
        }

        if (startIndex == -1)
            return 0;

        else
            return endIndex - startIndex + 1;
    }
}
