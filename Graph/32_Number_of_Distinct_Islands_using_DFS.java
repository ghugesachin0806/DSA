package Graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.AbstractMap.SimpleEntry;

// https://practice.geeksforgeeks.org/problems/number-of-distinct-islands/1

class Solution {
    public void dfs(int row, int col, int base_row, int base_col, int[][] visited, int[][] grid,
            ArrayList<SimpleEntry<Integer, Integer>> list) {
        visited[row][col] = 1;
        list.add(new SimpleEntry<>(row - base_row, col - base_col));

        int[] def_row = { 0, 0, 1, -1 };
        int[] def_col = { 1, -1, 0, 0 };

        for (int i = 0; i < def_col.length; i++) {
            int nrow = row + def_row[i];
            int ncol = col + def_col[i];

            if (nrow >= 0 && nrow < grid.length && ncol >= 0 && ncol < grid[0].length) {
                if (visited[nrow][ncol] == 0 && grid[nrow][ncol] == 1) {
                    dfs(nrow, ncol, base_row, base_col, visited, grid, list);
                }
            }
        }
    }

    int countDistinctIslands(int[][] grid) {

        // Your Code here
        HashSet<ArrayList<SimpleEntry<Integer, Integer>>> set = new HashSet<>();
        int[][] visited = new int[grid.length][grid[0].length];

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (visited[row][col] == 0 && grid[row][col] == 1) {
                    ArrayList<SimpleEntry<Integer, Integer>> list = new ArrayList<>();
                    dfs(row, col, row, col, visited, grid, list);
                    set.add(list);
                }
            }
        }

        return set.size();
    }
}
