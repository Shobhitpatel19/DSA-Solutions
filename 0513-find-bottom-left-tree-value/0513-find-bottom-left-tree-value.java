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
    int maxdepth = -1;
    int bottomleft;
    public void dfs(TreeNode root, int currdepth){
        if(root == null) return;

        if(maxdepth < currdepth){
            maxdepth = currdepth;
            bottomleft = root.val;
        }
        dfs(root.left, currdepth+1);
        dfs(root.right, currdepth+1);
    }
    public int findBottomLeftValue(TreeNode root) {
        //maxdepth = -1;
        //bottomleft = root.val;
        dfs(root, 0);
        return bottomleft;
    }
}

// TC => O(n)
// SC => O(h) where h is the maximum height if the tree.