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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return null;
        }
        TreeNode prev = null;
        TreeNode curr = root;
        while(curr != null && curr.val != key){
            prev = curr;
            if(curr.val > key){
                curr = curr.left;
            }else{
                curr = curr.right;
            }
        }
        if(curr == null){
            return root;
        }
        if(curr.left == null && curr.right == null){
            //leaf node to delete
            if(prev == null){
                return null;
            }
            if(prev.left == curr){
                prev.left = null;
            }else{
                prev.right = null;
            }
            return root;
        }
        else if(curr.left == null || curr.right == null){
            TreeNode child;
            if(curr.left != null){
                child = curr.left;
            }else{
                child = curr.right;
            }
            if(prev == null){
                return child;
            }
            if(prev.left == curr){
                prev.left = child;
            }else{
                prev.right = child;
            }
            return root;
        }
        else{
            TreeNode succesorParent = curr;
            TreeNode succesor = curr.right;
            while(succesor.left != null){
                succesorParent = succesor;
                succesor = succesor.left;
            }
            curr.val = succesor.val;
            if(succesorParent.left == succesor){
                succesorParent.left = succesor.right;
            }else{
                succesorParent.right = succesor.right;
            }
            return root;
        }
    }
}