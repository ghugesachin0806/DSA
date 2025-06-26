package Array.Binary_Search;

// https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/description/

class Solution {
    public boolean solve(int mid, int[] weights, int days) {
        int cnt = 1;
        int sum = 0;

        for (int i = 0; i < weights.length; i++) {
            if (sum + weights[i] <= mid)
                sum += weights[i];
            else {
                cnt++;
                if (weights[i] > mid || cnt > days)
                    return false;
                sum = weights[i];
            }
        }
        return true;
    }

    public int shipWithinDays(int[] weights, int days) {

        int start = 0;
        int end = 0;

        for (int i = 0; i < weights.length; i++)
            end += weights[i];

        int ans = 0;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (solve(mid, weights, days)) {
                ans = mid;
                end = mid - 1;
            } else
                start = mid + 1;
        }
        return ans;
    }
}