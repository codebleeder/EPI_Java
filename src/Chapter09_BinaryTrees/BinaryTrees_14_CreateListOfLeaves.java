package Chapter09_BinaryTrees;

import java.util.LinkedList;
import java.util.List;

public class BinaryTrees_14_CreateListOfLeaves {
    private static List<Integer> list = new LinkedList<>();

    private static List<Integer> createListOfLeaves(BinaryTreeNode<Integer> root) {
        helper(root);
        return list;
    }

    private static void helper(BinaryTreeNode<Integer> root) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            list.add(root.data);
        }
        if (root.left != null) {
            helper(root.left);
        }
        if (root.right != null) {
            helper(root.right);
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = BinaryTreeNode.buildExampleTree();
        List<Integer> res = createListOfLeaves(root);
        System.out.println(res);
    }
}
