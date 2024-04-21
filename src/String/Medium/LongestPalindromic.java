package String.Medium;

public class LongestPalindromic {

    public static String LongestPalindromic(String str) {
        String ans = "";
        int n = str.length();

        for (int i = 0; i < n; i++) {
            int positive = i;
            int negative = i;
            while (positive < n && negative >= 0) {

                if (str.charAt(negative) != str.charAt(positive)) break;

                if (positive - negative + 1 > ans.length()) ans = str.substring(negative, positive + 1);
                positive++;
                negative--;
            }
            negative = i;
            positive = i + 1;
            while (positive < n && negative >= 0) {

                if (str.charAt(negative) != str.charAt(positive)) break;

                if (positive - negative + 1 > ans.length()) ans = str.substring(negative, positive + 1);
                positive++;
                negative--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        System.out.println(LongestPalindromic("cbbd"));
        System.out.println("Rahul Khichar");
    }
}
