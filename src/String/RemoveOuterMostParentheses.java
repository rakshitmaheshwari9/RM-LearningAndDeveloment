package String;

public class RemoveOuterMostParentheses {

    public static void main(String[] args) {
        System.out.println("Rahul khichar");
        System.out.println(removeOuterMostParentheses("(()())(())"));
    }

    public static String removeOuterMostParentheses(String str) {


        int firstIndex = -1;
        int count = 0;

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                count++;
            } else {
                count--;

                if (count == 0) {
                    ans.append(str.substring(firstIndex + 2, i));
                    firstIndex = i;
                }
            }
        }
        return ans.toString();
    }
}
