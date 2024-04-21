package ArrayProblems;

import java.util.HashMap;
import java.util.Map;

public class XorOfSubArray {

    public static int xorOfSubArray(int[] nums, int k) {

        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int element = nums[i];
            if (element == k) {
                ans++;
            }
            for (int j = i + 1; j < n; j++) {
                element = element ^ nums[j];
                if (element == k) {
                    ans++;
                }
            }
        }
        return ans;

    }

    public static int xorOfSubArrayBetterVersion(int[] nums, int k) {

        int n = nums.length;
        int ans = 0;
        Map<Integer, Integer> mp = new HashMap<>();
        int element = 0;
        mp.put(0, 1);
        for (int i = 0; i < n; i++) {
            element = element ^ nums[i];
            if (mp.containsKey(element)) {
                mp.put(element, mp.get(element) + 1);
            } else {
                mp.put(element, 1);
            }

            if (mp.containsKey(element ^ k)) {
                ans += mp.get(element ^ k);
            }
        }
        return ans;

    }

    public static void main(String[] args) {

        int[] array = {4, 2, 2, 6, 4};
        int k = 6;
        System.out.println(xorOfSubArrayBetterVersion(array, k));
        System.out.println("Rahul khichar");
    }
}
