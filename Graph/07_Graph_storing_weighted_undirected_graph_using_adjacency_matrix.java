package Graph;

import java.util.Scanner;

// Undirected graph
// 1 based indexing

class UndirectedWeightedGraph {

    // Function to add edges with weight to the adjacency matrix
    static void addEdge(int[][] adjMatrix, int u, int v, int wt) {
        adjMatrix[u][v] = wt;
        adjMatrix[v][u] = wt; // for undirected graph
    }

    // Function to print the weighted adjacency matrix
    static void printEdges(int[][] adjMatrix) {
        int n = adjMatrix.length - 1; // because of 1-based indexing
        for (int i = 1; i <= n; i++) {
            System.out.print(i + "->");
            for (int j = 1; j <= n; j++) {
                if (adjMatrix[i][j] > 0) {
                    System.out.print(j + "(" + adjMatrix[i][j] + "),");
                }
            }
            System.out.println();
        }
    }

    // Main function
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // number of nodes
        int m = sc.nextInt(); // number of edges

        int[][] adjMatrix = new int[n + 1][n + 1]; // 1-based indexing

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int wt = sc.nextInt();
            addEdge(adjMatrix, u, v, wt);
        }

        System.out.println("Undirected weighted edges");
        printEdges(adjMatrix);

        sc.close();
    }
}

// -> Input
// 5 7
// 1 2 7
// 2 4 8
// 3 1 5
// 4 3 3
// 4 5 20
// 4 1 9
// 5 2 11

// -> Output
// Undirected weighted edges
// 1->2(7),3(5),4(9),
// 2->1(7),4(8),5(11),
// 3->1(5),4(3),
// 4->1(9),2(8),3(3),5(20),
// 5->2(11),4(20),
