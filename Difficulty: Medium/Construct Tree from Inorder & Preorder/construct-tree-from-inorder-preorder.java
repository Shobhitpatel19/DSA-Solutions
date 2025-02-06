//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int key) {
        data = key;
        left = right = null;
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            Node root = null;

            // Read inorder array
            String[] inorderStr = (br.readLine()).trim().split(" ");
            int inorder[] = new int[inorderStr.length];
            for (int i = 0; i < inorderStr.length; i++) {
                inorder[i] = Integer.parseInt(inorderStr[i]);
            }

            // Read preorder array
            String[] preorderStr = (br.readLine()).trim().split(" ");
            int preorder[] = new int[preorderStr.length];
            for (int i = 0; i < preorderStr.length; i++) {
                preorder[i] = Integer.parseInt(preorderStr[i]);
            }

            Solution ob = new Solution();
            root = ob.buildTree(inorder, preorder);
            postOrder(root);
            System.out.println();
        }
    }

    // Function to print postorder traversal of the tree
    public static void postOrder(Node root) {
        if (root == null) return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }
}

// } Driver Code Ends


/*
class Node {
    int data;
    Node left, right;

    Node(int key) {
        data = key;
        left = right = null;
    }
}
*/

class Solution {
    private static int preIndex = 0;
    
    public static Node buildTree(int inorder[], int preorder[]) {
        preIndex = 0;
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return constructTree(preorder, inorder, 0, inorder.length - 1, inMap);
    }
    
    private static Node constructTree(int[] preorder, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> inMap) {
        if (inStart > inEnd) {
            return null;
        }
        
        int rootValue = preorder[preIndex++];
        Node root = new Node(rootValue);
        
        int inIndex = inMap.get(rootValue);
        
        root.left = constructTree(preorder, inorder, inStart, inIndex - 1, inMap);
        root.right = constructTree(preorder, inorder, inIndex + 1, inEnd, inMap);
        
        return root;
    }
    
    
}


