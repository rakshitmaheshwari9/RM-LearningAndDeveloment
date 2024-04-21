package String;

import java.util.Stack;

public class ReverseWords {

    public static String trimString(String str) {
        int firstIndex = 0;
        int lastIndex = str.length() - 1;

        while (firstIndex < str.length()) {
            if (str.charAt(firstIndex) != ' ') break;

            firstIndex++;
        }

        while (lastIndex >= 0) {
            if (str.charAt(lastIndex) != ' ') break;
            lastIndex--;
        }

        return str.substring(firstIndex, lastIndex + 1);
    }

    public static String reverseWords(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        int lastIndex = 0;

        Stack<String> st = new Stack<>();


        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) == ' ') {
                st.push(str.substring(lastIndex, i));
                lastIndex = i + 1;
            }
        }
        st.push(str.substring(lastIndex));
        while (!st.isEmpty()) {
            String tempString = st.pop();
            if (tempString.length() > 0) {
                if (st.isEmpty()) {
                    stringBuilder.append(trimString(tempString));
                } else {
                    stringBuilder.append(trimString(tempString) + " ");
                }
            }
        }
        return trimString(stringBuilder.toString());
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("example   good a"));
    }
}
