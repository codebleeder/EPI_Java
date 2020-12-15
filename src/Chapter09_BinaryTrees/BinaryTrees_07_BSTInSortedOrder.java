package Chapter09_BinaryTrees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BinaryTrees_07_BSTInSortedOrder {
    public static List<Integer> BSTInSortedOrder(BinaryTreeNode<Integer> root) {
        Deque<BinaryTreeNode<Integer>> stack = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();
        BinaryTreeNode<Integer> curr = root;
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.addFirst(curr);
                curr = curr.left;
            } else {
                curr = stack.removeFirst();
                res.add(curr.data);
                curr = curr.right;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        // 28,271,0,6,561,17,3,314,2,401,641,1,257,6,271,28
        BinaryTreeNode<Integer> root = BinaryTreeNode.buildExampleTree();
        List<Integer> res = BSTInSortedOrder(root);
        System.out.println(res);
    }
}
