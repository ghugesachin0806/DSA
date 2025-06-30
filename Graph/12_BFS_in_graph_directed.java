package Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;

// https://www.naukri.com/code360/problems/bfs-in-graph_973002

import java.util.List;

class Solution {
    public static void solve(List<List<Integer>> adj, List<Integer> visited, List<Integer> ans, int node) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(node);

        visited.set(node, 1);

        while (!queue.isEmpty()) {
            int temp = queue.peek();
            queue.remove();

            ans.add(temp);

            for (int val : adj.get(temp)) {
                if (visited.get(val) != 1) {
                    queue.add(val);
                    visited.set(val, 1);
                }
            }
        }
    }

    public static List<Integer> bfsTraversal(int n, List<List<Integer>> adj) {
        // Write your code here
        int nodes = n;

        List<Integer> visited = new ArrayList<>(Collections.nCopies(nodes, 0));
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < visited.size(); i++) {
            if (visited.get(i) != 1) {
                solve(adj, visited, ans, i);
            }
        }
        return ans;
    }
}
