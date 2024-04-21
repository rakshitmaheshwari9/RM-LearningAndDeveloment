package DP.String;

import java.util.Stack;

public class ShortestCommandSuperSequnce {

    public static void main(String[] args) {
        System.out.println("Rahul khichar");

        ShortestCommandSuperSequnce shortestCommandSuperSequnce = new ShortestCommandSuperSequnce();
        System.out.println(shortestCommandSuperSequnce.shortestCommonSupersequence("adbcbccdcadcbcbcbbdccbddcdccababccbccbddbbbcabdbdacdbccccbabacaa", "dcbaddabcaadabacbbbddccbbccdbadbdaccdccbbbdbddcbacbdbcdcaddbdadabcbaacbaaaaadbcba"));
    }

    public String shortestCommonSupersequence(String str1, String str2) {


        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                int notInclude = Math.max(dp[i - 1][j], dp[i][j - 1]);

                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    int include = dp[i - 1][j - 1] + 1;
                    dp[i][j] = Math.max(include, notInclude);
                } else {
                    dp[i][j] = notInclude;
                }
            }
        }


        int lastRowIndex = n;
        int lastColumnIndex = m;
        Stack<Character> st = new Stack<>();
        while (lastRowIndex > 0 && lastColumnIndex > 0) {

            if (str1.charAt(lastRowIndex - 1) == str2.charAt(lastColumnIndex - 1)) {
                st.push(str1.charAt(lastRowIndex - 1));
                lastRowIndex--;
                lastColumnIndex--;
            } else if (dp[lastRowIndex - 1][lastColumnIndex] > dp[lastRowIndex][lastColumnIndex - 1]) {
                lastRowIndex--;
            } else {
                lastColumnIndex--;
            }
        }


        String str = "";
        while (!st.isEmpty()) {
            str += st.pop();
        }
        int firstStringIndex = 0;
        int secondStringIndex = 0;
        int commanStringIndex = 0;


        String resultString = "";

        while (commanStringIndex < str.length()) {
            char commanChar = str.charAt(commanStringIndex);

            while (firstStringIndex < str1.length() && commanChar != str1.charAt(firstStringIndex)) {
                resultString += str1.charAt(firstStringIndex);
                firstStringIndex++;

            }

            while (secondStringIndex < str2.length() && commanChar != str2.charAt(secondStringIndex)) {
                resultString += str2.charAt(secondStringIndex);
                secondStringIndex++;
            }

            firstStringIndex++;
            secondStringIndex++;
            resultString += str.charAt(commanStringIndex);
            commanStringIndex++;

        }

        while (firstStringIndex < str1.length()) {
            resultString += str1.charAt(firstStringIndex);
            firstStringIndex++;
        }
        while (secondStringIndex < str2.length()) {
            resultString += str2.charAt(secondStringIndex);
            secondStringIndex++;
        }


        return resultString;


    }
}
