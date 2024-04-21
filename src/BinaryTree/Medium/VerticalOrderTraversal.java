package BinaryTree.Medium;

import BinaryTree.TreeNode;

import java.util.*;

public class VerticalOrderTraversal {

    public static void main(String[] args) {
        System.out.println("Rahul khicar");

        int[] input = {1, 2, 3, 4, 6, 5, 7};
        TreeNode treeNode = new TreeNode();
        TreeNode node = treeNode.buildTree(input);
        VerticalOrderTraversal verticalOrderTraversal = new VerticalOrderTraversal();
        verticalOrderTraversal.verticalTraversal(node);
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;

        Queue<TravesTree> queue = new LinkedList<>();

        Map<Integer, List<TravesTree>> mp = new HashMap<>();
        int minIndex = Integer.MAX_VALUE;
        int maxIndex = Integer.MIN_VALUE;

        queue.add(new TravesTree(0, root, 0));
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int index = 0; index < size; index++) {
                TravesTree travesTree = queue.poll();
                TreeNode treeNode = travesTree.treeNode;
                int xIndex = travesTree.xIndex;
                int level = travesTree.level;
                minIndex = Math.min(minIndex, xIndex);
                maxIndex = Math.max(maxIndex, xIndex);

                List<TravesTree> test;
                if (mp.containsKey(xIndex)) {
                    test = mp.get(xIndex);
                } else {
                    test = new ArrayList<>();
                }
                test.add(new TravesTree(treeNode.val, level));
                mp.put(xIndex, test);

                if (treeNode.left != null) {
                    queue.add(new TravesTree(xIndex - 1, treeNode.left, level + 1));
                }

                if (treeNode.right != null) {
                    queue.add(new TravesTree(xIndex + 1, treeNode.right, level + 1));
                }
            }
        }

        for (int index = minIndex; index <= maxIndex; index++) {

            if (mp.containsKey(index)) {
                List<TravesTree> temp = mp.get(index);
                temp.sort(new Comparator<TravesTree>() {
                    @Override
                    public int compare(TravesTree o1, TravesTree o2) {
                        if (o1.level == o2.level)
                            return o1.level - o2.level;
                        else
                            return o1.val - o2.val;
                    }
                });

                List<Integer> finalResult = new ArrayList<>();
                for (TravesTree travesTree : temp) {
                    finalResult.add(travesTree.val);

                }
                ans.add(finalResult);
            }
        }

//        for (List<Integer> value : mp.values()) {
//
//        }
        return ans;

    }

    public class TravesTree {
        int xIndex;
        int level;
        TreeNode treeNode;
        int val;

        public TravesTree(int xIndex, TreeNode treeNode, int level) {
            this.xIndex = xIndex;
            this.level = level;
            this.treeNode = treeNode;
        }

        public TravesTree(int val, int level) {
            this.level = level;
            this.val = val;
        }
    }
}
