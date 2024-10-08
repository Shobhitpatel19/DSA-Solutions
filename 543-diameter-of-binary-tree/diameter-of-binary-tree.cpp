/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */

class Pair{
    public:
    int dia;
    int ht;
};
class Solution {
public:
    Pair* diameter(TreeNode* root){
        if(root == NULL){
            Pair* bp = new Pair();
            bp->ht = -1;
            bp->dia = 0;
            return bp;
        }

        Pair* left = diameter(root->left);
        Pair* right = diameter(root->right);

        Pair* mp = new Pair();
        mp->ht = max(left->ht, right->ht) + 1;

        int candidate = left->ht + right->ht + 2;
        mp->dia = max({candidate, left->dia, right->dia});
        return mp;
    }
    int diameterOfBinaryTree(TreeNode* root) {
        Pair* mp = diameter(root);
        return mp->dia;
    }
};