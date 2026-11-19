package week8.convert_array_to_BST;

import utils.TreeBuilder;
import utils.TreeNode;

public class ArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildBST(nums, 0, nums.length - 1);
    }

    private TreeNode buildBST(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);

        root.left = buildBST(nums, left, mid - 1);
        root.right = buildBST(nums, mid + 1, right);

        return root;
    }

    public static void main(String[] args) {
        ArrayToBST solver = new ArrayToBST();

        int[] nums = {-10, -3, 0, 5, 9};
        TreeNode result = solver.sortedArrayToBST(nums);
        System.out.println(TreeBuilder.toLevelOrderList(result));
    }
}

