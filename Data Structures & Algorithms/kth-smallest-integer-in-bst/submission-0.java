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
    int cnt = 0;
    int result = 0;
    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);
        return result;
    }
    private void dfs(TreeNode root, int k){
        if(root == null)
            return;
        dfs(root.left, k);
        cnt++;
        if(cnt == k)
            result = root.val;
        dfs(root.right, k);
    }
}
