package Recursion.Hard;

import java.util.ArrayList;
import java.util.List;

public class palindromePartitioning {

    public static void main(String[] args) {
        System.out.println("Rahul Khichar");
        palindromePartitioning();
    }

    public static void palindromePartitioning() {
        String s = "aabb";

        List<List<String>> ans = makePartition(s, 0);


        for (List<String> temp : ans) {
            for (String st : temp) {
                System.out.print(st + ",");
            }
            System.out.println();
        }

    }


    public static boolean checkPalindrome(String s) {

        int left = 0;
        int right = s.length() - 1;

        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }

        return true;
    }

    public static List<List<String>> makePartition(String s, int startIndex) {
        List<List<String>> ans = new ArrayList<>();
        if (startIndex == s.length()) {
            List<String> tempList = new ArrayList<>();
            ans.add(tempList);
        }

        for (int i = startIndex; i < s.length(); i++) {
            String firstPartOfString = s.substring(startIndex, i + 1);
            if (checkPalindrome(firstPartOfString)) {
                List<List<String>> recursionAns = makePartition(s, i + 1);
                for (List<String> tempOneString : recursionAns) {
                    tempOneString.add(0, firstPartOfString);
                    ans.add(tempOneString);
                }
            }
        }

        return ans;
    }
}
