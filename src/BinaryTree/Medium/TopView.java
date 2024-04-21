package BinaryTree.Medium;

import java.util.*;

public class TopView {

    public static void main(String[] args) {
        System.out.println("Rahul khichar");
    }

    static ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) return list;

        Queue<NodeWithValue> queue = new LinkedList<>();
        queue.add(new NodeWithValue(root, 0));
        Map<Integer, Integer> mp = new HashMap<>();
        int minIndex = Integer.MAX_VALUE;
        int maxIndex = Integer.MIN_VALUE;

        while (!queue.isEmpty()) {

            int queueSize = queue.size();

            while (queueSize > 0) {

                queueSize--;

                NodeWithValue nodeWithValue = queue.poll();
                Node node = nodeWithValue.node;
                int xIndex = nodeWithValue.xIndex;

                minIndex = Math.min(minIndex, xIndex);
                maxIndex = Math.max(maxIndex, xIndex);

                if (!mp.containsKey(xIndex)) mp.put(xIndex, node.data);

                if (node.left != null) {
                    queue.add(new NodeWithValue(node.left, xIndex - 1));
                }
                if (node.right != null) {
                    queue.add(new NodeWithValue(node.left, xIndex + 1));
                }

            }

        }

        for (int index = minIndex; index <= maxIndex; index++) {
            if (mp.containsKey(index)) list.add(mp.get(index));
        }
        return list;

    }

    static class NodeWithValue {
        Node node;
        int xIndex;

        NodeWithValue(Node node, int xIndex) {
            this.node = node;
            this.xIndex = xIndex;
        }
    }

    class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

}
