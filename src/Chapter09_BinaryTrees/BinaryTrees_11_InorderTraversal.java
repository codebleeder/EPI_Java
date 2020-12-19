package Chapter09_BinaryTrees;

import java.util.ArrayList;
import java.util.List;

// inorder traversal in O(1) space
public class BinaryTrees_11_InorderTraversal {
    public static List<Integer> inorderTraversal(BinaryTreeNode<Integer> root) {
        BinaryTreeNode<Integer> iter = root;
        BinaryTreeNode<Integer> prev = null;
        List<Integer> res = new ArrayList<>();

        while (iter != null) {
            BinaryTreeNode<Integer> next;
            if (iter.parent == prev) {
                if (iter.left != null) {
                    next = iter.left;
                } else {
                    res.add(iter.data);
                    next = (iter.right != null) ? iter.right : iter.parent;
                }
            } else if (iter.left == prev) {
                res.add(iter.data);
                next = (iter.right != null) ? iter.right : iter.parent;
            } else {
                next = iter.parent;
            }
            prev = iter;
            iter = next;
        }
        return res;
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = BinaryTreeNode.buildExampleTree();
        List<Integer> res = inorderTraversal(root);
        System.out.println(res);
    }
}
