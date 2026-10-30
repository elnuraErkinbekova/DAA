package week6.invert_tree;

public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temporary = root.left;
        root.left = root.right;
        root.right = temporary;

        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}