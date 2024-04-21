package Recursion;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {

    public static void main(String[] args) {
        System.out.println("Rahul khichar");

        int[] num = {1, 2, 3};
        subsets(num);
        List<List<Integer>> ans = new ArrayList<>();
        recursion(num, 0, new ArrayList<>(), ans);
        print2DArray(ans);

    }

    public static void print2DArray(List<List<Integer>> ans) {
        for (List<Integer> temp : ans) {
            for (int item : temp) {
                System.out.print(item + " ");
            }
            System.out.println();
        }
    }

    public static void print(List<Integer> temp) {
        for (int number : temp) {
            System.out.print(number + " ");
        }
        System.out.println();

    }

    public static void recursion(int[] nums, int index, List<Integer> temp, List<List<Integer>> ans) {
        if (index == nums.length) {
            ans.add(temp);
            return;
        }

        List<Integer> tempNotIn = new ArrayList<>(temp);
        recursion(nums, index + 1, temp, ans);
        tempNotIn.add(nums[index]);
        recursion(nums, index + 1, tempNotIn, ans);

    }


    public static List<List<Integer>> subsets(int[] nums) {


        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;

        for (int num = 0; num <= (1 << n) - 1; num++) {
            List<Integer> tempList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if ((num & (1 << i)) != 0) {
                    tempList.add(nums[i]);
                }
            }
            ans.add(tempList);

        }

        return ans;

    }
}
