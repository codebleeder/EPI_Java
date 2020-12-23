package Chapter09_BinaryTrees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinaryTrees_13_ReconstructFromPreorder {
    private static Integer subtreeIndex;

    private static BinaryTreeNode<Integer> reconstructPreorder(List<Integer> preorder) {
        subtreeIndex = 0;
        return helper(preorder);
    }

    private static BinaryTreeNode helper(List<Integer> preorder) {
        Integer key = preorder.get(subtreeIndex);
        ++subtreeIndex;
        if (key == null) {
            return null;
        }
        BinaryTreeNode<Integer> left = helper(preorder);
        BinaryTreeNode<Integer> right = helper(preorder);
        return new BinaryTreeNode<Integer>(key, left, right);
    }

    public static void main(String[] args) {
        List<Integer> preorder = new ArrayList<>(Arrays.asList(0, 1, 2, null, null, 3, 4, null,
                null, null, 5, null, 6, null, 7, 8, null, null, null));
        BinaryTreeNode<Integer> res = reconstructPreorder(preorder);
    }
}
