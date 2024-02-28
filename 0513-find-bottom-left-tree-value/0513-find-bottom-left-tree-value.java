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
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        int bottomleft = root.val;
        que.offer(root);

        while(!que.isEmpty()){
            int n = que.size();
            while(n-->0){
                TreeNode node = que.poll();
                bottomleft = node.val;

                if(node.right != null){
                    que.offer(node.right);
                }
                if(node.left != null){
                    que.offer(node.left);
                }
            }
        }
        return bottomleft;
    }
}