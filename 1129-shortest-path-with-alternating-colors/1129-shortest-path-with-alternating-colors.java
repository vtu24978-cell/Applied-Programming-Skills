import java.util.*;

class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {

        // Step 1: Build graphs
        List<Integer>[] redGraph = new ArrayList[n];
        List<Integer>[] blueGraph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            redGraph[i] = new ArrayList<>();
            blueGraph[i] = new ArrayList<>();
        }

        for (int[] e : redEdges) {
            redGraph[e[0]].add(e[1]);
        }

        for (int[] e : blueEdges) {
            blueGraph[e[0]].add(e[1]);
        }

        // Step 2: Result array
        int[] result = new int[n];
        Arrays.fill(result, -1);

        // Step 3: BFS queue → {node, color}
        // color: 0 = red, 1 = blue
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][2];

        // Start from node 0 with both colors
        queue.offer(new int[]{0, 0});
        queue.offer(new int[]{0, 1});
        visited[0][0] = true;
        visited[0][1] = true;

        int steps = 0;

        // Step 4: BFS
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int node = curr[0];
                int color = curr[1];

                // Update result
                if (result[node] == -1) {
                    result[node] = steps;
                }

                // Next edges (alternate color)
                if (color == 0) { // last was red → use blue
                    for (int next : blueGraph[node]) {
                        if (!visited[next][1]) {
                            visited[next][1] = true;
                            queue.offer(new int[]{next, 1});
                        }
                    }
                } else { // last was blue → use red
                    for (int next : redGraph[node]) {
                        if (!visited[next][0]) {
                            visited[next][0] = true;
                            queue.offer(new int[]{next, 0});
                        }
                    }
                }
            }

            steps++;
        }

        return result;
    }
}