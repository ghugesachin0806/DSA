package Array.Binary_Search;

// https://www.geeksforgeeks.org/problems/the-painters-partition-problem1535/1

class Solution {

    public boolean solve(int mid, int[] arr, int k) {
        int cnt = 1;
        int tempSum = 0;

        for (int i = 0; i < arr.length; i++) {
            if (tempSum + arr[i] <= mid) {
                tempSum += arr[i];
            } else {
                cnt++;
                if (arr[i] > mid || cnt > k)
                    return false;
                tempSum = arr[i];
            }
        }
        return true;
    }

    public int minTime(int[] arr, int k) {
        // code here
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        int start = 0;
        int end = sum;
        int ans = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (solve(mid, arr, k)) {
                ans = mid;
                end = mid - 1;
            } else
                start = mid + 1;
        }
        return ans;
    }
}
