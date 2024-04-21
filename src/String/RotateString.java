package String;

public class RotateString {


    public static boolean isSubstring(String s1, String s2) {

        if (s1.length() == 0) {
            return true;
        }
        if (s2.length() == 0) {
            return false;
        }

        if (s1.length() > s2.length()) {
            return false;
        }

        if (s1.charAt(0) == s2.charAt(0)) {
            return isSubstring(s1.substring(1), s2.substring(1)) | isSubstring(s1, s2.substring(1));
        } else {
            return isSubstring(s1, s2.substring(1));
        }

    }


    public static boolean isCommonPrefix(String s1, String s2) {

        if (s2.length() < s1.length()) return false;

        int index = 0;
        while (index < s1.length()) {
            if (s1.charAt(index) != s2.charAt(index)) return false;
            index++;
        }

        return true;
    }

    public static boolean rotateString(String s, String goal) {


        String s2 = s + s;

        for (int i = 0; i < s2.length(); i++) {
            if (isCommonPrefix(goal, s2.substring(i))) return true;
        }

        return false;
    }

    public static void main(String[] args) {

        System.out.println(rotateString("abcde", "abced"));
        System.out.println("Rahul Khichar");
    }
}
