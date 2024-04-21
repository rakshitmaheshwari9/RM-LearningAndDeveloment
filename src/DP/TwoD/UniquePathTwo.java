package DP.TwoD;

public class UniquePathTwo {
    public static void main(String[] args) {
        System.out.println("Rahul khichar");
        int[][] input = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        UniquePathTwo uniquePathTwo = new UniquePathTwo();
        System.out.println(uniquePathTwo.uniquePathsWithObstacles(input));
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) return 0;

        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                } else if (i == 0) {
                    dp[i][j] = dp[i][j - 1];
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }


        return dp[n - 1][m - 1];
    }
}
