package Recursion.Hard;

import java.util.List;

public class WordSegmentation {

    public static void main(String[] args) {
        System.out.println("Rahul Khichar");

        WordSegmentation wordSegmentation = new WordSegmentation();
        String string = "leetcode";
        List<String> words = List.of("leet", "code");
        System.out.println(wordSegmentation.wordBreak2(string, words));

    }


    public static boolean wordBreak2(String st, List<String> wordDirt) {
        int n = st.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {

                if (dp[j] && wordDirt.contains(st.substring(j, i))) {
                    dp[i] = true;
                    break;

                }

            }

        }
//        for (boolean it : dp) {
//            System.out.print(it + " ");
//        }
        return dp[n];

    }


    public boolean wordBreak(String s, List<String> wordDict) {
        if (s.length() == 0) return true;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (wordDict.contains(s.substring(0, i + 1)) && wordBreak(s.substring(i + 1), wordDict)) return true;
        }
        return false;

    }
}
