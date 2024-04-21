package StackAndQueue.InFixPrefix;

import java.util.Stack;

public class preFixTInfix {

    public static void main(String[] args) {

        String str = "/-ab+-cde";
        preFixToInFix(str);
    }

    public static boolean isOperator(char ch) {

        if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
            return true;
        }

        return false;
    }

    public static void fillSecondStack(Stack<Character> st, Stack<Character> operationStack) {
        if (st.isEmpty()) return;
        if (st.peek() != '(') {
            operationStack.push(st.pop());
            return;
        }
        int count = 0;

        while (!st.isEmpty()) {
            if (st.peek() == '(') count++;
            if (st.peek() == ')') count--;
            operationStack.push(st.pop());
            if (count == 0) {
                break;
            }

        }
    }

    public static String preFixToInFix(String str) {
        Stack<Character> st = new Stack<>();
        for (int i = str.length()-1; i >= 0; i--) {
            char ch = str.charAt(i);
            if (!isOperator(ch)) {
                st.push((ch));
            } else {
                Stack<Character> operationStack = new Stack<>();
                fillSecondStack(st, operationStack);
                operationStack.push(ch);
                fillSecondStack(st, operationStack);

                st.push(')');
                while (!operationStack.isEmpty()) {
                    st.push(operationStack.pop());
                }
                st.push('(');

            }

        }

        while (!st.isEmpty()) {
            System.out.print(st.pop());
        }

        return str;
    }
}
