package DP.String;

public class WildCardMatching {


    public static void main(String[] args) {
        System.out.println("Rahul khichar");
        WildCardMatching wildCardMatching = new WildCardMatching();
        System.out.println(wildCardMatching.isMatch("cb", "?a"));
    }

    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        if (n == 0 && m == 0) return true;

        if (n == 0 || m == 0) return false;

        if (s.charAt(n - 1) == '*' || p.charAt(m - 1) == '*') {

            if (s.charAt(n - 1) == '*') {

                return isMatch(s.substring(0, n - 1), p.substring(0, m)) || isMatch(s.substring(0, n - 1), p.substring(0, m - 1));
            } else {
                return isMatch(s.substring(0, n), p.substring(0, m - 1)) || isMatch(s.substring(0, n - 1), p.substring(0, m - 1));
            }


        }

        if ((s.charAt(n - 1) == '?' || p.charAt(m - 1) == '?') || s.charAt(n - 1) == p.charAt(m - 1)) {
            return isMatch(s.substring(0, n - 1), p.substring(0, m - 1));
        }


        return false;

    }
}
