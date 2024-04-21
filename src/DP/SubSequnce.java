package DP;

public class SubSequnce {

    public static void main(String[] args) {
        System.out.println("rahul khichar");
        int n = 5;
        int k = 4;
        int arr[] = {2, 5, 1, 6, 7};
//        5 4
//        2 5 1 6 7

        SubSequnce subSequnce = new SubSequnce();
        System.out.println(subsetSumToK(n, k, arr));
    }

    public static boolean subsetSumToK(int n, int k, int arr[]) {

        boolean[][] dp = new boolean[n + 1][k + 1];

        for (int i = 0; i <= k; i++) {
            dp[0][i] = false;
        }
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                if (j >= arr[i - 1]) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }

            }
        }

        return dp[n][k];


//        return isSum(0, arr, k);
    }

    public static boolean isSum(int index, int arr[], int sum) {
        if (sum == 0) return true;
        if (index >= arr.length) return false;

        if (sum < 0) return false;

        return isSum(index + 1, arr, sum - arr[index]) || isSum(index + 1, arr, sum);

    }
}
