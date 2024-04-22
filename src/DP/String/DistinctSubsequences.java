package DP.String;

public class DistinctSubsequences {

    public static void main(String[] args) {
        System.out.println("Rahul khichar");

        DistinctSubsequences distinctSubsequences = new DistinctSubsequences();
        System.out.println(distinctSubsequences.numDistinct("rabbbit", "rabbit"));
        System.out.println(distinctSubsequences.dp("rabbbit", "rabbit"));
    }

    public int numDistinct(String s, String t) {
        if (t.length() == 0) return 1;
        if (s.length() == 0) return 0;
        int n = s.length();
        int m = t.length();

        if (s.charAt(n - 1) == t.charAt(m - 1)) {

            int include = numDistinct(s.substring(0, n - 1), t.substring(0, m - 1));

            int notInclude = numDistinct(s.substring(0, n - 1), t);

            return include + notInclude;

        } else {
            return numDistinct(s.substring(0, n - 1), t);
        }
    }


    public int dp(String s, String t) {
        if (t.length() == 0) return 1;
        if (s.length() == 0) return 0;
        int n = s.length();
        int m = t.length();

        int dp[][] = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {

            for (int j = 0; j <= m; j++) {
                if (j == 0) {
                    dp[i][j] = 1;
                } else if (i == 0) {
                    dp[i][j] = 0;
                } else {

                    if (s.charAt(i - 1) == t.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }

            }
        }

        return dp[n][m];
    }


}
