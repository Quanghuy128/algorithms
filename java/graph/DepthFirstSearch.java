package graph;

import java.util.*;

/**
 * Depth-First Search (DFS) is a graph traversal algorithm that explores as far as
 * possible along each branch before backtracking. It can be used to find connected
 * components in a graph, detect cycles, and solve problems related to pathfinding.
 *
 * How DFS Works:
 * 1. Start from a specified vertex (the "source" vertex) and mark it as visited.
 * 2. Explore a neighbor of the current vertex that has not been visited.
 * 3. If all neighbors have been visited, backtrack to the previous vertex.
 * 4. Repeat steps 2-3 until all vertices reachable from the source have been visited.
 *
 * Time Complexity:
 * - O(V + E), where V is the number of vertices and E is the number of edges in the graph.
 *   In the worst case, DFS visits every vertex and edge in the graph.
 *
 * DFS can be implemented using recursion or an explicit stack. The recursive implementation
 * is elegant but may run into stack overflow issues for very deep graphs. The iterative
 * implementation with a stack avoids this issue and is more suitable for large graphs.
 *
 * It's important to note that the time complexity may vary depending on the graph's structure.
 * In the worst case, DFS can take linear time, but in well-structured graphs, it often runs
 * much faster in practice.
 */


public class DepthFirstSearch {
    private static Map<Integer, List<Integer>> adjacencyList = new HashMap<>();

    public static void main(String[] args) {
        addEdge(1, 2);
        addEdge(1, 3);
        addEdge(2, 4);
        addEdge(2, 5);
        addEdge(3, 5);
        addEdge(4, 5);
        addEdge(4, 6);

        // Perform DFS starting from vertex 1
        System.out.println("DFS starting from vertex 1:");
        dfs(1, new HashSet<>());
    }

    private static void addEdge(int source, int destination) {
        adjacencyList.computeIfAbsent(source, k -> new ArrayList<>()).add(destination);
        adjacencyList.computeIfAbsent(destination, k -> new ArrayList<>()).add(source); // For an undirected graph
    }

    private static void dfs(int currentVertex, Set<Integer> visited) {
        visited.add(currentVertex);
        System.out.print(currentVertex + " ");

        for (int neighbor : adjacencyList.getOrDefault(currentVertex, Collections.emptyList())) {
            if (!visited.contains(neighbor)) {
                dfs(neighbor, visited);
            }
        }
    }
}
