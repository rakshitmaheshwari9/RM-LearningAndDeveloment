package DP.OneD;

public class FrogJump2 {
    public static void main(String[] args) {
        System.out.println("Rahul khichar");

        int n = 4, k = 2, height[] = {10, 40, 30, 10};
        System.out.println(minimizeCost(n, k, height));
    }


    public static int minimizeCost(int n, int k, int[] height) {

        int dp[] = new int[n];
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                int lastIndex = i - j;
                if (lastIndex >= 0) {
                    dp[i] = Math.min(dp[lastIndex] + Math.abs(height[lastIndex] - height[i]), dp[i]);
                }

            }
        }

        return dp[n - 1];
        // Write your code here.
    }
}
