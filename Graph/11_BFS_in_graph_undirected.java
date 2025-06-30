package Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;

// https://www.geeksforgeeks.org/problems/bfs-traversal-of-graph/1

class Solution {
    public void bfsTraversal(ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> visited, ArrayList<Integer> ans,
            int node) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        queue.push(node);
        visited.set(node, 1);

        while (!queue.isEmpty()) {
            int temp = queue.peek();
            queue.remove();

            ans.add(temp);

            for (int val : adj.get(temp)) {
                if (visited.get(val) != 1) {
                    visited.set(val, 1);
                    queue.add(val);
                }
            }
        }
    }

    // Function to return Breadth First Search Traversal of given graph.
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        int nodes = adj.size();

        ArrayList<Integer> ans = new ArrayList<>();
        ArrayList<Integer> visited = new ArrayList<>(Collections.nCopies(nodes, 0));

        for (int i = 0; i < visited.size(); i++) {
            if (visited.get(i) != 1)
                bfsTraversal(adj, visited, ans, i);
        }
        return ans;
    }
}