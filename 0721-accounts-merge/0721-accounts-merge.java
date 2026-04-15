import java.util.*;

class Solution {

    class UnionFind {
        Map<String, String> parent = new HashMap<>();

        public String find(String x) {
            if (!parent.get(x).equals(x)) {
                parent.put(x, find(parent.get(x))); // path compression
            }
            return parent.get(x);
        }

        public void union(String x, String y) {
            String rootX = find(x);
            String rootY = find(y);
            if (!rootX.equals(rootY)) {
                parent.put(rootX, rootY);
            }
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        UnionFind uf = new UnionFind();

        Map<String, String> emailToName = new HashMap<>();

        // Step 1: Initialize
        for (List<String> acc : accounts) {
            String name = acc.get(0);

            for (int i = 1; i < acc.size(); i++) {
                String email = acc.get(i);
                uf.parent.putIfAbsent(email, email);
                emailToName.put(email, name);
            }
        }

        // Step 2: Union emails in same account
        for (List<String> acc : accounts) {
            String firstEmail = acc.get(1);
            for (int i = 2; i < acc.size(); i++) {
                uf.union(firstEmail, acc.get(i));
            }
        }

        // Step 3: Group emails by root
        Map<String, List<String>> groups = new HashMap<>();

        for (String email : uf.parent.keySet()) {
            String root = uf.find(email);
            groups.computeIfAbsent(root, k -> new ArrayList<>()).add(email);
        }

        // Step 4: Build result
        List<List<String>> result = new ArrayList<>();

        for (String root : groups.keySet()) {
            List<String> emails = groups.get(root);
            Collections.sort(emails);

            List<String> merged = new ArrayList<>();
            merged.add(emailToName.get(root));
            merged.addAll(emails);

            result.add(merged);
        }

        return result;
    }
}