package Array.Binary_Search;

import java.util.Arrays;

// https://www.geeksforgeeks.org/problems/aggressive-cows/1

class Solution {

    public static boolean solve(int mid, int[] newStalls, int k) {
        int cowCnt = 1;
        int last = newStalls[0];

        for (int i = 0; i < newStalls.length; i++) {
            if (newStalls[i] - last >= mid) {
                cowCnt++;
                if (cowCnt >= k)
                    return true;
                last = newStalls[i];
            }
        }
        return false;
    }

    public static int aggressiveCows(int[] stalls, int k) {
        // code here
        int[] newStalls = Arrays.copyOf(stalls, stalls.length);
        Arrays.sort(newStalls);
        int start = 0;
        int end = newStalls[newStalls.length - 1];
        int ans = 0;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (solve(mid, newStalls, k)) {
                ans = mid;
                start = mid + 1;
            } else
                end = mid - 1;
        }
        return ans;
    }
}
