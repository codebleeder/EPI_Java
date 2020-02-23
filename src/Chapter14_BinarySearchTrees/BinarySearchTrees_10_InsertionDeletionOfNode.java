package Chapter14_BinarySearchTrees;

import Chapter09_BinaryTrees.BinaryTreeNode;
import com.sun.source.tree.BinaryTree;

public class BinarySearchTrees_10_InsertionDeletionOfNode {
    public static class BinarySearchTree {

        private BSTNode<Integer> root = null;
        public BinarySearchTree(BSTNode<Integer> root){
            this.root = root;
        }
        public boolean insert(Integer key){
            if (root == null){
                root = new BSTNode<>(key);
            }
            else {
                BSTNode<Integer> curr = root;
                BSTNode<Integer> parent = root;
                while (curr != null) {
                    parent = curr;
                    if (key > curr.data){
                        curr = curr.right;
                    }
                    else {
                        curr = curr.left;
                    }
                }
                if (key > parent.data){
                    parent.right = new BSTNode<>(key);
                }
                else {
                    parent.left = new BSTNode<>(key);
                }
            }
            return true;
        }

        /*
        case 1: node to be deleted has no children - remove child from parent
        case 2: node has one child, we replace the node with it's child
        case 3: node has 2 children: replace it with it's successor in right subtree;
                delete successor from it's original position
         */
        public boolean delete(Integer key){
            // find the node with key
            BSTNode<Integer> curr = root, parent = null;
            while (curr != null && Integer.compare(curr.data, key) != 0){
                parent = curr;
                curr = Integer.compare(key, curr.data) > 0 ? curr.right : curr.left;
            }
            if (curr == null) {
                return false;
            }
            BSTNode<Integer> keyNode = curr;
            if (keyNode.right != null)
            {
                // find min of right subtree
                BSTNode<Integer> rKeyNode = keyNode.right;
                BSTNode<Integer> rParent = keyNode;
                while (rKeyNode.left != null){
                    rParent = rKeyNode;
                    rKeyNode = rKeyNode.left;
                }
                keyNode.data = rKeyNode.data;
                if (rParent.left == rKeyNode){
                    rParent.left = rKeyNode.right;
                }
                else {
                    rParent.right = rKeyNode.right;
                }
                rKeyNode.right = null;
            }
            else{
                if (root == keyNode){
                    root = keyNode.left;
                    keyNode.left = null;
                }
                else {
                    if (parent.left == keyNode){
                        parent.left = keyNode.left;
                    }
                    else {
                        parent.right = keyNode.left;
                    }
                    keyNode.left = null;
                }
            }
            return true;
        }


    }
    public static void test(){
        BSTNode<Integer> root = BinarySearchTrees_00_BSTLibraries.buildExampleBST();
        BinarySearchTree bst = new BinarySearchTree(root);
        // refer to fig 14.1
        bst.insert(45);
        bst.delete(41); // node N
        bst.delete(17); // node G
        bst.delete(19); // node A - root
    }
}
