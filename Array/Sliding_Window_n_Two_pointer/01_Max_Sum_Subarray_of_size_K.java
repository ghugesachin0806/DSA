package Array.Sliding_Window_n_Two_pointer;

// https://www.geeksforgeeks.org/problems/max-sum-subarray-of-size-k5313/1

// constant window

class Solution {
    public int maximumSumSubarray(int[] arr, int k) {

        int n = arr.length;

        int res = 0;

        for (int i = 0; i < k; i++)
            res += arr[i];

        int currRes = res;

        for (int i = k; i < n; i++) {

            // i -> front pointer for constant sliding window (exclusive of sliding window)
            // i-k -> back pointer for constant sliding window (exclusive of sliding window)
            
            currRes = currRes + arr[i] - arr[i - k];
            res = Math.max(currRes, res);
        }
        return res;
    }
}
