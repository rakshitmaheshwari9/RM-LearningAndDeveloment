package BinaryTree.Medium;

import BinaryTree.TreeNode;

import java.util.*;

public class VerticalOrderTraversalSecondMethod {

    public VerticalOrderTraversalSecondMethod() {

    }

    public static void main(String[] args) {
        System.out.println("Rahul khicar");

        int[] input = {1, 2, 3, 4, 6, 5, 7};
        TreeNode treeNode = new TreeNode();
        TreeNode node = treeNode.buildTree(input);
        VerticalOrderTraversalSecondMethod verticalOrderTraversal = new VerticalOrderTraversalSecondMethod();
        verticalOrderTraversal.VerticalOrderTraversalSecondMethod(node);
    }

    public List<List<Integer>> VerticalOrderTraversalSecondMethod(TreeNode treeNode) {

        List<List<Integer>> ans = new ArrayList<>();
        if (treeNode == null) return ans;
        Map<Integer, List<TravesTree>> mp = new HashMap<>();

        Queue<TravesTree> queue = new LinkedList<>();

        queue.add(new TravesTree(treeNode, 0, 0));

        int minIndex = Integer.MAX_VALUE;
        int maxIndex = Integer.MIN_VALUE;


        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int index = 0; index < n; index++) {
                TravesTree temp = queue.poll();
                TreeNode tempTreeNode = temp.treeNode;
                int level = temp.level;
                int xIndex = temp.xIndex;

                minIndex = Math.min(minIndex, xIndex);
                maxIndex = Math.max(maxIndex, xIndex);

                if (tempTreeNode.left != null) {
                    queue.add(new TravesTree(tempTreeNode.left, level + 1, xIndex - 1));
                }
                if (tempTreeNode.right != null) {
                    queue.add(new TravesTree(tempTreeNode.right, level + 1, xIndex + 1));
                }

                List<TravesTree> list;
                if (mp.containsKey(xIndex)) {
                    list = mp.get(xIndex);
                } else {
                    list = new ArrayList<>();
                }
                list.add(temp);
                mp.put(xIndex, list);
            }
        }


        for (int index = minIndex; index <= maxIndex; index++) {

            if (mp.containsKey(index)) {
                List<TravesTree> list = mp.get(index);
                list.sort(new Comparator<TravesTree>() {
                    @Override
                    public int compare(TravesTree o1, TravesTree o2) {
                        if (o1.level == o2.level) return Integer.compare(o1.val, o2.val);
                        return Integer.compare(o1.level, o2.level);
                    }
                });

                List<Integer> finalAns = new ArrayList<>();
                for (TravesTree travesTree : list) {
                    finalAns.add(travesTree.val);
                }
                ans.add(finalAns);
            }
        }


        return ans;


    }


    public class TravesTree {
        int xIndex;
        int level;
        TreeNode treeNode;
        int val;


        public TravesTree(TreeNode treeNode, int level, int xIndex) {
            this.treeNode = treeNode;
            this.level = level;
            this.xIndex = xIndex;
            this.val = treeNode.val;

        }

    }
}
