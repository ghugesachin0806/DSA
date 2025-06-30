package Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// https://www.codingninjas.com/codestudio/problems/dfs-traversal_630462

class Solution {

    public static void edgesToListConversion(ArrayList<ArrayList<Integer>> edges,
            ArrayList<ArrayList<Integer>> adjList) {

        for (ArrayList<Integer> list : edges) {
            int u = list.get(0);
            int v = list.get(1);

            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
    }

    public static void solveDFS(int node, ArrayList<ArrayList<Integer>> adjList, List<Integer> visited,
            List<Integer> ans) {
        ans.add(node);
        visited.set(node, 1);

        for (int val : adjList.get(node)) {
            if (visited.get(val) != 1) {
                solveDFS(val, adjList, visited, ans);
            }
        }
    }

    public static ArrayList<ArrayList<Integer>> depthFirstSearch(int v, int e, ArrayList<ArrayList<Integer>> edges) {
        // Write your code here.
        int nodes = v;
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            adjList.add(new ArrayList<>());
        }

        edgesToListConversion(edges, adjList);

        List<Integer> visited = new ArrayList<>(Collections.nCopies(nodes, 0));
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < visited.size(); i++) {
            if (visited.get(i) != 1) {

                ArrayList<Integer> res = new ArrayList<>();
                solveDFS(i, adjList, visited, res);
                ans.add(res);
            }
        }
        return ans;
    }
}