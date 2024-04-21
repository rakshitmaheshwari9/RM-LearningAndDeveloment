package ArrayProblems;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarray {

    public static int getLongestZeroSumSubarrayLength(int[] arr) {
        // Write your code here.
        Map<Integer, Integer> mp = new HashMap<>();

        int ans = 0;
        mp.put(0,-1);

        for (int i = 0; i < arr.length; i++) {
            if (i != 0) {
                arr[i] = arr[i] + arr[i - 1];
            }
            if (!mp.containsKey(arr[i])) {
                mp.put(arr[i], i);
            } else {
                ans=Math.max(ans,i-mp.get(arr[i]));
            }


        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {-37, 37};
        System.out.println(getLongestZeroSumSubarrayLength(nums));
        System.out.println("Rahul khichar");
    }
}
