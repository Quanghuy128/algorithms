package graph;

import java.util.*;

/**
 * Kruskal's Algorithm is a greedy algorithm that finds the Minimum Spanning Tree (MST)
 * of a connected, undirected graph with weighted edges. The MST is a subset of the edges
 * that connects all vertices without forming any cycles and has the minimum possible total
 * edge weight.
 *
 * How Kruskal's Algorithm Works:
 * 1. Sort all the edges in non-decreasing order of their weights.
 * 2. Initialize an empty set to store the MST.
 * 3. Iterate through the sorted edges:
 *    - Add the smallest edge to the MST set if adding it doesn't form a cycle.
 *    - Use the Union-Find (Disjoint Set Union) data structure to check for cycles.
 * 4. The MST set now contains the minimum spanning tree.
 *
 * The Union-Find data structure is used to efficiently check whether adding an edge
 * creates a cycle. It helps to keep track of connected components in the graph.
 *
 * Time Complexity:
 * - O(E * log(E) + E * log(V)), where E is the number of edges and V is the number of
 *   vertices in the graph. The algorithm's complexity is dominated by the sorting of edges
 *   and the union-find operations.
 *
 * Kruskal's Algorithm is suitable for sparse graphs with many vertices and fewer edges.
 * It's important to note that Kruskal's Algorithm may not work correctly on graphs with
 * disconnected components.
 */


class Edge implements Comparable<Edge> {
    int src, dest, weight;

    public Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge other) {
        return Integer.compare(this.weight, other.weight);
    }
}

public class Kruskal {
    private int vertices;
    private List<Edge> edges;

    public Kruskal(int vertices) {
        this.vertices = vertices;
        this.edges = new ArrayList<>();
    }

    public void addEdge(int src, int dest, int weight) {
        edges.add(new Edge(src, dest, weight));
    }

    public List<Edge> kruskalMST() {
        List<Edge> result = new ArrayList<>();
        Collections.sort(edges);

        int[] parent = new int[vertices];
        Arrays.fill(parent, -1);

        for (Edge edge : edges) {
            int rootSrc = find(parent, edge.src);
            int rootDest = find(parent, edge.dest);

            if (rootSrc != rootDest) {
                result.add(edge);
                union(parent, rootSrc, rootDest);
            }
        }

        return result;
    }

    private int find(int[] parent, int vertex) {
        if (parent[vertex] == -1) {
            return vertex;
        }
        return find(parent, parent[vertex]);
    }

    private void union(int[] parent, int rootSrc, int rootDest) {
        parent[rootSrc] = rootDest;
    }

    public static void main(String[] args) {
        Kruskal graph = new Kruskal(4);

        graph.addEdge(0, 1, 10);
        graph.addEdge(0, 2, 6);
        graph.addEdge(0, 3, 5);
        graph.addEdge(1, 3, 15);
        graph.addEdge(2, 3, 4);

        List<Edge> mstEdges = graph.kruskalMST();

        System.out.println("Minimum Spanning Tree Edges:");
        for (Edge edge : mstEdges) {
            System.out.println("Edge " + edge.src + " - " + edge.dest + " with weight " + edge.weight);
        }
    }
}
