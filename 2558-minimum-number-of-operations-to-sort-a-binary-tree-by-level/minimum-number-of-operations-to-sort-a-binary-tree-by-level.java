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
    public int minimumOperations(TreeNode root) {
        if (root == null) return 0;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int totalOperations = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            int[] values = new int[size];
            int index = 0;
            
            // Get all nodes at current level
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                values[index++] = current.val;
                
                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
            }
            
            // Add minimum swaps needed for current level
            totalOperations += countMinSwaps(values);
        }
        
        return totalOperations;
    }
    
    // Count minimum swaps needed to sort an array
    private int countMinSwaps(int[] arr) {
        int n = arr.length;
        // Create array of pairs to store original index
        Pair[] pairs = new Pair[n];
        for (int i = 0; i < n; i++) {
            pairs[i] = new Pair(arr[i], i);
        }
        
        // Sort pairs based on values
        Arrays.sort(pairs, (a, b) -> a.val - b.val);
        
        // To keep track of visited elements in cycles
        boolean[] visited = new boolean[n];
        int swaps = 0;
        
        // Process all cycles
        for (int i = 0; i < n; i++) {
            // Skip if element is visited or already in correct position
            if (visited[i] || pairs[i].idx == i) continue;
            
            // Find size of cycle starting from i
            int cycleSize = 0;
            int j = i;
            while (!visited[j]) {
                visited[j] = true;
                j = pairs[j].idx;
                cycleSize++;
            }
            
            // Add required swaps for current cycle
            if (cycleSize > 0) {
                swaps += (cycleSize - 1);
            }
        }
        
        return swaps;
    }
    
    // Helper class to store value and original index
    private class Pair {
        int val;
        int idx;
        
        Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }
}