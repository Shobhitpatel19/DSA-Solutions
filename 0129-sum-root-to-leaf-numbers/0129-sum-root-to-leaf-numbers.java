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
    int sum = 0;
    
    public int sumNumbers(TreeNode root) {
        sum = 0;
        helper(root, 0);
        return sum;
    }
    
    public void helper(TreeNode node, int num){
        if(node == null){
            return;
        }
        
        helper(node.left, num * 10 + node.val);
        helper(node.right, num * 10 + node.val);
        
        if(node.left == null && node.right == null){
            num = num * 10 + node.val;
            sum += num;
        }
    }
}