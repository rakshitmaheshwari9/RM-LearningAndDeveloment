package DP.OneD;

public class HouseRobber {

    public static void main(String[] args) {
        System.out.println("Rahul khichar");

        HouseRobber houseRobber = new HouseRobber();

        int[] input = {1, 2, 3, 1};
        System.out.println(houseRobber.rob(input));
    }

    public int rob(int[] nums) {

        int n = nums.length;

        if (n == 0) return 0;
        if (n == 1) return nums[0];

        int dp[] = new int[n];
        dp[0] = nums[0];
        dp[1] = nums[1];
        int ans = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            for (int k = 2; k < n; k++) {
                int lastIndex = i - k;
                if (lastIndex >= 0) {
                    dp[i] = Math.max(dp[lastIndex] + nums[i], dp[i]);
                    ans = Math.max(ans, dp[i]);
                }
            }
        }

        return ans;

    }

}
