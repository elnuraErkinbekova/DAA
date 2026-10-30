package week6.path_sum;

import java.util.ArrayList;
import java.util.List;

public class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        List<Integer> allSums = new ArrayList<>();
        collectSums(root, 0, allSums);

        for (int i = 0; i < allSums.size(); i++) {
            if (allSums.get(i) == targetSum) {
                return true;
            }
        }
        return false;
    }

    private void collectSums(TreeNode node, int currentSum, List<Integer> allSums) {
        if (node == null) {
            return;
        }
        currentSum += node.val;
        if (node.left == null && node.right == null) {
            allSums.add(currentSum);
            return;
        }
        collectSums(node.left, currentSum, allSums);
        collectSums(node.right, currentSum, allSums);
    }
}