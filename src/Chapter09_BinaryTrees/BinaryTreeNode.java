package Chapter09_BinaryTrees;

public class BinaryTreeNode<T> {
    public T data;
    public BinaryTreeNode<T> left, right;

    public BinaryTreeNode(T d){
        data = d;
    }
    public BinaryTreeNode(T d, BinaryTreeNode<T> left, BinaryTreeNode<T> right){
        data = d;
        this.left = left;
        this.right = right;
    }
}
