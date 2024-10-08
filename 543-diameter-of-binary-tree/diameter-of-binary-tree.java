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

class DiaPair{
    int diameter;
    int height;
}

class Solution {
    public DiaPair Diameter(TreeNode root){
        if(root == null){
            DiaPair bp = new DiaPair();
            bp.diameter = 0;
            bp.height = -1;
            return bp;
        }

        DiaPair left = Diameter(root.left);
        DiaPair right = Diameter(root.right);

        DiaPair mp = new DiaPair();
        mp.height = Math.max(left.height, right.height) + 1;
        int freq = left.height + right.height + 2;

        mp.diameter = Math.max(freq, Math.max(left.diameter, right.diameter));
        return mp;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        DiaPair mp = Diameter(root);
        return mp.diameter;
    }
}

