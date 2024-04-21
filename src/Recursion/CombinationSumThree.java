package Recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumThree {

    public static void main(String[] args) {
        System.out.println("Rahul khichar");
        solutionFirst();
    }


    public static void combinationSumFirstSolution(int[] arr, int index, int target, int sizeOfArray, int sum, List<Integer> temp, List<List<Integer>> ans) {
        if (temp.size() == sizeOfArray) {
            if (sum == target) {
                ans.add(new ArrayList<>(temp));
            }

            return;
        }
        if (index >= arr.length) return;

        if (sum > target) return;
        combinationSumFirstSolution(arr, index + 1, target, sizeOfArray, sum, temp, ans);
        temp.add(arr[index]);
        combinationSumFirstSolution(arr, index + 1, target, sizeOfArray, sum + arr[index], temp, ans);
        temp.remove(temp.size() - 1);
    }

    public static void solutionFirst() {
        int n = 9;
        int k = 3;

        int arr[] = new int[n];
        for (int i = 1; i <= n; i++) {
            arr[i - 1] = i;
        }
        int target = n;
        int sizeOfArray = k;
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        combinationSumFirstSolution(arr, 0, target, sizeOfArray, 0, temp, ans);
        for (List<Integer> t : ans) {
            for (int item : t) {
                System.out.print(item + " ");
            }
            System.out.println();

        }


    }

}
