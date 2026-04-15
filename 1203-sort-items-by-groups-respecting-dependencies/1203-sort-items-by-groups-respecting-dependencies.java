import java.util.*;

class Solution {
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {

        // Step 1: Assign unique group IDs to -1 items
        for (int i = 0; i < n; i++) {
            if (group[i] == -1) {
                group[i] = m++;
            }
        }

        // Step 2: Build graphs
        List<List<Integer>> itemGraph = new ArrayList<>();
        List<List<Integer>> groupGraph = new ArrayList<>();

        int[] itemIndegree = new int[n];
        int[] groupIndegree = new int[m];

        for (int i = 0; i < n; i++) {
            itemGraph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            groupGraph.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int prev : beforeItems.get(i)) {

                // Item graph
                itemGraph.get(prev).add(i);
                itemIndegree[i]++;

                // Group graph
                if (group[i] != group[prev]) {
                    groupGraph.get(group[prev]).add(group[i]);
                    groupIndegree[group[i]]++;
                }
            }
        }

        // Step 3: Topo sort groups and items
        List<Integer> groupOrder = topoSort(groupGraph, groupIndegree, m);
        List<Integer> itemOrder = topoSort(itemGraph, itemIndegree, n);

        if (groupOrder.size() == 0 || itemOrder.size() == 0) {
            return new int[0];
        }

        // Step 4: Group items based on group
        Map<Integer, List<Integer>> groupToItems = new HashMap<>();
        for (int item : itemOrder) {
            groupToItems
                .computeIfAbsent(group[item], k -> new ArrayList<>())
                .add(item);
        }

        // Step 5: Build final result
        List<Integer> result = new ArrayList<>();

        for (int g : groupOrder) {
            if (groupToItems.containsKey(g)) {
                result.addAll(groupToItems.get(g));
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }

    private List<Integer> topoSort(List<List<Integer>> graph, int[] indegree, int size) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();
            result.add(node);

            for (int next : graph.get(node)) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        return result.size() == size ? result : new ArrayList<>();
    }
}