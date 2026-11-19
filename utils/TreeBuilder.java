package utils;

import java.util.ArrayList;
import java.util.List;

public class TreeBuilder {

    public static TreeNode buildTree(Integer... values) {
        if (values == null || values.length == 0 || values[0] == null) {
            return null;
        }

        TreeNode root = new TreeNode(values[0]);
        List<TreeNode> queue = new ArrayList<>();
        queue.add(root);

        int index = 1;
        int front = 0;

        while (front < queue.size() && index < values.length) {
            TreeNode current = queue.get(front++);

            if (index < values.length && values[index] != null) {
                current.left = new TreeNode(values[index]);
                queue.add(current.left);
            }
            index++;

            if (index < values.length && values[index] != null) {
                current.right = new TreeNode(values[index]);
                queue.add(current.right);
            }
            index++;
        }

        return root;
    }

    public static List<Integer> toLevelOrderList(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        List<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        int front = 0;

        while (front < queue.size()) {
            TreeNode current = queue.get(front++);
            if (current == null) {
                result.add(null);
            } else {
                result.add(current.val);
                queue.add(current.left);
                queue.add(current.right);
            }
        }

        while (!result.isEmpty() && result.get(result.size() - 1) == null) {
            result.remove(result.size() - 1);
        }

        return result;
    }


    private static void collectLevels(TreeNode node, int level, List<List<Integer>> levels) {
        if (node == null) {
            return;
        }
        if (levels.size() == level) {
            levels.add(new ArrayList<>());
        }
        levels.get(level).add(node.val);
        collectLevels(node.left, level + 1, levels);
        collectLevels(node.right, level + 1, levels);
    }
}
