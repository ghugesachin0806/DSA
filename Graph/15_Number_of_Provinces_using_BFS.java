package Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// https://leetcode.com/problems/number-of-provinces/description/

class Solution {

    public void BFS(int[][] isConnected, List<Integer> visited, int node) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.push(node);
        visited.set(node, 1);

        while (!queue.isEmpty()) {
            int temp = queue.peek();
            queue.remove();

            for (int i = 0; i < isConnected[temp].length; i++) {
                if (isConnected[temp][i] == 1 && visited.get(i) != 1) {
                    queue.add(i);
                    visited.set(i, 1);
                }
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {

        int node = isConnected.length;
        List<Integer> visited = new ArrayList<>(Collections.nCopies(node, 0));

        int cnt = 0;

        for (int i = 0; i < visited.size(); i++) {
            if (visited.get(i) != 1) {
                cnt++;
                BFS(isConnected, visited, i);
            }
        }
        return cnt;
    }
}
