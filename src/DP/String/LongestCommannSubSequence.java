package DP.String;

public class LongestCommannSubSequence {

    public static void main(String[] args) {
        System.out.println("Rahul khichar");

        String str1 = "abcde";
        String str2 = "ace";


        LongestCommannSubSequence longestCommannSubSequence = new LongestCommannSubSequence();

        System.out.println(longestCommannSubSequence.dp(str1, str2));
    }

    public int longestCommonSubsequence(String text1, String text2) {
        if (text1.length() == 0 || text2.length() == 0) return 0;


        int notInclude = Math.max(longestCommonSubsequence(text1.substring(0), text2.substring(1)), longestCommonSubsequence(text1.substring(1), text2.substring(0)));
        if (text1.charAt(0) == text2.charAt(0)) {
            int include = longestCommonSubsequence(text1.substring(1), text2.substring(1));

            return Math.max(include + 1, notInclude);
        }

        return notInclude;

    }


    public int dp(String text1, String text2) {


        int n = text1.length();
        int m = text2.length();
        int dp[][] = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                int notInclude = Math.max(dp[i - 1][j], dp[i][j - 1]);
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = Math.max(notInclude, dp[i - 1][j - 1] + 1);
                } else {
                    dp[i][j] = notInclude;
                }
            }
        }

        return dp[n][m];

    }


}
