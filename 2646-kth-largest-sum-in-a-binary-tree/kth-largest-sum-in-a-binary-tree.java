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
    public long kthLargestLevelSum(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }
        
        // Priority Queue (min-heap) to store the k largest level sums
        PriorityQueue<Long> pq = new PriorityQueue<>(k);

        // Queue for level-order traversal
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        // Level-order traversal
        while (!q.isEmpty()) {
            int length = q.size(); // Number of nodes at the current level
            long sum = 0;          // Sum of values at the current level

            // Process each node in the current level
            for (int i = 0; i < length; i++) {
                TreeNode node = q.poll();
                sum += node.val;

                // Add the left and right children to the queue
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
            
            // Maintain the priority queue to keep only the largest k sums
            if (pq.size() < k) {
                pq.add(sum);
            } else if (sum > pq.peek()) {
                pq.poll();  // Remove the smallest sum
                pq.add(sum);
            }
        }

        if(pq.size() < k){
            return -1;
        }
 
        // Return the kth largest sum (the smallest element in the priority queue)
        return pq.peek();
    }
}