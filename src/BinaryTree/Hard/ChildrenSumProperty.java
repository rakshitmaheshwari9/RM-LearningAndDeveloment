package BinaryTree.Hard;

public class ChildrenSumProperty {

    private static boolean isEqual = true;

    public static void main(String[] args) {

        System.out.println("Rahul khichar");
    }

    public static int sumTillStarting(Node root) {
        if (root == null) return 0;

        if (root.left == null && root.right == null) return root.data;

        int left = sumTillStarting(root.left);
        int right = sumTillStarting(root.right);

        if (root.data != left + right) {
            isEqual = false;
            return root.data + left + right;
        }
        return 2 * root.data;
    }

    public static boolean isParentSum(Node root) {
        sumTillStarting(root);
        return isEqual;
    }


    class Node {
        public int data;
        public Node left;
        public Node right;

        Node() {
            this.data = 0;
            this.left = null;
            this.right = null;
        }

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

}
