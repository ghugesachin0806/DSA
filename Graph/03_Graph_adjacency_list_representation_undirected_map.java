package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class UndirectedGraph {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // Number of nodes
        int m = sc.nextInt(); // Number of edges

        Map<Integer, List<Integer>> adjList = new HashMap<>();

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            adjList.putIfAbsent(u, new ArrayList<>());
            adjList.putIfAbsent(v, new ArrayList<>());
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        System.out.println("Undirected Graph Output:");
        for (Map.Entry<Integer, List<Integer>> entry : adjList.entrySet()) {
            System.out.print(entry.getKey() + "->");
            for (int val : entry.getValue()) {
                System.out.print(val + ",");
            }
            System.out.println();
        }

        sc.close();
    }
}

// -> Input
// 5 7
// 1 3
// 1 2
// 3 2
// 4 2
// 4 3
// 4 5
// 5 2

// -> Output
// undirected output
// 1->3,2,
// 2->1,3,4,5,
// 3->1,2,4,
// 4->2,3,5,
// 5->4,2,