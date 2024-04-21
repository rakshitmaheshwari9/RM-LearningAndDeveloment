package ArrayProblems;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayWithSumK {


    public static int longestSubarrayWithSumK(int[] array, long sum) {
        long currSum = 0;
        int start = 0;
        int maxLength = 0;
        int n = array.length;

        for (int i = 0; i < n; i++) {
            currSum += array[i];

            if (currSum > sum) {
                currSum -= array[start];
                start++;
            }
            if (currSum == sum) {
                int length = i - start + 1;
                if (length > maxLength) {
                    maxLength = length;
                }
            }
        }

        return maxLength;

    }

    public static int longestSubarrayWithMapSumK(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        int n = nums.length;
        int sum = 0;

        int maxLength = 0;
        map.put(k,-1);

        for (int i = 0; i < n; i++) {
            sum += nums[i];

            if (map.containsKey(sum)) {
                maxLength = Math.max(maxLength, i - map.get(sum));
            }

            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }

        }


        return maxLength;

    }

    public static void main(String[] args) {


        int[] arr = { 1, 2, 4, 2, -3, 2};
              //     -10 ,-2,0,-2
           ///        0  1  2  3  ,   3-1+1
            // -2
        int k = 4;
        System.out.println(longestSubarrayWithMapSumK(arr, k));
        System.out.println("Rahul khichar");
    }
}
