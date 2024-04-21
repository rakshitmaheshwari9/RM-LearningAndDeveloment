package BinaryTree;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    int index = 0;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode buildTree(int[] inorder) {
        return buildTreeHelper(inorder, 0, inorder.length - 1);
    }

    public TreeNode buildTreePreOrder(int[] preorder) {
        return buildTreeHelperPreOrder(preorder, Integer.MAX_VALUE);
    }


    private TreeNode buildTreeHelperPreOrder(int[] preorder, int maxValue) {
        // If we reach the end of the array or encounter a value greater than the current maxValue, return null
        if (index >= preorder.length || preorder[index] > maxValue) {
            return null;
        }

        // Create a new TreeNode with the current value from preorder
        TreeNode root = new TreeNode(preorder[index++]);

        // Recursively build left subtree with values less than the current root value
        root.left = buildTreeHelperPreOrder(preorder, root.val);

        // Recursively build right subtree with values less than the current maxValue
        root.right = buildTreeHelperPreOrder(preorder, maxValue);

        return root;
    }


    private TreeNode buildTreeHelper(int[] inorder, int start, int end) {
        if (start > end) {
            return null;
        }

        // Find the index of the middle element of the current range
        int mid = start + (end - start) / 2;

        // If current element is -1, treat it as null
        if (inorder[mid] == -1) {
            return null;
        }

        // Create a new TreeNode with the middle element as the root
        TreeNode root = new TreeNode(inorder[mid]);

        // Recursively build left and right subtrees
        root.left = buildTreeHelper(inorder, start, mid - 1);
        root.right = buildTreeHelper(inorder, mid + 1, end);

        return root;
    }

    // Function to print the inorder traversal of the tree (for verification)
    public void inorderTraversal(TreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.val + " ");
            inorderTraversal(root.right);
        }
    }
}
