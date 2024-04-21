package BinaryTree.Hard;

import BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class AllNodesDistanceK {

    public static void main(String[] args) {

        System.out.println("Rahul khichar");
    }


    public boolean isFind(TreeNode root, TreeNode target) {
        if (root == null) return false;
        if (root.val == target.val) return true;
        return isFind(root.left, target) || isFind(root.right, target);
    }

    public List<TreeNode> findAllTheNode(TreeNode root, TreeNode target) {
        List<TreeNode> ans = new ArrayList<>();
        if (root == null) return ans;

        if (root.val == target.val) {
            ans.add(root);
            return ans;
        }

        boolean isLeft = isFind(root.left, target);
        List<TreeNode> list;
        if (isLeft) {
            list = findAllTheNode(root.left, target);
        } else {
            list = findAllTheNode(root.right, target);
        }
        list.add(root);
        return list;

    }

    public List<Integer> level(TreeNode root, int level) {
        if (root == null) return null;

        if (level == 0) {
            List<Integer> list = new ArrayList<>();
            list.add(root.val);
            return list;
        }
        List<Integer> ans = null;
        if (root.left != null) {
            List<Integer> left = level(root.left, level - 1);
            if (left != null) {
                ans = left;
            }
        }

        if (root.right != null) {
            List<Integer> right = level(root.left, level - 1);
            if (right != null) {
                if (ans == null) return right;
                else {
                    ans.addAll(right);
                }
            }
        }
        return ans;

    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        List<Integer> ans = new ArrayList<>();
        List<TreeNode> list = findAllTheNode(root, target);

        for (int index = 0; index < k; index++) {
            if (index == 0) {
                List<Integer> temp = level(list.get(index), k - index);
                if (temp != null) ans.addAll(temp);
            } else {

                TreeNode parent = list.get(index);
                TreeNode child = list.get(index - 1);
                if (parent.left.val == child.val) {
                    List<Integer> temp = level(parent.right, k - index);
                    if (temp != null) ans.addAll(temp);
                } else {
                    List<Integer> temp = level(parent.left, k - index);
                    if (temp != null) ans.addAll(temp);
                }

            }

        }

        return ans;
    }

}
