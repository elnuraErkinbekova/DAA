package week8.search_BST;

import utils.TreeNode;
import utils.TreeBuilder;

public class SearchBST {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        if (root.val == val) {
            return root;
        } else if (root.val > val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }

    public static void main(String[] args) {
        TreeNode exampleBST = TreeBuilder.buildTree(4,2,7,1,3);

        SearchBST solver = new SearchBST();
        TreeNode result = solver.searchBST(exampleBST, 2);

        System.out.println(TreeBuilder.toLevelOrderList(result));
    }
}
