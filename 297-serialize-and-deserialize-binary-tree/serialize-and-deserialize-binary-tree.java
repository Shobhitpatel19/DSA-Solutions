/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    private void serializeHelper(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append("null,");
            return;
        }
        sb.append(root.val + ",");

        serializeHelper(root.left, sb);
        serializeHelper(root.right, sb);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        // Code here
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }

    private TreeNode deserializeHelper(String[] arr){
        if(idx >= arr.length || arr[idx].equals("null")){
            idx++;
            return null;
        }

        int nodedata = Integer.parseInt(arr[idx++]);
        TreeNode node = new TreeNode(nodedata);
        node.left = deserializeHelper(arr);
        node.right = deserializeHelper(arr);

        return node;
    }

    // Decodes your encoded data to tree.
    int idx;
    public TreeNode deserialize(String data) {
        // Code Here
        String[] arr = data.split(",");
        idx = 0;

        TreeNode root = deserializeHelper(arr);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));