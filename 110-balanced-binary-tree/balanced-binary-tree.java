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
    class Pair{
        int ht;
        boolean isBal;
        Pair(int ht, boolean isBal){
            this.ht = ht;
            this.isBal = isBal;
        }
        Pair(){}
    }

    private Pair checkBalance(TreeNode root){
        if(root == null){
            Pair bp = new Pair(0, true);
            return bp;
        }
        Pair left = checkBalance(root.left);
        Pair right = checkBalance(root.right);

        Pair mp = new Pair();
        
        mp.isBal = Math.abs(left.ht - right.ht) <= 1
                    && left.isBal && right.isBal;
        mp.ht = Math.max(left.ht, right.ht) + 1;
        return mp;
    }

    public boolean isBalanced(TreeNode root) {
        // Code here
        Pair ans = checkBalance(root);
        return ans.isBal;
    }
}