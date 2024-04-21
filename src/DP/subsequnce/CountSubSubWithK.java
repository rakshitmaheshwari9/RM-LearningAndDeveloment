package DP.subsequnce;

public class CountSubSubWithK {

    public static void main(String[] args) {
        System.out.println("Rahul khichar");

        int input[] = {1, 4, 4, 5};
        findWays(input, 5);
    }

    public static int findWays(int num[], int tar) {


        int n = num.length;
        int dp[][] = new int[n + 1][tar + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= tar; j++) {

                if (i == 0 || j == 0) {
                    if (j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = 0;
                    }

                } else if (j >= num[i - 1]) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - num[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][tar];
    }
}
