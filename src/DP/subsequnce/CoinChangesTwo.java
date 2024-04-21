package DP.subsequnce;

public class CoinChangesTwo {
    public static void main(String[] args) {
        System.out.println("Rahul khichar");
        int[] coins = {1, 2, 5};
        int amount = 5;

        CoinChangesTwo coinChangesTwo = new CoinChangesTwo();
        System.out.println(coinChangesTwo.change(amount, coins));
    }

    public int change(int amount, int[] coins) {

        return dpProblem(amount, coins);
    }

    private int recursion(int amount, int[] coins, int index) {
        if (index == coins.length) return 0;
        if (amount == 0) return 1;
        if (amount < 0) return 0;
        int include = recursion(amount - coins[index], coins, index);
        int notInclude = recursion(amount, coins, index + 1);
        return include + notInclude;
    }

    private int dpProblem(int amount, int[] coins) {
        int n = coins.length;
        int dp[][] = new int[n + 1][amount + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {

                if (j >= coins[i - 1]) {

                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];

                } else {
                    dp[i][j] = dp[i - 1][j];

                }
            }
        }


        return dp[n][amount];
    }
}
