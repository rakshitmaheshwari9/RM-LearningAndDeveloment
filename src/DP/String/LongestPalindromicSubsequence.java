package DP.String;

public class LongestPalindromicSubsequence {
    public static void main(String[] args) {
        System.out.println("Rahul khichar");
        LongestPalindromicSubsequence longestCommannSubSequence = new LongestPalindromicSubsequence();
        System.out.println(longestCommannSubSequence.longestPalindromeSubseq("bbbab"));
    }


    public int longestPalindromeSubseq(String s) {

        String str2 = "";

        for (int i = s.length() - 1; i >= 0; i--) {
            str2 += s.charAt(i);
        }
        int n = s.length();
        int dp[][] = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {

                int notInclude = Math.max(dp[i - 1][j], dp[i][j - 1]);

                if (s.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = Math.max(1 + dp[i - 1][j - 1], notInclude);
                } else {
                    dp[i][j] = notInclude;
                }
            }
        }


        return dp[n][n];

    }
}
