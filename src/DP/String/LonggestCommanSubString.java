package DP.String;

public class LonggestCommanSubString {
    public static int ans = 0;

    public static void main(String[] args) {
        System.out.println("Rahul khichar");
        String str1 = "abcjklp";
        String str2 = "acjkp";

//
        lcsRecursoin(str1, str2);
        System.out.println(ans);

    }

    public static int lcs(String str1, String str2) {

//        int n = str1.length();
//        int m = str2.length();
//        int dp[][] = new int[n + 1][m + 1];
//
//
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= m; j++) {
//
//                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
//
//
//                }
//
//            }
//        }
//
//
//        return 10;

        return lcsRecursoin(str1, str2);
    }

    public static int lcsRecursoin(String str1, String str2) {
        if (str1.length() == 0 || str2.length() == 0) return 0;


        if (str1.charAt(0) == str2.charAt(0)) {

            int tempAns = lcsRecursoin(str1.substring(1), str2.substring(1)) + 1;
            ans = Math.max(ans, tempAns);
            return tempAns;

        } else {
            lcsRecursoin(str1, str2.substring(1));
            lcsRecursoin(str1.substring(1), str2);
            return 0;
        }


    }

    public static int dp(String str1, String str2) {

        int n = str1.length();
        int m = str2.length();
        int ans = 0;
        int dp[][] = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    ans = Math.max(ans, dp[i][j]);
                }
            }

        }

        return ans;


    }
}
