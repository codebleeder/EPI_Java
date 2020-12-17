package Chapter09_BinaryTrees;

public class BinaryTrees_09_FindKthNodeBinaryTree {
    public static BinaryTreeNode<Integer> findKthNodeBinaryTree(BinaryTreeNode<Integer> root,
                                                                int k) {
        if (root == null) return null;
        if (k == 1) return root;
        if (root.left != null) {
            if (root.left.size > k) {
                return findKthNodeBinaryTree(root.left, k - 1);
            }
        } else {
            return null;
        }
        if (root.right != null) {
            return findKthNodeBinaryTree(root.right, k - root.left.size - 1);
        }
        return null;
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = BinaryTreeNode.buildExampleTree();
        BinaryTreeNode<Integer> res = findKthNodeBinaryTree(root, 10);
        if (res != null) System.out.println(res.data);

        BinaryTreeNode<Integer> res2 = findKthNodeBinaryTree(root, 6);
        if (res2 != null) System.out.println(res2.data);

        BinaryTreeNode<Integer> res3 = findKthNodeBinaryTree(root, 20);
        if (res3 != null) System.out.println(res3.data);
        else System.out.println("null");
    }
}
