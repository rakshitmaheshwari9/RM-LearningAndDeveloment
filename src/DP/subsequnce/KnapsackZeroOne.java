package DP.subsequnce;

public class KnapsackZeroOne {

    public static void main(String[] args) {
        System.out.println("Rahul khichar");


        int n = 4;
        int[] weights = {1, 2, 4, 5};
        int[] values = {5, 4, 8, 6};
        int maxWeight = 5;


        System.out.println(knapsack(weights, values, n, maxWeight));
    }

    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {


        int dp[][] = new int[n + 1][maxWeight + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= maxWeight; j++) {
                if (j >= weight[i - 1]) {
                    dp[i][j] = Math.max(dp[i - 1][j], value[i - 1] + dp[i - 1][j - weight[i - 1]]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][maxWeight];


    }


    static int knapsack2(int[] weight, int[] value, int n, int maxWeight, int index) {
        if (index == n) return 0;


        if (maxWeight >= weight[index]) {

            int include = knapsack2(weight, value, n, maxWeight - weight[index], index + 1) + value[index];
            int notInclude = knapsack2(weight, value, n, maxWeight, index + 1);

            return Math.max(include, notInclude);
        }

        return knapsack2(weight, value, n, maxWeight, index + 1);


    }
}
