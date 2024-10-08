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
        int ht;
        bool isbal;
};
class Solution {
public:
    Pair* check(TreeNode* root){
        if(root == NULL){
            Pair* bp = new Pair;
            bp->ht = 0;
            bp->isbal = true;
            return bp;
        }
        Pair* left = check(root->left);
        Pair* right = check(root->right);

        Pair* mp = new Pair();
        mp->isbal = abs(left->ht - right->ht) <= 1 
                    && left->isbal && right->isbal;
        mp->ht = max(left->ht, right->ht) + 1;
        return mp;
    }

    bool isBalanced(TreeNode* root) {
        Pair* mp = check(root);
        return mp->isbal;
    }
};