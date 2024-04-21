package DP.subsequnce;

public class PartitionWithGivenSum {
    public static void main(String[] args) {
        System.out.println("Rahul khichar");
    }


    public static int countPartitions(int n, int d, int[] arr) {
        // Write your code here.

        int totalSum = 0;
        for (int number : arr) {
            totalSum += number;
        }

        int df = (totalSum + d) / 2;

        int[][] dp = new int[n + 1][df + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= df; j++) {

                if (i == 0 || j == 0) {
                    if (j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = 0;
                    }

                } else if (j >= arr[i - 1]) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - arr[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][df];

    }
}
