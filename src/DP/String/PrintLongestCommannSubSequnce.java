package DP.String;


import java.util.Stack;

public class PrintLongestCommannSubSequnce {
    public static void main(String[] args) {
        System.out.println("Rahul khichar");

        String str1 = "abcde";
        String str2 = "ace";

        PrintLongestCommannSubSequnce printLongestCommannSubSequnce = new PrintLongestCommannSubSequnce();
        System.out.println(printLongestCommannSubSequnce.dp(str1, str2));
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

        int lastRowIndex = n;
        int lastColumnIndex = m;
        Stack<Character> st = new Stack<>();
        while (lastRowIndex > 0 && lastColumnIndex > 0) {


            if (dp[lastRowIndex][lastColumnIndex] == dp[lastRowIndex - 1][lastColumnIndex - 1] + 1  && dp[lastRowIndex-1][lastColumnIndex] == dp[lastRowIndex ][lastColumnIndex-1]) {
                st.push(text1.charAt(lastRowIndex - 1));
                lastRowIndex--;
                lastColumnIndex--;
            } else if (dp[lastRowIndex][lastColumnIndex] == dp[lastRowIndex - 1][lastColumnIndex]) {
                lastRowIndex--;
            } else {
                lastColumnIndex--;

            }
        }

        String str = "";
        while (!st.isEmpty()) {
            str += st.pop();
        }

        System.out.println(str);
        return dp[n][m];

    }
}
