package DP;

import java.util.Arrays;

// https://leetcode.com/problems/fibonacci-number/description/

class Solution {

    // Helper method to compute fibonacci using memoization
    public int solve(int n, int[] dp) {
        // Base condition
        if (n == 0 || n == 1)
            return n;

        // Return already computed subproblem
        if (dp[n] != -1)
            return dp[n];

        // Recursive call and store the subproblem result
        dp[n] = solve(n - 1, dp) + solve(n - 2, dp);
        return dp[n];
    }

    public int fib(int n) {
        // Initialize memoization array with -1
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        return solve(n, dp);
    }
}
