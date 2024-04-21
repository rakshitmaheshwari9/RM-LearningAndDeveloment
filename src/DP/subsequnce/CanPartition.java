package DP.subsequnce;

public class CanPartition {

    public static void main(String[] args) {
        System.out.println("rahul khichar");
    }


    public boolean isSumPossible(int[] nums, int sum) {

        int n = nums.length;

        boolean dp[][] = new boolean[n + 1][sum + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {

                if (i == 0 || j == 0) {
                    if (i == 0) {
                        dp[i][j] = false;
                    }
                    if (j == 0) {
                        dp[i][j] = true;
                    }

                } else {

                    if (j >= nums[i - 1]) {
                        dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
        }

        return dp[n][sum];

    }

    public boolean canPartition(int[] nums) {

        int sum = 0;

        for (int number : nums) {
            sum += number;
        }

        if (sum % 2 != 0) return false;

        return isSumPossible(nums, sum / 2);

    }
}
