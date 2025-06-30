package Graph;

import java.util.Scanner;

// Undirected graph
// 1 based indexing

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // Number of nodes
        int m = sc.nextInt(); // Number of edges

        // Adjacency matrix for 1-based indexing
        int[][] adj = new int[n + 1][n + 1];

        // Reading edges
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj[u][v] = 1;
            adj[v][u] = 1; // remove this line for directed graph
        }

        // Printing edges
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (adj[i][j] == 1) {
                    System.out.println(i + "->" + j);
                }
            }
        }
        sc.close();
    }
}

// -> Input
// 5
// 7
// 1 2
// 2 4
// 4 1
// 3 4
// 3 1
// 5 2
// 4 5

// -> Output
// 1->2
// 1->3
// 1->4
// 2->1
// 2->4
// 2->5
// 3->1
// 3->4
// 4->1
// 4->2
// 4->3
// 4->5
// 5->2
// 5->4