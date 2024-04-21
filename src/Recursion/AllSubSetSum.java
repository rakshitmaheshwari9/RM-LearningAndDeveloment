package Recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AllSubSetSum {

    public static void main(String[] args) {
        System.out.println("Rahul Khichar");
        findAllSubsetSum();
    }


    public static void AllSubSetCombinationSumSecondMethod(int[] arr, int index, int sum, List<Integer> ans) {
        if (index == arr.length) {

            ans.add(sum);
            return;
        }

        AllSubSetCombinationSum(arr, index + 1, sum + arr[index], ans);
        AllSubSetCombinationSum(arr, index + 1, sum, ans);

    }

    public static void AllSubSetCombinationSum(int[] arr, int index, int sum, List<Integer> ans) {
        if (index == arr.length) {

            ans.add(sum);
            return;
        }

        AllSubSetCombinationSum(arr, index + 1, sum + arr[index], ans);
        AllSubSetCombinationSum(arr, index + 1, sum, ans);

    }

    public static void findAllSubsetSum() {
        int arr[] = {3, 1, 2};
        int n = 3;
        List<Integer> ans = new ArrayList<>();
        AllSubSetCombinationSum(arr, 0, 0, ans);
        Collections.sort(ans);
        for (int item : ans) {
            System.out.println(item);
        }

    }
}
