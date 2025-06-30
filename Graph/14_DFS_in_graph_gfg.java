package Graph;

import java.util.ArrayList;
import java.util.Collections;

// https://practice.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1

class Solution {

    public void solve(int node, ArrayList<Integer> visited, ArrayList<Integer> ans, ArrayList<ArrayList<Integer>> adj) {
        visited.set(node, 1);
        ans.add(node);

        for (int val : adj.get(node)) {
            if (visited.get(val) != 1)
                solve(val, visited, ans, adj);
        }
    }

    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int nodes = adj.size();
        ArrayList<Integer> visited = new ArrayList<>(Collections.nCopies(nodes, 0));
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < visited.size(); i++) {
            if (visited.get(i) != 1)
                solve(i, visited, ans, adj);
        }
        return ans;
    }
}