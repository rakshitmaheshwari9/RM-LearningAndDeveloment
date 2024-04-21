package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class CombinationSumTwo {

    public static void main(String[] args) {
        System.out.println("Rahul khichar");
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        List<List<Integer>> ans = combinationSum2(candidates, target);

        for (List<Integer> temp : ans) {
            for (int item : temp) {
                System.out.print(item + " ");
            }
            System.out.println();
        }
    }


    public static void combinationFirstSolution(int[] candidates, int index, int target, int sum, HashSet<List<Integer>> ans, List<Integer> tempList) {

        if (index >= candidates.length) {
            if (sum == target) {
                ans.add(tempList);

            }
            return;
        }


        if (sum > target) return;

        List<Integer> newList = new ArrayList<>(tempList);
        newList.add(candidates[index]);
        combinationFirstSolution(candidates, index + 1, target, sum, ans, tempList);
        sum += candidates[index];
        combinationFirstSolution(candidates, index + 1, target, sum, ans, newList);

    }


    public static void combinationSecondSolution(int[] candidates, int index, int target, int sum, List<List<Integer>> ans, List<Integer> tempList) {


        if (sum == target) {
            ans.add(new ArrayList<>(tempList));
            return;

        }

        if (sum > target) return;

        for (int index2 = index; index2 < candidates.length; index2++) {
            if (index2 > index && candidates[index2] == candidates[index2 - 1]) continue;
            tempList.add(candidates[index2]);
            combinationSecondSolution(candidates, index2 + 1, target, sum + candidates[index2], ans, tempList);
            tempList.remove(tempList.size() - 1);
//
//            List<Integer> tempList2 = new ArrayList<>();
//            tempList2.add(index2);
//            combinationSecondSolution(candidates, index2 + 1, target, candidates[index2], ans, tempList2);
//            tempList2.remove(tempList2.size() - 1);
        }

    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        HashSet<List<Integer>> ans2 = new HashSet<>();


        List<Integer> tempList = new ArrayList<>();
//        tempList.add(candidates[0]);
        int sum = 0;
//        combinationFirstSolution(candidates, 0, target, sum, ans2, tempList);
        combinationSecondSolution(candidates, 0, target, sum, ans, tempList);
//        for (List<Integer> item : ans2) {
//            ans.add(item);
//        }
        return ans;
    }
}
