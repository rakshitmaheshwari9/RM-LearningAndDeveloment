package BinarySearchTree.practice;

import BinaryTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class BSTIterator {

    Queue<Integer> queue;

    public BSTIterator(TreeNode root) {
        this.queue = new LinkedList<>();
        preOrderTraversal(root);


    }


    public void preOrderTraversal(TreeNode root) {
        if (root == null) return;
        preOrderTraversal(root.left);
        this.queue.add(root.val);
        preOrderTraversal(root.right);

    }

    public int next() {
        return queue.poll();
    }

    public boolean hasNext() {
        if (!queue.isEmpty()) return true;
        return false;
    }
}
