package Graph;

import java.util.ArrayDeque;
import java.util.AbstractMap.SimpleEntry;

// https://leetcode.com/problems/rotting-oranges/description/

class Solution {
    public int orangesRotting(int[][] grid) {

        int[][] cloneGrid = new int[grid.length][];

        for (int i = 0; i < grid.length; i++) {
            cloneGrid[i] = grid[i].clone();
        }

        ArrayDeque<SimpleEntry<Integer, Integer>> qt = new ArrayDeque<>();

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (cloneGrid[row][col] == 2)
                    qt.add(new SimpleEntry<>(row, col));
            }
        }
        qt.add(new SimpleEntry<>(null, null));
        int time = -1;

        while (!qt.isEmpty()) {

            SimpleEntry<Integer, Integer> pair = qt.peek();
            qt.remove();

            if (pair.getKey() == null && pair.getValue() == null) {
                time++;
                if (!qt.isEmpty())
                    qt.add(new SimpleEntry<>(null, null));
                continue;
            }

            int[] del_row = { 0, -1, 0, 1 };
            int[] del_col = { 1, 0, -1, 0 };

            for (int i = 0; i < del_row.length; i++) {
                int nrow = pair.getKey() + del_row[i];
                int ncol = pair.getValue() + del_col[i];

                if (nrow >= 0 && nrow < grid.length && ncol >= 0 && ncol < grid[0].length) {
                    if (cloneGrid[nrow][ncol] == 1) {
                        cloneGrid[nrow][ncol] = 2;
                        qt.add(new SimpleEntry<>(nrow, ncol));
                    }
                }
            }
        }

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (cloneGrid[row][col] == 1)
                    return -1;
            }
        }

        return time;
    }
}
