package Chapter09_BinaryTrees;

public class BinaryTrees_10_FindSuccessor {
    public static BinaryTreeNode<Integer> findSuccessor(BinaryTreeNode<Integer> node) {
        BinaryTreeNode<Integer> iter = node;
        // if node has right tree, the successor is leftmost node of the right tree
        if (node.right != null) {
            iter = node.right;

            while (iter.left != null) {
                iter = iter.left;
            }
            return iter;
        }

        // keep moving up as long as iter is in right
        while (iter.parent != null && iter == iter.parent.right) {
            iter = iter.parent;
        }
        return iter.parent;
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = BinaryTreeNode.buildExampleTree();
        BinaryTreeNode<Integer> g = BinaryTreeNode.getNode(root, 3);
        BinaryTreeNode<Integer> res1 = findSuccessor(g);
        if (res1 != null) System.out.println(res1.data);

        BinaryTreeNode<Integer> res2 = findSuccessor(root);
        if (res2 != null) System.out.println(res2.data);
    }
}
