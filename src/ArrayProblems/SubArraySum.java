package ArrayProblems;

import java.util.HashMap;
import java.util.Map;

public class SubArraySum {

    public static int subArraySum(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        int ans = 0;
        mp.put(0, 1);
//        mp.put(nums[0], 1);
        for (int i = 0; i < nums.length; i++) {
            if(i>=1) {
                nums[i] = nums[i - 1] + nums[i];
            }

            if (mp.containsKey(nums[i] - k)) {
                ans += mp.get(nums[i] - k);
            }

            if (!mp.containsKey(nums[i])) {
                mp.put(nums[i], 1);
            } else {
                mp.put(nums[i], mp.get(nums[i]) + 1);
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        int[] nums = {1};

        System.out.println(subArraySum(nums, 1));
        System.out.println("Rahul khichar");
    }
}
