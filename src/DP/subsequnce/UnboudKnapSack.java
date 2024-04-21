package DP.subsequnce;

public class UnboudKnapSack {

    public static void main(String[] args) {
        System.out.println("Rahul khichar");

        int n = 3, w = 10;
        int[] profit = {5, 11, 13};
        int[] weight = {2, 4, 6};
        System.out.println(unboundedKnapsack(n, w, profit, weight));

    }

    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {


        int dp[][] = new int[n + 1][w + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= w; j++) {
                if (j >= weight[i - 1]) {
                    int include = dp[i][j - weight[i - 1]] + profit[i - 1];
                    int notInclude = dp[i - 1][j];
                    dp[i][j] = Math.max(include, notInclude);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][w];
    }

    public static int recursion(int n, int w, int[] profit, int[] weight, int index) {

        if (index == n) return 0;
        if (w < 0) return 0;


        if (w - weight[index] >= 0) {
            int include = recursion(n, w - weight[index], profit, weight, index) + profit[index];
            int notInlcude = recursion(n, w, profit, weight, index + 1);

            return Math.max(notInlcude, include);
        }
        int notInlcude = recursion(n, w, profit, weight, index + 1);

        return notInlcude;

    }
}
