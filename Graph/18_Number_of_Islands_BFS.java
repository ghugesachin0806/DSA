package Graph;

import java.util.ArrayDeque;
import java.util.AbstractMap.SimpleEntry;

// https://www.geeksforgeeks.org/problems/find-the-number-of-islands/1

class Solution {

    public void BFS(int row, int col, char[][] grid, int[][] visited) {
        ArrayDeque<SimpleEntry<Integer, Integer>> qt = new ArrayDeque<>();
        qt.add(new SimpleEntry<>(row, col));
        visited[row][col] = 1;

        while (!qt.isEmpty()) {
            SimpleEntry<Integer, Integer> temp = qt.peek();
            qt.remove();

            for (int del_row = -1; del_row <= 1; del_row++) {
                for (int del_col = -1; del_col <= 1; del_col++) {
                    int nrow = temp.getKey() + del_row;
                    int ncol = temp.getValue() + del_col;

                    if (nrow >= 0 && nrow < grid.length && ncol >= 0 && ncol < grid[0].length
                            && grid[nrow][ncol] == 'L') {
                        if (visited[nrow][ncol] != 1) {
                            visited[nrow][ncol] = 1;
                            qt.add(new SimpleEntry<>(nrow, ncol));
                        }
                    }
                }
            }
        }
    }

    public int countIslands(char[][] grid) {
        // Code here
        int[][] visited = new int[grid.length][grid[0].length];

        int cnt = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 'L' && visited[row][col] != 1) {
                    cnt++;
                    BFS(row, col, grid, visited);
                }
            }
        }

        return cnt;
    }
}