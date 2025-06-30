package Graph;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class DirectedWeightedAdjListSimpleEntry {

    // Function to add directed edge
    static void addEdge(List<SimpleEntry<Integer, Integer>>[] adjList, int u, int v, int wt) {
        adjList[u].add(new SimpleEntry<>(v, wt)); // Only u → v for directed graph
    }

    // Function to print graph
    static void printEdges(List<SimpleEntry<Integer, Integer>>[] adjList, int n) {
        for (int i = 1; i <= n; i++) {
            System.out.print(i + "->");
            for (SimpleEntry<Integer, Integer> entry : adjList[i]) {
                System.out.print(entry.getKey() + "(" + entry.getValue() + "),");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // number of nodes
        int m = sc.nextInt(); // number of edges

        List<SimpleEntry<Integer, Integer>>[] adjList = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int wt = sc.nextInt();
            addEdge(adjList, u, v, wt);
        }

        System.out.println("Directed weighted edges");
        printEdges(adjList, n);

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
