package String.Medium;

public class BeautySum {
    public static void main(String[] args) {
        System.out.println("Rahul khichar");

        System.out.println(beautySum("aabcbaa"));
    }


    public static int calculate(String str) {
        if (str.length() <= 2) return 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int[] map = new int[27];
        for (int i = 0; i < str.length(); i++) {
            map[str.charAt(i) - 'a']++;

        }
        for (int i = 0; i < 27; i++) {
            if (map[i] != 0) {
                max = Math.max(max, map[i]);
                min = Math.min(min, map[i]);
            }

        }
        return (max - min);
    }

    public static int allSubstring(String str) {
        if (str.length() <= 2)
            return 0;
        int ans = 0;
        int n = str.length();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                ans += calculate(str.substring(i, j));
            }
        }
        return ans;
    }

    public static int beautySum(String s) {
        return allSubstring(s);
    }
}
