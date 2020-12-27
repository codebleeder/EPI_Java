package Chapter09_BinaryTrees;

public class BinaryTrees_16_ConstructRightSibling {
    // takes a perfect binary tree
    public static void constructRightSibling(BinaryTreeNode<Integer> node) {
        while (node != null && node.left != null && node.right != null) {
            BinaryTreeNode<Integer> iter = node;

            while (iter != null) {
                iter.left.levelNext = iter.right;
                if (iter.right != null && iter.levelNext != null) {
                    iter.right.levelNext = iter.levelNext.left;
                }
                iter = iter.levelNext;
            }
            node = node.left;
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = BinaryTreeNode.buildPerfectTree();
        constructRightSibling(root);
    }
}
