package StackAndQueue.InFixPrefix;

import java.util.Stack;

public class InfixToPreFix {

    public static void main(String[] args) {
        System.out.println("Rahul Khichar");
        InfixToPreFix infixToPreFix = new InfixToPreFix();

        System.out.println(infixToPreFix.infixToPreFix("(p+q)*(m-n)"));
    }


    public int prec(Character ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;

        }
    }

    public String infixToPreFix(String str) {

        Stack<Character> st = new Stack();
        String ans = "";

        for (int i = 0; i < str.length(); i++) {
            Character ch = str.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                ans += ch;
            } else if (ch == '(') {
                st.push(ch);
            } else if (ch == ')') {

                while (st.peek() != '(') {
                    ans += st.pop();
                }
                st.pop();

            } else {

                while (!st.isEmpty() && prec(ch) <= prec(st.peek())) {
                    ans += st.pop();
                }
                st.push(ch);

            }
        }

        while (!st.isEmpty()) {
            ans += st.pop();
        }

        return ans;
    }
}
