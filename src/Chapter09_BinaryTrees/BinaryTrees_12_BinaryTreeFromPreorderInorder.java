package Chapter09_BinaryTrees;

import java.util.*;

public class BinaryTrees_12_BinaryTreeFromPreorderInorder {
    public static BinaryTreeNode<Integer> binaryTreeFromPreorderInorder(List<Integer> preorder,
                                                                        List<Integer> inorder) {
        Map<Integer, Integer> nodeToInorderIndex = new HashMap<>();
        for (int i = 0; i < inorder.size(); ++i) {
            nodeToInorderIndex.put(inorder.get(i), i);
        }

        return helper(preorder,
                0,
                preorder.size(),
                0,
                inorder.size(),
                nodeToInorderIndex);
    }

    private static BinaryTreeNode<Integer> helper(List<Integer> preorder,
                                                  int preorderStart,
                                                  int preoderEnd,
                                                  int inorderStart,
                                                  int inorderEnd,
                                                  Map<Integer, Integer> nodeToInorderIndex) {
        if (preoderEnd <= preorderStart || inorderEnd <= inorderStart) {
            return null;
        }

        int rootInorderIndex = nodeToInorderIndex.get(preorder.get(preorderStart));
        int leftSubtreeSize = rootInorderIndex - inorderStart;

        BinaryTreeNode<Integer> left = helper(preorder,
                preorderStart + 1,
                preorderStart + 1 + leftSubtreeSize,
                inorderStart,
                rootInorderIndex,
                nodeToInorderIndex
        );

        BinaryTreeNode<Integer> right = helper(preorder,
                preorderStart + 1 + leftSubtreeSize,
                preoderEnd,
                rootInorderIndex + 1,
                inorderEnd,
                nodeToInorderIndex);

        return new BinaryTreeNode<>(preorder.get(preorderStart), left, right);
    }

    public static void main(String[] args) {
        //List<Integer> inorder = new ArrayList<>(Arrays.asList(28,271,0,6,561,17,3,314,2,401,641,1,257,6,271,28));
        //List<Integer> preorder = new ArrayList<>(Arrays.asList(314,6,271,28,0,561,3,17,6,2,1,401,641,257,271,28));
        List<Integer> inorder = new ArrayList<>(Arrays.asList(4, 2, 5, 1, 3));
        List<Integer> preorder = new ArrayList<>(Arrays.asList(1, 2, 4, 5, 3));
        BinaryTreeNode<Integer> res = binaryTreeFromPreorderInorder(preorder, inorder);

    }
}
