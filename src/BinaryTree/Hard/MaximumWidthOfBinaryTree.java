package BinaryTree.Hard;

import BinaryTree.TreeNode;

import java.util.*;

public class MaximumWidthOfBinaryTree {
    public static void main(String[] args) {
        System.out.println("Rahul khichar");

        TreeNode treeNode = new TreeNode();
        int[] input = {1, 3, 2, 5, -1, -1, 9, 6, -1, 7};
        TreeNode root = treeNode.buildTreePreOrder(input);

        MaximumWidthOfBinaryTree maximumWidthOfBinaryTree = new MaximumWidthOfBinaryTree();
        System.out.println(maximumWidthOfBinaryTree.thirdSolution(root));
    }

    public int widthOfBinaryTree(TreeNode root) {

        int ans = 0;
        Queue<TreeNodeWithPosition> queue = new LinkedList<>();
        queue.add(new TreeNodeWithPosition(root, 0));

        while (!queue.isEmpty()) {
            int size = queue.size();
            int minIndex = Integer.MAX_VALUE;
            int maxIndex = Integer.MIN_VALUE;
            while (size > 0) {
                size--;

                TreeNodeWithPosition treeNodeWithPosition = queue.poll();

                TreeNode treeNode = treeNodeWithPosition.treeNode;
                int xIndex = treeNodeWithPosition.xIndex;
                minIndex = Math.min(minIndex, xIndex);
                maxIndex = Math.max(maxIndex, xIndex);
                if (treeNode.left != null) {
                    queue.add(new TreeNodeWithPosition(treeNode.left, xIndex - 1));
                }

                if (treeNode.right != null) {
                    queue.add(new TreeNodeWithPosition(treeNode.right, xIndex + 1));
                }


            }

            ans = Math.max(ans, (maxIndex - minIndex));
        }
        return ans;
    }


    public int secondSolution(TreeNode root) {

        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        int ans = 0;
        while (list.size() > 0) {

            int listSize = list.size();
            ans = Math.max(ans, listSize);
            while (listSize > 0) {
                listSize--;
                TreeNode treeNode = list.remove(0);
                if (treeNode == null) {
                    list.add(null);
                    list.add(null);
                } else {
                    list.add(treeNode.left);
                    list.add(treeNode.right);
                }
            }

            while (list.size() > 0 && list.get(0) == null) {
                list.remove(0);
            }
            while (list.size() > 0 && list.get(list.size() - 1) == null) {
                list.remove(list.size() - 1);
            }

        }
        return ans;

    }

    public int thirdSolution(TreeNode root) {

        Deque<TreeNodeWithPosition> queue = new LinkedList();

        queue.add(new TreeNodeWithPosition(root, 0));
        int ans = 0;

        while (!queue.isEmpty()) {
            int n = queue.size();

            TreeNodeWithPosition firstNode = queue.peek();
            TreeNodeWithPosition lastNode = queue.peekLast();
            ans = Math.max(ans, lastNode.xIndex - firstNode.xIndex);

            for (int index = 0; index < n; index++) {
                TreeNodeWithPosition treeNodeWithPosition = queue.poll();
                TreeNode treeNode = treeNodeWithPosition.treeNode;
                int position = treeNodeWithPosition.xIndex;

                if (treeNode.left != null) {
                    queue.add(new TreeNodeWithPosition(treeNode.left, 2 * position));
                }
                if (treeNode.right != null) {
                    queue.add(new TreeNodeWithPosition(treeNode.right, 2 * position + 1));
                }
            }

        }

        return ans;
    }

    public class TreeNodeWithPosition {

        TreeNode treeNode;
        int xIndex;

        TreeNodeWithPosition(TreeNode treeNode, int xIndex) {
            this.treeNode = treeNode;
            this.xIndex = xIndex;

        }

    }
}
