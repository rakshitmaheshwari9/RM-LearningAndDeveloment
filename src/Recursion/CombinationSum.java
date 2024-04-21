package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

    public static void main(String[] args) {
        System.out.println("Rahul khichar");
        combinationSum();
    }


    public static void solution(int[] array, int index, int target, int sum, List<Integer> tempList, List<List<Integer>> ans) {
        if (index == array.length) {
            if (sum == target) {
                ans.add(tempList);
                return;
            }


            return;
        }

        if (sum > target) return;


        solution(array, index + 1, target, sum, tempList, ans);
        List<Integer> newArrayList = new ArrayList<>(tempList);
        newArrayList.add(array[index]);
        solution(array, index + 1, target, sum + array[index], newArrayList, ans);

    }

    public static void solution2(int[] array, int index, int target, int sum, List<Integer> tempList, List<List<Integer>> ans) {
        if (index == array.length) {
            if (sum == target) {
                ans.add(tempList);
                return;
            }


            return;
        }

        if (sum > target) return;
        List<Integer> newArrayList = new ArrayList<>(tempList);
        newArrayList.add(array[index]);
        solution2(array, index, target, sum + array[index], newArrayList, ans);
        solution2(array, index + 1, target, sum, tempList, ans);

    }


    public static List<List<Integer>> combinationSum() {
        List<List<Integer>> ans = new ArrayList<>();

        int[] arr = {10, 1, 2, 7, 6, 1, 5};
        Arrays.sort(arr);

        int target = 7;

        solution(arr, 0, 8, 0, new ArrayList<>(), ans);
        for (List<Integer> temp : ans) {
            for (int t : temp) {
                System.out.print(t);
            }
            System.out.println("Jai Shree ram");
        }

        return ans;
    }
}
