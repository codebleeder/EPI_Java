package Chapter09_BinaryTrees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BinaryTrees_08_PreorderTraversal {
    private static List<Integer> preorderTraversal(BinaryTreeNode<Integer> root) {
        Deque<BinaryTreeNode<Integer>> stack = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();
        BinaryTreeNode<Integer> curr = root;
        while (!stack.isEmpty() || curr != null) {
            if (curr != null) {
                stack.addFirst(curr);
                result.add(curr.data);
                curr = curr.left;
            } else {
                curr = stack.removeFirst();
                curr = curr.right;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // 314,6,271,28,0,561,3,17,6,2,1,401,641,257,271,28
        BinaryTreeNode<Integer> root = BinaryTreeNode.buildExampleTree();
        List<Integer> res = preorderTraversal(root);
        System.out.println(res);
    }
}
