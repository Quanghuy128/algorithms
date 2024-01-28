package graph.dijkstra;

import java.util.Arrays;

/**
 * Dijkstra's Algorithm is a graph traversal algorithm that finds the shortest paths
 * from a specified source vertex to all other vertices in a weighted graph. It is
 * particularly useful for finding the shortest path in graphs where edges have
 * non-negative weights.
 *
 * How Dijkstra's Algorithm Works:
 * 1. Initialize distances from the source vertex to all other vertices as infinity,
 *    except for the source itself, which is set to 0.
 * 2. Create a priority queue (or use a data structure with efficient key extraction).
 * 3. Enqueue the source vertex with its distance as the key.
 * 4. While the priority queue is not empty:
 *    - Dequeue a vertex with the minimum distance from the priority queue.
 *    - Update distances to its neighbors if a shorter path is found.
 *    - Enqueue the neighbors with their updated distances.
 * 5. The distances array now contains the shortest path from the source vertex to
 *    every other vertex in the graph.
 *
 * Dijkstra's Algorithm uses a priority queue (min-heap) to efficiently select the
 * vertex with the minimum distance at each step. It guarantees finding the shortest
 * paths when all edge weights are non-negative.
 *
 * Time Complexity:
 * - O((V + E) * log(V)), where V is the number of vertices and E is the number of
 *   edges in the graph. The log(V) factor comes from the priority queue operations.
 *
 * Dijkstra's Algorithm may not work correctly for graphs with negative edge weights.
 * For such cases, Bellman-Ford algorithm or other specialized algorithms should be
 * considered.
 */


public class Dijkstra {
    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int[][] graph = {
                {0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 14, 10, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };

        int startVertex = 0;
        dijkstra(graph, startVertex);
    }

    private static void dijkstra(int[][] graph, int start) {
        int vertices = graph.length;
        int[] dist = new int[vertices];
        boolean[] visited = new boolean[vertices];

        // Initialize distances with infinity and mark all vertices as unvisited
        Arrays.fill(dist, INF);
        dist[start] = 0;

        for (int i = 0; i < vertices - 1; i++) {
            int minVertex = findMinVertex(dist, visited);
            visited[minVertex] = true;

            for (int j = 0; j < vertices; j++) {
                if (!visited[j] && graph[minVertex][j] != 0 &&
                        dist[minVertex] != INF && dist[minVertex] + graph[minVertex][j] < dist[j]) {
                    dist[j] = dist[minVertex] + graph[minVertex][j];
                }
            }
        }

        // Print the shortest distances
        System.out.println("Shortest distances from vertex " + start + ":");
        for (int i = 0; i < vertices; i++) {
            System.out.println("To vertex " + i + ": " + dist[i]);
        }
    }

    private static int findMinVertex(int[] dist, boolean[] visited) {
        int minVertex = -1;
        for (int i = 0; i < dist.length; i++) {
            if (!visited[i] && (minVertex == -1 || dist[i] < dist[minVertex])) {
                minVertex = i;
            }
        }
        return minVertex;
    }
}
