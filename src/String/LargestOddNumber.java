package String;

public class LargestOddNumber {

    public static String largestOddNumber(String str) {

        int lastIndex = str.length() - 1;

        while (lastIndex >= 0) {
            if (str.charAt(lastIndex) % 2 != 0) {
                return str.substring(0, lastIndex + 1);
            }
            lastIndex--;
        }
        return  "";

    }

    public static void main(String[] args) {
        System.out.println("Rahul Khichar3");
    }
}
