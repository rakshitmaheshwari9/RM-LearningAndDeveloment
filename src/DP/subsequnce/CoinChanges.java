package DP.subsequnce;

public class CoinChanges {

    public static void main(String[] args) {

        int coins[] = {1, 2, 5};
        int amount = 11;

        CoinChanges coinChanges = new CoinChanges();

        System.out.println(coinChanges.coinChange(coins, amount));


    }

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;


        return dp(coins, amount);

//        return recursion(coins, amount, 0, n);
    }

    public int recursion(int[] coins, int amount, int index, int n) {
        if (amount == 0) return 0;
        if (amount < 0 || index == n) return Integer.MAX_VALUE;

        if (amount - coins[index] < 0) {
            return recursion(coins, amount, index + 1, n);
        }

        int include = recursion(coins, amount - coins[index], index, n);
        int notInclude = recursion(coins, amount, index + 1, n);

        // If both include and notInclude are unreachable, return Integer.MAX_VALUE
        if (include == Integer.MAX_VALUE && notInclude == Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }

        // If either include or notInclude is unreachable, return the other
        if (include == Integer.MAX_VALUE) return notInclude;
        if (notInclude == Integer.MAX_VALUE) return include + 1;

        return Math.min(include + 1, notInclude);

    }

    public int dp(int[] coins, int amount) {

        int n = coins.length;

        int dp[][] = new int[n + 1][amount + 1];

        for (int i = 1; i <= amount; i++) {
            dp[0][i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {

                if (j >= coins[i - 1]) {
                    if (dp[i][j - coins[i - 1]] == Integer.MAX_VALUE) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coins[i - 1]] + 1);
                    }
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }


        if (dp[n][amount] == Integer.MAX_VALUE) return -1;


        return dp[n][amount];
    }


}
