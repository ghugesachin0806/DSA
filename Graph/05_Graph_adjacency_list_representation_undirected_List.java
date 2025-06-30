package Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class UndirectedGraph {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // Number of nodes
        int m = sc.nextInt(); // Number of edges

        List<Integer>[] adjList = new ArrayList[n + 1];

        // Initialize lists
        for (int i = 0; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }

        // Reading undirected edges
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adjList[u].add(v);
            adjList[v].add(u); // for undirected graph
        }

        // Printing adjacency list
        System.out.println("undirected output");
        for (int i = 1; i <= n; i++) {
            System.out.print(i + "->");
            for (int neighbor : adjList[i]) {
                System.out.print(neighbor + ",");
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
// 1 -> 3, 2
// 2 -> 1, 3, 4, 5
// 3 -> 1, 2, 4
// 4 -> 2, 3, 5
// 5 -> 4, 2
