package Chapter09_BinaryTrees;

public class BinaryTrees_00_Traversals {
    // inorder: left -> root -> right
    public static void inorder(BinaryTreeNode<Integer> root) {
        if (root == null) return;
        inorder(root.left);
        System.out.println(root.data);
        inorder(root.right);
    }

    // Pre-order: root -> left -> right
    public static void preorder(BinaryTreeNode<Integer> root) {
        if (root == null) return;
        System.out.println(root.data);
        preorder(root.left);
        preorder(root.right);
    }

    // Post-order left -> right -> root
    public static void postorder(BinaryTreeNode<Integer> root) {
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.println(root.data);
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = BinaryTreeNode.buildExampleTree();
        System.out.println("inorder: ");
        inorder(root);

        System.out.println("\npreorder: ");
        preorder(root);

        System.out.println("\npostorder: ");
        //postorder(root);
    }
}
