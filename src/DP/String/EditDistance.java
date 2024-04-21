package DP.String;

public class EditDistance {

    public static void main(String[] args) {
        System.out.println("Rahul khichar");

        String str1 = "intention";
        String str2 = "execution";

        EditDistance editDistance = new EditDistance();
        System.out.println(editDistance.dp(str1, str2));
    }

    public int minDistance(String word1, String word2) {

        int n = word1.length();
        int m = word2.length();


        if (n == 0 || m == 0) {
            if (n == 0) return m;
            return n;
        }

        int removeBothTheChar = minDistance(word1.substring(0, n - 1), word2.substring(0, m - 1));

        if (word1.charAt(n - 1) == word2.charAt(m - 1))
            return removeBothTheChar;


        int firstCase = minDistance(word1.substring(0, n - 1), word2);
        int secondCase = minDistance(word1, word2.substring(0, m - 1));


        return Math.min(removeBothTheChar, Math.min(firstCase, secondCase)) + 1;


    }

    public int dp(String word1, String word2) {

        int n = word1.length();
        int m = word2.length();

        int dp[][] = new int[n + 1][m + 1];


        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else {
                    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]))+1;
                    }
                }
            }
        }


        return dp[n][m];

    }
}
