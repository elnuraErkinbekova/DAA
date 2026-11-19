package week8.range_sum_BST;

import utils.TreeNode;
import utils.TreeBuilder;

public class RangeSumBST {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }

        int currentValue = 0;
        if (root.val >= low && root.val <= high) {
            currentValue = root.val;
        }

        if (root.val < low) {
            int rightSum = rangeSumBST(root.right, low, high);
            return currentValue + rightSum;
        } else if (root.val > high) {
            int leftSum = rangeSumBST(root.left, low, high);
            return currentValue + leftSum;
        } else {
            int leftSum = rangeSumBST(root.left, low, high);
            int rightSum = rangeSumBST(root.right, low, high);
            return currentValue + leftSum + rightSum;
        }
    }

    public static void main(String[] args) {
        TreeNode exampleBST = TreeBuilder.buildTree(10, 5, 15, 3, 7, null, 18);

        RangeSumBST solver = new RangeSumBST();
        int result = solver.rangeSumBST(exampleBST, 7, 15);

        System.out.println(result);
    }
}


