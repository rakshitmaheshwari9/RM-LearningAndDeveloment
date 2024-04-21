package DP.String;

public class DistinctSubsequences {

    public static void main(String[] args) {
        System.out.println("Rahul khichar");

        DistinctSubsequences distinctSubsequences = new DistinctSubsequences();
        System.out.println(distinctSubsequences.numDistinct("rabbbit", "rabbit"));
    }

    public int numDistinct(String s, String t) {

        int n = s.length();
        int m = t.length();

        int dp[][] = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                int notInclude = Math.max(dp[i - 1][j], dp[i][j - 1]);
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    int include = dp[i - 1][j] + dp[i][j - 1];
                    dp[i][j] = Math.max(include, notInclude);
                } else {

                    dp[i][j] = notInclude;
                }
            }
        }

        for (int i = 0; i <= n; i++) {

            for (int j = 0; j <= m; j++) {
                System.out.print(dp[i][j] + ",");
            }
            System.out.println();
        }


        return 10;
    }
}
