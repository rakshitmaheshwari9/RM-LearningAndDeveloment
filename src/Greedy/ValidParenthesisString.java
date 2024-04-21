package Greedy;

public class ValidParenthesisString {

    public static void main(String[] args) {
        System.out.println("Rahul khichar");
        ValidParenthesisString validParenthesisString = new ValidParenthesisString();

        System.out.println(ValidParenthesisString("(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())"));

    }

    public static boolean ValidParenthesisString(String str) {

        int opening = 0;
        int star = 0;
        for (char ch : str.toCharArray()) {

            if (ch == '(') {
                opening++;
            } else if (ch == '*') star++;
            else {
                if (opening > 0 || star > 0) {
                    if (opening > 0) opening--;
                    else star--;
                } else return false;
            }

        }

        System.out.println(star);
        System.out.println(opening);
        if (star < opening) return false;

        return true;
    }
}
