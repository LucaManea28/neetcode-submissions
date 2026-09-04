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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder s = new StringBuilder();
        dfsS(root, s);
        return s.toString();
    }
    private void dfsS(TreeNode root, StringBuilder s){
        if(root == null)
            s.append("N").append(" ");
        else{
            s.append(root.val).append(" ");
            dfsS(root.left, s);
            dfsS(root.right, s);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] values = data.split(" ");
        Queue<String> queue = new LinkedList<>(Arrays.asList(values));
        return dfsD(queue);
    }

    private TreeNode dfsD(Queue<String> queue){
        String current = queue.poll();
        if(current == null || current.equals("N"))
            return null;
        TreeNode root = new TreeNode(Integer.parseInt(current));
        root.left = dfsD(queue);
        root.right = dfsD(queue);
        return root;
    }
}
