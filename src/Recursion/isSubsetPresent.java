package Recursion;

public class isSubsetPresent {

    public static void main(String[] args) {
        System.out.println("Rahul Khichar");
        int a[]={1,2,3};

        System.out.println(isSubsetPresent(4,13,a));
    }

    public static boolean isSubArry(int[] a, int index, int currSum, int targetSum) {

        if (index == a.length) {
            if (currSum == targetSum) return true;
            return false;
        }

        return isSubArry(a, index + 1, currSum + a[index], targetSum) || isSubArry(a, index + 1, currSum, targetSum);


    }

    public static boolean isSubsetPresent(int n, int k, int[] a) {

        return isSubArry(a, 0, 0, k);
        // Write your code here
    }
}
