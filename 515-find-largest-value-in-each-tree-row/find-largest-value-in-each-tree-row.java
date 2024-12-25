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
    public List<Integer> largestValues(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        if(root == null) return new ArrayList<>();

        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            int max = q.peek().val;

            for(int i=0; i<size; i++){
                TreeNode node = q.poll();
                if(node.val > max){
                    max = node.val;
                }
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }
            
            list.add(max);
        }
        return list;
    }
}