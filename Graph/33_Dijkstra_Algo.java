package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.AbstractMap.SimpleEntry;

class Solution {
    public int[] dijkstra(int V, int[][] edges, int src) {
        // code here
        ArrayList<SimpleEntry<Integer, Integer>>[] adjList = new ArrayList[V];

        for (int i = 0; i < V; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < edges.length; i++) {
            adjList[edges[i][0]].add(new SimpleEntry<>(edges[i][1], edges[i][2]));
            adjList[edges[i][1]].add(new SimpleEntry<>(edges[i][0], edges[i][2]));
        }

        // Compares two entries a and b based on their keys (a.getKey(), b.getKey()).
        // This ensures the queue gives you the entry with the smallest key (distance)
        // first.

        PriorityQueue<SimpleEntry<Integer, Integer>> qt = new PriorityQueue<>(
                (a, b) -> Integer.compare(a.getKey(), b.getKey()));

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        qt.add(new SimpleEntry<>(0, src));
        dist[src] = 0;

        while (!qt.isEmpty()) {
            SimpleEntry<Integer, Integer> tempPair = qt.peek();
            qt.remove();

            int node = tempPair.getValue();
            int nodeDist = tempPair.getKey();

            for (SimpleEntry<Integer, Integer> pair : adjList[node]) {
                int neighNode = pair.getKey();
                int neighDist = pair.getValue();

                if (nodeDist + neighDist < dist[neighNode]) {
                    qt.add(new SimpleEntry<>(nodeDist + neighDist, neighNode));
                    dist[neighNode] = nodeDist + neighDist;
                }
            }
        }

        return dist;
    }
}