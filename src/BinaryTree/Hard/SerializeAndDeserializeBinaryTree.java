package BinaryTree.Hard;

import BinaryTree.TreeNode;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree {

    public static void main(String[] args) {
        System.out.println("Rahul khichar");

        System.out.println();
        SerializeAndDeserializeBinaryTree serializeAndDeserializeBinaryTree = new SerializeAndDeserializeBinaryTree();

        TreeNode treeNode = serializeAndDeserializeBinaryTree.deserialize("1");
        String str = serializeAndDeserializeBinaryTree.serialize(treeNode);
        TreeNode treeNode2 = serializeAndDeserializeBinaryTree.deserialize(str);
        String ans = serializeAndDeserializeBinaryTree.serialize(treeNode2);
        System.out.println(str);
        System.out.println(ans);

//        System.out.println(serializeAndDeserializeBinaryTree.deserialize());
    }


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        String ans = "";
        queue.add(root);

        while (!queue.isEmpty()) {

            int queueSize = queue.size();

            boolean notNullThere = false;

            for (int index = 0; index < queueSize; index++) {

                TreeNode queueFront = queue.poll();
                if (queueFront != null) {
                    ans += queueFront.val + "b";
                    queue.add(queueFront.left);
                    queue.add(queueFront.right);
                } else {
                    ans += 'n' + "b";
                }

                if (queueFront != null && (queueFront.left != null || queueFront.right != null)) {
                    notNullThere = true;
                }
            }
            if (!notNullThere) break;
        }

        return ans;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {


        String[] str = data.split("b");

        //        String
        TreeNode treeNode = null;
        if (str.length <= 1) return null;

        Queue<TreeNode> topQueue = new LinkedList<>();
        int index = 0;
        topQueue.add(new TreeNode(Integer.parseInt(str[index])));
        treeNode = topQueue.peek();
        index++;

        while (!topQueue.isEmpty()) {
            int size = topQueue.size();
            Queue<TreeNode> secondQueue = new LinkedList<>();
            for (int number = 0; number < size; number++) {
                TreeNode topNodeFront = topQueue.poll();
                if (topNodeFront != null) {
                    if (index >= str.length) return treeNode;
                    String leftValue = str[index];
                    index++;
                    if (index >= str.length) return treeNode;
                    String rightValue = str[index];
                    index++;

                    TreeNode leftNode = null;
                    TreeNode rightNode = null;

                    if (!Objects.equals(leftValue, "n")) leftNode = new TreeNode(Integer.parseInt(leftValue));
                    if (!Objects.equals(rightValue, "n")) rightNode = new TreeNode(Integer.parseInt(rightValue));
                    topNodeFront.left = leftNode;
                    topNodeFront.right = rightNode;
                    secondQueue.add(leftNode);
                    secondQueue.add(rightNode);
                }
            }
            while (!secondQueue.isEmpty()) {
                topQueue.add(secondQueue.poll());
            }
        }
        return treeNode;
    }
}
