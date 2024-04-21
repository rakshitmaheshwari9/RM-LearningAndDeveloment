package ArrayProblems;

import java.util.*;

public class ThreeSum {

    public static void threeSumSecondMethod(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        Set<List<Integer>> hashset = new HashSet<>();

        for (int i = 1; i < n - 1; i++) {


            int left = 0;
            int right = n - 1;
            while (left < i && right > i) {

                int sum = nums[left] + nums[i] + nums[right];
                if (sum == 0) {
                    List<Integer> tempList = new ArrayList<>();
                    tempList.add(nums[left]);
                    tempList.add(nums[i]);
                    tempList.add(nums[right]);
                    hashset.add(tempList);
                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }

            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Rahul khichar");
    }

    public void threeSum(int[] nums) {
        Map<Integer, pair> mp = new HashMap<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (!mp.containsKey(nums[i] + nums[j])) {
                    mp.put((nums[i] + nums[j]), new pair(i, j));
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int k = n - 1; k >= 0; k--) {
            if (mp.containsKey(0 - nums[k])) {
                pair p = mp.get(0 - nums[k]);

                if (k != p.x && k != p.y) {
                    List<Integer> tempList = new ArrayList<>();
                    tempList.add(nums[p.x]);
                    tempList.add(nums[p.y]);
                    tempList.add(nums[k]);
                    ans.add(tempList);
                }
            }
        }
    }

    public class pair {
        int x;
        int y;

        pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
