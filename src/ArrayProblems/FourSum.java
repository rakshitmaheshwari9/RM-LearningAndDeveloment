package ArrayProblems;

import java.util.*;

public class FourSum {
    public static boolean fourSum(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);

        Set<List<Integer>> hasSet = new HashSet<>();
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                int left = 0;
                int right = n - 1;
                while (left < i && right > j) {

                    long sum = nums[left] + nums[i] + nums[j] + nums[right];

                    if (nums[left]>0 && nums[i]>0 && nums[j]>0 && nums[right]>0 && sum>0 && sum == target) {
                        List<Integer> tempList = new ArrayList<>();
                        tempList.add(nums[left]);
                        tempList.add(nums[i]);
                        tempList.add(nums[j]);
                        tempList.add(nums[right]);
                        hasSet.add(tempList);
                        left++;
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }

            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        for (List<Integer> list : hasSet) {
            ans.add(list);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {1000000000, 1000000000, 1000000000, 1000000000};
        int sum = -294967296;
        System.out.println(fourSum(arr, sum));
        System.out.println("Rahul khichar");
    }
}
