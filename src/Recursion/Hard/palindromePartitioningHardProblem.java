package Recursion.Hard;

public class palindromePartitioningHardProblem {

    public static void main(String[] args) {
        System.out.println("Rahul Khichar");
        String s = "ab";
//        List<List<String>> ans = makePartition(s, 0);
//        int tempSolution = Integer.MAX_VALUE;
//        for (List<String> temp : ans) {
//            tempSolution = Math.min(tempSolution, temp.size());
//            System.out.println();
//            for (String tempString : temp) {
//
//                System.out.print(tempString + ",");
//            }
//            System.out.println("here we are ending list bro");
//        }

        int dp[] = new int[s.length() + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = -1;
        }
        System.out.println(makePartition(s, 0, dp));
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

    public static int makePartition(String str, int index, int[] dp) {
        if (index == str.length()) {
            dp[index] = 0;
            return 0;
        }
        int temp = (str.length() - index) + 1;
        for (int i = index; i < str.length(); i++) {
            String firstPartitionSubString = str.substring(index, i + 1);
            if (isPalindrome(firstPartitionSubString)) {
                if (dp[i + 1] == -1) {
                    dp[i + 1] = makePartition(str, i + 1, dp);
                }
                temp = Math.min(dp[i + 1], temp);
            }
        }
        return temp + 1;

    }


}
