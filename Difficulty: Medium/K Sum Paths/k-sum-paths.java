//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class GFG {
    static Node buildTree(String str) {
        // Corner Case
        if (str.length() == 0 || str.equals('N')) return null;
        String[] s = str.split(" ");

        Node root = new Node(Integer.parseInt(s[0]));
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);

        // Starting from the second element
        int i = 1;
        while (!q.isEmpty() && i < s.length) {
            // Get and remove the front of the queue
            Node currNode = q.remove();

            // Get the current node's value from the string
            String currVal = s[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                q.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= s.length) break;
            currVal = s[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                q.add(currNode.right);
            }

            i++;
        }

        return root;
    }

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t > 0) {
            String s = br.readLine();
            Node root = buildTree(s);
            int k = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();

            System.out.println(ob.sumK(root, k));
            t--;

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    public int sumK(Node root, int k) {
        HashMap<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1); // Base case for a valid path starting at root
        return dfs(root, 0, k, prefixSumCount);
    }

    private int dfs(Node node, int cumulativeSum, int k, HashMap<Integer, Integer> prefixSumCount) {
        if (node == null) return 0;

        // Update cumulative sum
        cumulativeSum += node.data;

        // Get the count of valid paths that sum to `k`
        int count = prefixSumCount.getOrDefault(cumulativeSum - k, 0);

        // Add the current cumulative sum to the hashmap
        prefixSumCount.put(cumulativeSum, prefixSumCount.getOrDefault(cumulativeSum, 0) + 1);

        // Recur for left and right subtrees
        count += dfs(node.left, cumulativeSum, k, prefixSumCount);
        count += dfs(node.right, cumulativeSum, k, prefixSumCount);

        // Backtrack: Remove current cumulative sum from the hashmap
        prefixSumCount.put(cumulativeSum, prefixSumCount.get(cumulativeSum) - 1);

        return count;
    }
}
