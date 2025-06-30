package DP;

import java.util.Arrays;

class Solution {

    public int solve(int amount, int[] coins, int[] dp) {
        if (amount < 0)
            return Integer.MAX_VALUE;

        if (amount == 0)
            return 0;

        if (dp[amount] != -1)
            return dp[amount];

        int cnt = Integer.MAX_VALUE;

        for (int i = 0; i < coins.length; i++) {
            int minCoin = solve(amount - coins[i], coins, dp);
            if (minCoin != Integer.MAX_VALUE)
                minCoin++;
            cnt = Math.min(cnt, minCoin);
        }

        return dp[amount] = cnt;
    }

    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);

        int temp = solve(amount, coins, dp);
        if (temp != Integer.MAX_VALUE)
            return temp;

        return -1;
    }
}
