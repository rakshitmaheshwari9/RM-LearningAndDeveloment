package BinarySearchTree;

// Generic Tree Rahul khichar
public class TreeNode<T> {

    public TreeNode<T> left = null;
    public TreeNode<T> right = null;
    public T data;

    TreeNode(T data, TreeNode<T> left, TreeNode<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

}
