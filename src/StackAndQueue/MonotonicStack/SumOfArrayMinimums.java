package StackAndQueue.MonotonicStack;

import java.util.Stack;


public class SumOfArrayMinimums {

    public static void main(String[] args) {
        System.out.println("Rahul Khichar");

        int arr[] = {71, 55, 82, 55};
        System.out.println(secondMethod(arr));
    }


    public static int firstMethod(int[] input) {


//        for (int index : input) {
//            System.out.print(index);
//        }
        int n = input.length;
        int ans = 0;


        for (int i = 0; i < n; i++) {
            int minElement = input[i];
            for (int j = i; j < n; j++) {
                minElement = Math.min(minElement, input[j]);
                ans = (ans + minElement) % (int) (Math.pow(10, 9) + 7);

            }
        }


        return ans;
    }


    public static int secondMethod(int[] input) {

        Stack<Integer> st = new Stack();
        int[] leftMin = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            while (!st.isEmpty() && input[st.peek()] > input[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                leftMin[i] = -1;
            } else {
                leftMin[i] = st.peek();
            }
            st.push(i);
        }

        st.clear();

        int rightMin[] = new int[input.length];
        for (int i = input.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && input[st.peek()] > input[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                rightMin[i] = input.length;
            } else {
                rightMin[i] = st.peek();
            }
            st.push(i);
        }


        int count = 0;
        int module= (int) (Math.pow(10,9)+7);

        for (int i = 0; i < input.length; i++) {
            count = (count+(input[i] * (rightMin[i] - i) * (i - leftMin[i])%module))%module;
        }


        return count;
    }
}
