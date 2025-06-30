package Graph;

// directed graph
// 1 based indexing

import java.util.Scanner;

class DirectedWeightedGraph {

    // Function to add a directed edge with weight
    static void addEdge(int[][] adjMatrix, int u, int v, int wt) {
        adjMatrix[u][v] = wt; // only one direction for directed graph
    }

    // Function to print the directed weighted edges
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

        System.out.println("Directed weighted edges");
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
// Directed weighted edges
// 1->2(7),
// 2->4(8),
// 3->1(5),
// 4->3(3),5(20),1(9),
// 5->2(11),
