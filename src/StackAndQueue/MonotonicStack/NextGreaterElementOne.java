package StackAndQueue.MonotonicStack;

import java.util.Stack;

public class NextGreaterElementOne {

    public static void main(String[] args) {
        System.out.println("Rahul Khichar");

        int[] arr = {1, 3, 4, 2};

//        solution(arr);

    }


    public static void solution(int[] nums1, int[] nums2) {

        int nextGreaterElement[] = new int[10000];
        int ans[] = new int[nums1.length];
        Stack<Integer> st = new Stack<>();

        for (int i = nums2.length - 1; i >= 0; i--) {

            while (!st.isEmpty() && nums2[i] > st.peek()) {
                st.pop();
            }

            if (st.isEmpty()) {
                nextGreaterElement[nums2[i]] = -1;
            } else {
                nextGreaterElement[nums2[i]] = st.peek();
            }
            st.push(nums2[i]);
        }


        for (int i = 0; i < nums1.length; i++) {
            ans[i] = nextGreaterElement[nums1[i]];
        }
//        for (int i : nums1) {
//            ans[]
//            System.out.print(element + " ,");
//        }
    }
}
