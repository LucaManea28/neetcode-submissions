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
    private int index = 0;
    private HashMap<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }
        TreeNode root = dfs(preorder, inorder, map, 0, inorder.length - 1);
        return root;
    }
    public TreeNode dfs(int[] preorder, int[] inorder, Map<Integer, Integer> map, int left, int right){
        if(left > right)
            return null;
        TreeNode root = new TreeNode(preorder[index]);
        int i = map.get(preorder[index]);
        index ++;
        root.left = dfs(preorder, inorder, map, left, i-1);
        root.right = dfs(preorder, inorder, map, i+1, right);
        return root;
    }
}
