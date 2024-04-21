package DP.subsequnce;

public class RodCuttingProblem {

    public static void main(String[] args) {
        System.out.println("Rahul khichar");
    }


    public static int cutRod(int price[], int n) {


        int dp[][] = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {

            }
        }

        // Write your code here.

        return 10;
    }


    public static int recursion(int price[], int n, int index) {
        if (n == 0) return 0;
        if(index>=price.length) return 0;


//        int include=recursion(price)


        int dp[][] = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {

            }
        }

        // Write your code here.

        return 10;
    }


//    public static int recursion(int price[], int n, int index, int sum) {
//
//        if (sum > n) return 0;
//        if(index)
//        // Write your code here.
//
//        return 10;
//    }
}
