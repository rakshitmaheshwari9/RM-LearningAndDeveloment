package StackAndQueue.MonotonicStack;

import java.util.Stack;

public class NextGreaterElementTwo {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 3};
        NextGreaterElementTwo(arr);

        System.out.println("Rahul khichar");
    }


    public static int[] NextGreaterElementTwo(int[] nums) {
        int n = nums.length;

        int nums2[] = new int[2 * n];

        for (int i = 0; i < 2 * n; i++) {
            if (i < n)
                nums2[i] = nums[i];
            else
                nums2[i] = nums[i - n];
        }

        Stack<Integer> st = new Stack<>();
        for (int i = 2 * n - 1; i >= 0; i--) {

            while (!st.isEmpty() && nums2[i] >= st.peek()) {
                st.pop();
            }
            if(i<n) {
                if (st.isEmpty()) {
                    nums[i] = -1;
                } else {
                    nums[i] = st.peek();
                }
            }

            st.push(nums2[i]);

        }

        return nums;
    }
}
