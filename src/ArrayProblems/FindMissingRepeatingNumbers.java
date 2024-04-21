package ArrayProblems;

import java.util.Arrays;

public class FindMissingRepeatingNumbers {


    public static void main(String[] args) {
        System.out.println("Rahul khichar");
    }

    public static int[] findMissingRepeatingNumbers(int[] nums) {

        int ans[] = new int[2];

        Arrays.sort(nums);


        int repeating = 0;
        int missing = nums.length;

        for (int i = 0; i < nums.length; i++) {
            if (i == 0 && nums[i] != 1) {
                missing = 1;
            } else {

                if (nums[i] == nums[i - 1]) {
                    repeating = nums[i];
                } else if (nums[i] != nums[i - 1] + 1) {
                    missing = nums[i - 1] + 1;
                }

            }
        }
        ans[0] = repeating;
        ans[1] = missing;
        return ans;
    }
}
