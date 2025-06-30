package DP;

import java.util.Arrays;

// https://leetcode.com/problems/cherry-pickup-ii/description/

class Solution {

    public int solve(int row, int col1, int col2, int[][] grid, int[][][] dp) {

        if (col1 < 0 || col2 < 0 || col1 >= grid[0].length || col2 >= grid[0].length)
            return Integer.MIN_VALUE;

        if (dp[row][col1][col2] != -1)
            return dp[row][col1][col2];

        if (row == grid.length - 1) {
            if (col1 == col2)
                return grid[row][col1];

            return grid[row][col1] + grid[row][col2];
        }

        int temp = Integer.MIN_VALUE;

        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++)
                temp = Math.max(temp, solve(row+1, col1 + i, col2 + j, grid, dp));
        }

        if (col1 == col2)
            return dp[row][col1][col2] = temp + grid[row][col1];

        return dp[row][col1][col2] = temp + grid[row][col1] + grid[row][col2];

    }

    public int cherryPickup(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        int[][][] dp = new int[row][col][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                dp[i][j] = new int[col];
                Arrays.fill(dp[i][j], -1);
            }
        }
        return solve(0, 0, grid[0].length - 1, grid, dp);
    }
}