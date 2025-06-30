package Graph;

import java.util.ArrayList;
import java.util.Collections;

// https://leetcode.com/problems/number-of-provinces/description/

class Solution {

    public void DFS(int[][] isConnected, ArrayList<Integer> visited, int node) {
        visited.set(node, 1);
        for (int i = 0; i < isConnected[node].length; i++) {
            if (isConnected[node][i] == 1 && visited.get(i) != 1)
                DFS(isConnected, visited, i);
        }
    }

    public int findCircleNum(int[][] isConnected) {

        int nodes = isConnected.length;
        ArrayList<Integer> visited = new ArrayList<>(Collections.nCopies(nodes, 0));
        int cnt = 0;

        for (int i = 0; i < nodes; i++) {
            if (visited.get(i) != 1) {
                cnt++;
                DFS(isConnected, visited, i);
            }
        }
        return cnt;
    }
}