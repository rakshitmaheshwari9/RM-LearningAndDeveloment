package Recursion.Hard;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioningPartFourth {

    public static void main(String[] args) {
        System.out.println("Rahul Khichar");


        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaxyaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
//        List<List<String>> ans = makePartition(str, 0);

        int[][] dp = new int[s.length() + 1][4];

        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j <= 3; j++) {
                dp[i][j] = -1;
            }
        }
        int n = s.length();
        int[][] palindrome = new int[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                palindrome[i][j] = -1;
            }
        }
        System.out.println(makePartitionSecondMathod(s, 0, 3, dp, palindrome));

//        for (List<String> temp : ans) {
//            for (String st : temp) {
//                System.out.print(st + ",");
//            }
//            System.out.println();
//        }
    }

    public static boolean isPalindrome(String str) {
        if (str.length() == 0 || str.length() == 1) return true;
        int left = 0;
        int right = str.length() - 1;

        while (left <= right) {
            if (str.charAt(left) != str.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    public static List<List<String>> makePartition(String str, int index) {
        List<List<String>> ans = new ArrayList<>();
        if (str.length() == index) {
            List<String> list = new ArrayList<>();
            ans.add(list);
        }

        for (int i = index; i < str.length(); i++) {
            String firstSubString = str.substring(index, i + 1);
            if (isPalindrome(firstSubString)) {
                List<List<String>> tempNewArrayList = makePartition(str, i + 1);
                for (List<String> tempSoul : tempNewArrayList) {
                    tempSoul.add(0, firstSubString);
                    ans.add(tempSoul);
                }
            }
        }

        return ans;
    }

    public static boolean makePartitionSecondMathod(String str, int index, int cut, int[][] dp, int[][] vis) {
        if (str.length() == index) {
            if (cut == 0) return true;
            return false;
        }

        if (cut == 0) return false;
        for (int i = index; i < str.length(); i++) {
            String firstSubString = str.substring(index, i + 1);

            if (vis[index][i] == -1) {

                boolean isPali = isPalindrome(firstSubString);
                if (isPali) vis[index][i] = 1;
                else vis[index][i] = 0;

            }

            if (vis[index][i] == 1) {

                if (dp[i + 1][cut - 1] == -1) {
                    boolean test = makePartitionSecondMathod(str, i + 1, cut - 1, dp, vis);
                    if (test) {
                        dp[i + 1][cut - 1] = 1;
                    } else {
                        dp[i + 1][cut - 1] = 0;
                    }
                }

                if (dp[i + 1][cut - 1] == 1) return true;


            }
        }

        return false;
    }
}
