package Chapter14_BinarySearchTrees;

import java.util.Random;

public class BinarySearchTrees_00_SearchBST {
    public static BSTNode<Integer> searchBST(BSTNode<Integer> tree, int key){
        return tree == null || tree.data == key
                ? tree
                : (key < tree.data ? searchBST(tree.left, key) : searchBST(tree.right, key));
    }
    public static void test(){
        int[] arr = new int[10];
        Random r = new Random();
        BSTNode<Integer> root = new BSTNode<>(r.nextInt(100));
        for (int i = 0; i < 10; i++){
            int n = r.nextInt(100);
            arr[i] = n;
            BSTNode.addToTree(root, n);
        }
        for (int i = 0; i < 10; i++){
            BSTNode<Integer> res = searchBST(root, arr[i]);
            if (res != null){
                System.out.println(String.format("search number: %d  result: %d", arr[i], res.data));
            }
            else {
                System.out.println(String.format("search number: %d  result: null", arr[i]));
            }
        }
    }
}
