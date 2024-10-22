/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    class Pair {
        int withRoot; // Maximum sum of a path starting from this node
        int maxPath;  // Maximum path sum anywhere in this subtree

        Pair(int withRoot, int maxPath) {
            this.withRoot = withRoot;
            this.maxPath = maxPath;
        }
    }

    private Pair findMaxPath(TreeNode root) {
        if (root == null) {
            // If node is null, no contribution to path sum, return 0 for withRoot and very small number for maxPath.
            return new Pair(0, Integer.MIN_VALUE);
        }

        Pair left = findMaxPath(root.left);
        Pair right = findMaxPath(root.right);

        // Calculate the maximum path that includes the current node and either child
        int withRoot = Math.max(left.withRoot, right.withRoot) + root.val;
        // The path can also just be the current node's value, so compare it to `root.val`
        withRoot = Math.max(withRoot, root.val);

        // Calculate the maximum path sum considering the current node, including:
        // 1. The max path through left child + current node + right child (a path "through" the root)
        // 2. The max path from either subtree or just the node itself
        int maxPathThroughRoot = left.withRoot + root.val + right.withRoot;
        int maxPath = Math.max(maxPathThroughRoot, Math.max(left.maxPath, right.maxPath));

        // Return the result for the current node
        return new Pair(withRoot, Math.max(maxPath, withRoot));
    }

    public int maxPathSum(TreeNode root) {
        Pair result = findMaxPath(root);
        return result.maxPath;
    }
}
