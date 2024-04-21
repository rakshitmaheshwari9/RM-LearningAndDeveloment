package StackAndQueue.stackImplementation;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowProblem {
    public static void main(String[] args) {
        System.out.println("Rahul khichar");

        int arr[] = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        int ans[] = maximumSlidingWindow(arr, k);
        for (int element : ans) {
            System.out.println(element + ",");
        }
    }

    public static int[] maximumSlidingWindow(int[] nums, int k) {

        Deque<Integer> deque = new LinkedList<>();
        int[] ans = new int[nums.length - k + 1];

        for (int i = 0; i < nums.length; i++) {

            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) {
                deque.removeLast();
            }
            if (!deque.isEmpty() && deque.getFirst() <= i - k) {
                deque.removeFirst();
            }

            deque.add(i);

            if (i >= k - 1) {
                ans[i - k + 1] = nums[deque.getFirst()];
            }

        }

        return ans;

    }
}
