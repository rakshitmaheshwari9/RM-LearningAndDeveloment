package StackAndQueue.MonotonicStack;

import java.util.Stack;

public class MaximalRectangle {

    public static void main(String[] args) {
        System.out.println("Rahul khichar");
        String[][] matrix = {{"1", "0", "1", "0", "0"}, {"1", "0", "1", "1", "1"}, {"1", "1", "1", "1", "1"}, {"1", "0", "0", "1", "0"}};

        firstSolution(matrix);
    }

    public static void firstSolution(String[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;

        int[] arr = new int[m];

        int ans = 0;


        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {

                if (matrix[i][j] == "1") {
                    arr[j] += 1;
                } else {
                    arr[j] = 0;
                }
            }

            int leftMin[] = new int[m];
            int rightMin[] = new int[m];

            Stack<Integer> stack = new Stack();

            for (int j = 0; j < m; j++) {

                while (!stack.isEmpty() && arr[j] <= arr[stack.peek()]) {
                    stack.pop();
                }

                if (stack.isEmpty()) {
                    leftMin[j] = -1;
                } else {
                    leftMin[j] = stack.peek();
                }
                stack.push(j);
            }

            stack.clear();

            for (int j = m - 1; j >= 0; j--) {

                while (!stack.isEmpty() && arr[j] <= arr[stack.peek()]) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    rightMin[j] = m;
                } else {
                    rightMin[j] = stack.peek();
                }
                stack.push(j);
            }


            for (int j = 0; j < m; j++) {
                ans = Math.max(ans, arr[j] * (rightMin[j] - leftMin[j] - 1));
            }

        }

        System.out.println(ans);

    }
}
