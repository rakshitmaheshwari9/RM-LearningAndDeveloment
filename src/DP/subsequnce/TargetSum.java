package DP.subsequnce;

public class TargetSum {
    public static void main(String args) {
        System.out.println("Rahul khichar");
    }

    public int findTargetSumWays(int[] nums, int target) {

        int totalSum = 0;
        for (int number : nums) {
            totalSum += number;
        }

        int TwoTime = (totalSum + target);
        if (TwoTime % 2 != 0) return 0;

        int s1 = TwoTime / 2;
        int n = nums.length;

        int dp[][] = new int[n + 1][s1 + 1];


        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= s1; j++) {

                if (j >= nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }


        return dp[n][s1];

    }
}
