package DP.String;

public class DeleteOperationforTwoStrings {

    public static void main(String[] args) {

    }

    public int minDistance(String word1, String word2) {

        int n = word1.length();
        int m = word2.length();

        int dp[][] = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                int notInclude = Math.max(dp[i - 1][j], dp[i][j - 1]);

                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {

                    dp[i][j] = Math.max(notInclude, 1 + dp[i - 1][j - 1]);
                } else {
                    dp[i][j] = notInclude;
                }
            }
        }


        return (n + m - 2 * dp[n][m]);

    }
}
