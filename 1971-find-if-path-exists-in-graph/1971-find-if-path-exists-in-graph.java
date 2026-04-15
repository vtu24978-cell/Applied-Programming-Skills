import java.util.*;

class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // Step 1: Build graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]); // undirected
        }

        // Step 2: Visited array
        boolean[] visited = new boolean[n];

        // Step 3: DFS
        return dfs(graph, source, destination, visited);
    }

    private boolean dfs(List<List<Integer>> graph, int curr, int dest, boolean[] visited) {
        if (curr == dest) return true;

        visited[curr] = true;

        for (int neighbor : graph.get(curr)) {
            if (!visited[neighbor]) {
                if (dfs(graph, neighbor, dest, visited)) {
                    return true;
                }
            }
        }

        return false;
    }
}