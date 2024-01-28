package graph;

import java.util.*;

/**
 * Breadth-First Search (BFS) is a graph traversal algorithm that explores all the vertices
 * of a graph level by level, visiting all neighbors of a vertex before moving on to the
 * next level. It is often used for finding the shortest path in unweighted graphs and
 * discovering the connected components of a graph.
 *
 * How BFS Works:
 * 1. Start from a specified vertex (the "source" vertex) and enqueue it.
 * 2. Dequeue a vertex from the queue and visit it.
 * 3. Enqueue all unvisited neighbors of the visited vertex.
 * 4. Repeat steps 2-3 until the queue is empty.
 *
 * BFS uses a queue data structure to keep track of vertices to be visited. The order in
 * which vertices are visited in BFS ensures that the algorithm explores the graph level
 * by level.
 *
 * Time Complexity:
 * - O(V + E), where V is the number of vertices and E is the number of edges in the graph.
 *   BFS visits every vertex and edge exactly once.
 *
 * BFS guarantees finding the shortest path in an unweighted graph because it systematically
 * explores the graph level by level. However, it may not work optimally in graphs with
 * weighted edges.
 *
 * BFS is generally more memory-intensive than DFS due to the need for a queue to store
 * vertices. However, its simplicity and guarantee of finding the shortest path make it a
 * popular choice for certain graph traversal problems.
 */


public class BreadthFirstSearch{
    private static Map<Integer, List<Integer>> adjacencyList = new HashMap<>();

    public static void main(String[] args) {
        // Create a graph
        addEdge(1, 2);
        addEdge(1, 3);
        addEdge(2, 4);
        addEdge(2, 5);
        addEdge(3, 5);
        addEdge(4, 5);
        addEdge(4, 6);

        // Perform BFS starting from vertex 1
        System.out.println("BFS starting from vertex 1:");
        bfs(1);
    }

    private static void addEdge(int source, int destination) {
        adjacencyList.computeIfAbsent(source, k -> new ArrayList<>()).add(destination);
        adjacencyList.computeIfAbsent(destination, k -> new ArrayList<>()).add(source); // For an undirected graph
    }

    private static void bfs(int startVertex) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.offer(startVertex);
        visited.add(startVertex);

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            System.out.print(currentVertex + " ");

            for (int neighbor : adjacencyList.getOrDefault(currentVertex, Collections.emptyList())) {
                if (!visited.contains(neighbor)) {
                    queue.offer(neighbor);
                    visited.add(neighbor);
                }
            }
        }
    }
}