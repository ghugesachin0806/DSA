package Graph;

// https://leetcode.com/problems/number-of-islands/description/

class Solution {

    public void DFS(int row, int col, char[][] grid, int[][] visited) {

        visited[row][col] = 1;

        int[] del_row = { -1, 0, 1, 0 };
        int[] del_col = { 0, 1, 0, -1 };

        for (int i = 0; i < del_row.length; i++) {
            int nrow = row + del_row[i];
            int ncol = col + del_col[i];

            if (nrow >= 0 && nrow < grid.length && ncol >= 0 && ncol < grid[0].length && grid[nrow][ncol] == '1') {
                if (visited[nrow][ncol] != 1) {
                    DFS(nrow, ncol, grid, visited);
                }
            }
        }
    }

    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        int[][] visited = new int[row][col];

        int cnt = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1' && visited[i][j] != 1) {
                    cnt++;
                    DFS(i, j, grid, visited);
                }
            }
        }
        return cnt;
    }
}
