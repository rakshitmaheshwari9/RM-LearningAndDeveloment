package String;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        System.out.println("Rahul khichar");

        String[] temp = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(temp));
    }

    public static String longestCommonPrefix(String[] str) {


        String ansTemp = str[0];

        for (int i = 1; i < str.length; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            String secondString = str[i];
            int firstIndex = 0;
            int secondIndex = 0;
            while (firstIndex < ansTemp.length() & secondIndex < secondString.length()) {
                if (ansTemp.charAt(firstIndex) != secondString.charAt(secondIndex)) {
                    break;
                }
                firstIndex++;
                secondIndex++;
            }

            ansTemp = ansTemp.substring(0, firstIndex);


        }

        return ansTemp;
    }
}
