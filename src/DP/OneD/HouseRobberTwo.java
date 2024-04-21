package DP.OneD;

public class HouseRobberTwo {

    public static void main(String[] args) {
        System.out.println("Rahul khichar");
    }

    public int findRob(int[] nums) {
        int n = nums.length;

        int dp[] = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[n - 1];
    }

    public int rob(int[] nums) {
        int n = nums.length;


        int firstInclude[] = new int[n - 1];
        int secondInclude[] = new int[n - 1];

        for (int i = 0; i < n; i++) {

            if (i < n - 1) {
                firstInclude[i] = nums[i];
            }
            if (i >= 1) {
                secondInclude[i - 1] = nums[i];
            }
        }

        return Math.max(findRob(firstInclude), findRob(secondInclude));
    }
}
