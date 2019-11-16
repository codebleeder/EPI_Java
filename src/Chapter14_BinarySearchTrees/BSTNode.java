package Chapter14_BinarySearchTrees;

public class BSTNode<T> {
    public T data;
    public BSTNode<T> left, right;
    public BSTNode(){}
    public BSTNode(T d){
        data = d;
    }
    public BSTNode(T d, BSTNode<T> l, BSTNode<T> r){
        data = d;
        left = l;
        right = r;
    }
    public static void addToTree(BSTNode<Integer> root, int newVal){
        BSTNode<Integer> iter = root;
        while (iter != null){
            if (iter.data > newVal){
                if (iter.left == null){
                    break;
                }
                iter = iter.left;
            }
            else {
                if (iter.right == null){
                    break;
                }
                iter = iter.right;
            }
        }
        if (iter.data > newVal){
            iter.left = new BSTNode<>(newVal);
        }
        else {
            iter.right = new BSTNode<>(newVal);
        }
    }
}
