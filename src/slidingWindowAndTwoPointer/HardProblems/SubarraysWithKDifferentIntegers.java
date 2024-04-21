package slidingWindowAndTwoPointer.HardProblems;

import java.util.HashMap;
import java.util.Map;

public class SubarraysWithKDifferentIntegers {

    public static void main(String[] args) {
        System.out.println("Rahul khichar");
        SubarraysWithKDifferentIntegers subarraysWithKDifferentIntegers = new SubarraysWithKDifferentIntegers();
        int[] arr = {1,2,1,3,4};
        System.out.println(subarraysWithKDifferentIntegers.subarraysWithKDistinct(arr, 3));
    }

    public int subarraysWithKDistinct(int[] nums, int k) {

        Map<Integer, Integer> mp = new HashMap<>();
        int ans = 0;
        int lastIndex = 0;

        for (int index = 0; index < nums.length; index++) {
            int number = nums[index];

            if (mp.containsKey(number)) {
                mp.put(number, mp.get(number) + 1);

            } else {
                mp.put(number, 1);
            }

            if (mp.size() == k) {
                ans++;
            }

            while (mp.size() > k) {

                int firstElement = nums[lastIndex];
                lastIndex++;
                mp.put(firstElement, mp.get(firstElement) - 1);
                if (mp.get(firstElement) == 0) {
                    mp.remove(firstElement);
                }
                ans++;

            }

        }


        while (mp.size() > k) {

            int firstElement = nums[lastIndex];
            lastIndex++;
            mp.put(firstElement, mp.get(firstElement) - 1);
            if (mp.get(firstElement) == 0) {
                mp.remove(firstElement);
            }
            ans++;

        }
        if (mp.size() == 2) {
            ans++;
        }

        return ans;

    }
}
