package Chapter14_BinarySearchTrees;

import Chapter09_BinaryTrees.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTrees_01_IsBinaryTreeBST {
    public static boolean isBinaryTreeBST(BinaryTreeNode<Integer> root){
        return areKeysInRange(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean areKeysInRange(BinaryTreeNode<Integer> root, int minValue, int maxValue) {
        if (root == null){
            return true;
        }
        else if (root.data < minValue || root.data > maxValue){
            return false;
        }
        return areKeysInRange(root.left, minValue, root.data) &&
                areKeysInRange(root.right, root.data, maxValue);
    }

    private static boolean areKeysInRangeBST(BSTNode<Integer> root, int minValue, int maxValue) {
        if (root == null){
            return true;
        }
        else if (root.data < minValue || root.data > maxValue){
            return false;
        }
        return areKeysInRangeBST(root.left, minValue, root.data) &&
                areKeysInRangeBST(root.right, root.data, maxValue);
    }

    public static boolean isValidBST(BSTNode<Integer> root){
        return areKeysInRangeBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static void test(){
        BinaryTreeNode<Integer> root1 = new BinaryTreeNode<>(45);
        BinaryTreeNode<Integer> a = new BinaryTreeNode<>(40, new BinaryTreeNode<>(35), new BinaryTreeNode<>(42));
        BinaryTreeNode<Integer> b = new BinaryTreeNode<>(50, new BinaryTreeNode<>(47), new BinaryTreeNode<>(55));
        root1.left = a;
        root1.right = b;

        System.out.println(isBinaryTreeBST(root1));
        a.right = new BinaryTreeNode<>(50);
        System.out.println(isBinaryTreeBST(root1));

        System.out.println("case 3: expected: true; testing implementation 2");
        BinaryTreeNode<Integer> root2 = BinarySearchTrees_00_BSTLibraries.buildExampleBinaryTree();
        System.out.println(isBinaryTreeBST2(root2));

    }

    public static class QueueEntry{
        public BinaryTreeNode<Integer> treeNode;
        public Integer lowerBound, upperBound;
        public QueueEntry(BinaryTreeNode<Integer> treeNode, Integer l, Integer u) {
            treeNode = treeNode;
            lowerBound = l;
            upperBound = u;
        }
    }

    public static boolean isBinaryTreeBST2(BinaryTreeNode<Integer> root){
        Queue<QueueEntry> queueEntries = new LinkedList<>();
        queueEntries.add(new QueueEntry(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
        QueueEntry headEntry;
        while ((headEntry = queueEntries.poll()) != null){
            if (headEntry.treeNode != null){
                if (headEntry.treeNode.data < headEntry.lowerBound ||
                headEntry.treeNode.data > headEntry.upperBound){
                    return false;
                }
                queueEntries.add(new QueueEntry(headEntry.treeNode.left,
                        headEntry.lowerBound,
                        headEntry.treeNode.data));
                queueEntries.add(new QueueEntry(headEntry.treeNode.right,
                        headEntry.treeNode.data,
                        headEntry.upperBound));
            }
        }
        return true;
    }
}
