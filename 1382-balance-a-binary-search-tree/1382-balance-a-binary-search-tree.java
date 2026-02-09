class Solution {
    List<Integer> inorderList = new ArrayList<>();

    public TreeNode balanceBST(TreeNode root) {

        inorderTraversal(root);

        return buildBalancedTree(0, inorderList.size() - 1);
    }

    private void inorderTraversal(TreeNode root) {
        if (root == null) return;

        inorderTraversal(root.left);
        inorderList.add(root.val);
        inorderTraversal(root.right);
    }

    private TreeNode buildBalancedTree(int left, int right) {
        if (left > right) return null;

        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(inorderList.get(mid));

        root.left = buildBalancedTree(left, mid - 1);
        root.right = buildBalancedTree(mid + 1, right);

        return root;
    }
}
