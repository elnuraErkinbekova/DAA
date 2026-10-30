package week6.tree_paths;

import java.util.ArrayList;
import java.util.List;

public class TreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        helper(root, "", result);
        return result;
    }

    private void helper(TreeNode node, String currentPath, List<String> result) {
        if (node == null) {
            return;
        }
        currentPath += node.val;
        if (node.left == null && node.right == null) {
            result.add(currentPath);
            return;
        }
        currentPath += "->";
        helper(node.left, currentPath, result);
        helper(node.right, currentPath, result);
    }
}