//{ Driver Code Starts


import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

public class Main {
    public static boolean isValidBSTUtil(Node node, long lower, long upper) {
        if (node == null) return true;
        if (node.data <= lower || node.data >= upper) return false;
        return isValidBSTUtil(node.left, lower, node.data) &&
            isValidBSTUtil(node.right, node.data, upper);
    }

    public static boolean isValidBST(Node root) {
        return isValidBSTUtil(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static int height(Node root) {
        if (root == null) return 0;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if (leftHeight == -1 || rightHeight == -1 ||
            Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static boolean isBalanced(Node root) { return height(root) != -1; }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            // int n = Integer.parseInt(br.readLine().trim());
            int[] nums = Arrays.stream(br.readLine().trim().split(" "))
                             .mapToInt(Integer::parseInt)
                             .toArray();

            Solution obj = new Solution();
            Node root = obj.sortedArrayToBST(nums);

            if (!isValidBST(root)) {
                System.out.println("false");
                continue;
            }

            boolean balanced = isBalanced(root);
            if (balanced) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public Node helper(int[] nums, int l, int h){
        if(h > l) return null;
        
        int mid = l + (h-l)/2;
        
        Node root = new Node(nums[mid]);
        
        root.left = helper(nums, l, mid - 1);
        root.right = helper(nums, mid+1, h);
        return root;
    }
    
    public Node sortedArrayToBST(int[] nums) {
        // Code here
        Node root = helper(nums, 0, nums.length-1);
        return root;
    }
}

