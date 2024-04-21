package BinaryTree.Hard;

public class UniqueBinaryTree {

    public static void main(String[] args) {
        System.out.println("Rahul khichar");
    }

    public static boolean uniqueBinaryTree(int a, int b) {

        if (a == 2) {
            if (b == 2) return false;
            return true;
        }

        if (b == 2) {
            if (a == 2) return false;
            return true;
        }

        return false;
    }
}
