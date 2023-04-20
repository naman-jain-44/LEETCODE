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
class Solution {
public:
    int widthOfBinaryTree(TreeNode* root) {
        if(root==NULL)
            return 0;
        queue<pair<TreeNode*,long int>>q;
        q.push({root,0});
        int mx=0;
        while(!q.empty()){
            int s=q.size();
            int mn=q.front().second; //min index to remove overflow
            int st,end;
            for(int i=0; i<s;i++){
                TreeNode* node=q.front().first;
                long int dist=(q.front().second)-mn;
                q.pop();
                if(i==0)
                    st=dist;
                if(i==s-1)
                    end=dist;
                if(node->left)
                    q.push({node->left,2*dist+1});
                if(node->right)
                    q.push({node->right,2*dist+2});
            }
            mx=max(mx,end-st+1);
        }
        return mx;
    }
};