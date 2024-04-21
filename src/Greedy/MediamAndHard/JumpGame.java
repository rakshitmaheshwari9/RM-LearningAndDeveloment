package Greedy.MediamAndHard;

public class JumpGame {

    public static void main(String[] args) {
        System.out.println("Rahul khichar");

        int[] nums = {1, 0, 1, 0};

        System.out.println(canJump(nums));
    }

    public static boolean canJump(int[] nums) {
        int n = nums.length;
        int reach[] = new int[n];
        reach[0] = 0;
        for (int i = 1; i < n; i++) {
            reach[i] = Integer.MAX_VALUE;
        }

        for (int index = 0; index < n - 1; index++) {
            int length = nums[index];

            for (int i = index + 1; i <= index + length && i < n; i++) {
                if (reach[index] != Integer.MAX_VALUE)
                    reach[i] = Math.min(reach[i], reach[index] + 1);
            }

        }

//        System.out.println(reach[n - 1]);

//        for (int number : reach) {
//            System.out.println(number);
//        }
        if (reach[n - 1] != Integer.MAX_VALUE) return true;

        return false;
    }
}
