package Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class DirectedGraph {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // Number of nodes
        int m = sc.nextInt(); // Number of edges

        List<Integer>[] adjList = new ArrayList[n + 1];

        // Initialize lists
        for (int i = 0; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }

        // Reading directed edges
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adjList[u].add(v); // only one direction for directed graph
        }

        // Printing adjacency list
        System.out.println("directed output");
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
// directed output
// 1->3,2,
// 2->
// 3->2,
// 4->2,3,5,
// 5->2,
