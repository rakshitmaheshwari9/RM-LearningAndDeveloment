package slidingWindowAndTwoPointer;


import java.util.LinkedList;
import java.util.Queue;

public class MaxConsecutiveOnesIII {

    public static void main(String[] args) {
        System.out.println("Rahul Khichar");

        int arr[] = {0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};
        int arr2[] = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k2 = 2;
        int k = 3;

        int arr3[] = {0, 0, 0, 0};
        int k3 = 0;
        MaxConsecutiveOnesIII maxConsecutiveOnesIII = new MaxConsecutiveOnesIII();
        System.out.println(maxConsecutiveOnesIII.longestOnes(arr3, k3));
    }

    public int longestOnes(int[] nums, int k) {
        if (nums.length == 0) {
            return 0;
        }
//        int ans = 0;
//        if (k == 0) {
//
//        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(-1);
     int   ans = 0;

        for (int index = 0; index < nums.length; index++) {

            if (nums[index] == 0) {
                queue.add(index);
            }
            if (queue.size() > k + 1) {
                int lastIndex = queue.poll();
                ans = Math.max(ans, (index - lastIndex - 1));
            }
        }
        ans = Math.max(ans, nums.length - queue.poll() - 1);

        return ans;
    }
}
