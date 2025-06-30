package DP;

import java.util.Arrays;

// https://www.naukri.com/code360/problems/ninja-s-training_3621003

class Solution {

    public static int solve(int index, int lastActivity, int point[][], int[][] dp) {
        if (index < 0)
            return 0;

        if (lastActivity < 3 && dp[index][lastActivity] != -1)
            return dp[index][lastActivity];

        int temp = Integer.MIN_VALUE;

        for (int i = 0; i < 3; i++) {
            if (i != lastActivity) {
                temp = Math.max(temp, solve(index - 1, i, point, dp) + point[index][i]);
            }
        }

        if (lastActivity < 3)
            dp[index][lastActivity] = temp;

        return temp;
    }

    public static int ninjaTraining(int n, int points[][]) {
        // Write your code here..
        int[][] dp = new int[n][3];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        int currDay = n-1;
        int lastActivity = 3;

        return solve(currDay, lastActivity, points, dp);
    }

}
