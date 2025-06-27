package Array.Sliding_Window_n_Two_pointer;

// https://www.geeksforgeeks.org/problems/maximum-sum-of-subarray-less-than-or-equal-to-x4033/1

// Expanding and Shrinking of window

class GfG {
    static int atMostSum(int[] arr, int k) {

        int sum = 0;
        int lastPtr = 0;

        int res = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            // i -> front pointer for constant sliding window (exclusive of sliding window)
            // lastPtr -> back pointer for constant sliding window.

            // last pointer increment
            while (sum > k && lastPtr <= i) {
                sum = sum - arr[lastPtr];
                lastPtr++;
            }

            res = Math.max(res, i - lastPtr + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 1, 0, 1, 1, 0 };
        int k = 4;
        System.out.println(atMostSum(arr, k));
    }
}