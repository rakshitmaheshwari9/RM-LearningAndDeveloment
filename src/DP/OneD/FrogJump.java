package DP.OneD;

public class FrogJump {

    public static void main(String[] args) {
        System.out.println("Rahul khichar");
    }


    public static int frogJump(int n, int heights[]) {

        int dp[] = new int[n];

        dp[0] = 0;

        dp[1] = Math.abs(heights[1] - heights[0]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.min(dp[i - 2] + Math.abs(heights[i] - heights[i - 2]), dp[i - 1] + Math.abs(heights[i] - heights[i - 1]));
        }


        return dp[n - 1];
    }
}
