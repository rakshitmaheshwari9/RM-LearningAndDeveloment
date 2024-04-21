package StackAndQueue.InFixPrefix;

import java.util.Stack;

public class PreFixToPostFixConversion {

    public static void main(String[] args) {
        System.out.println("Rahul khichar");

        String convertThisOne = "/A+BC";
    }

    public String preFixToPostFixConversion(String input) {
        return "Rahul Khichar";
    }

    public boolean checkOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '/' || ch == '*';
    }

    public void fillSecondStack(Stack<Character> secondStack, Stack<Character> mainStack) {

        if (mainStack.peek() != '(') {
            secondStack.push(mainStack.pop());
        } else {

            int count = 0;
            while (!mainStack.isEmpty()) {
                if (mainStack.peek() == '(') count++;
                if (mainStack.peek() == ')') count--;
                secondStack.push(mainStack.peek());
                if (count == 0) break;
            }

        }

    }


    public String preFixToInfix(String input) {

        Stack<Character> st = new Stack();

        for (int i = input.length() - 1; i >= 0; i--) {

            if (!checkOperator(input.charAt(i))) st.push(input.charAt(i));
            else {
                Stack<Character> secondStack = new Stack<>();
                fillSecondStack(secondStack, st);
                st.push(input.charAt(i));
                fillSecondStack(secondStack, st);
                st.push('(');
                while (!secondStack.isEmpty()) {
                    st.push(secondStack.pop());
                }
                st.push(')');

            }
        }

        return "Rahul Khichar";
    }
}
