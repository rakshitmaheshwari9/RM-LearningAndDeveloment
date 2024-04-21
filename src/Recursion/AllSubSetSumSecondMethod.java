package Recursion;

import java.util.*;

public class AllSubSetSumSecondMethod {
    public static void main(String[] args) {
        System.out.println("Rahul khichar");
        findAllSubsetSum();
    }


    public static void AllSubSetCombinationSum(int[] arr, int index, int sum, List<Integer> ans, Set<List<Integer>> finalAns) {
        if (index == arr.length) {
            finalAns.add(new ArrayList<>(ans));
            return;
        }
        ans.add(arr[index]);
        AllSubSetCombinationSum(arr, index + 1, sum + arr[index], ans, finalAns);
        ans.remove(ans.size() - 1);
        AllSubSetCombinationSum(arr, index + 1, sum, ans, finalAns);

    }

    public static void findAllSubsetSum() {
        int arr[] = {3, 1, 2};
        int n = 3;
        Arrays.sort(arr);
        List<Integer> ans = new ArrayList<>();
        Set<List<Integer>> finalAns = new HashSet<>();

        AllSubSetCombinationSum(arr, 0, 0, ans, finalAns);
//        Collections.sort(ans);
//        for (int item : ans) {
//            System.out.println(item);
//        }


        List<List<Integer>> lastAndFinalAns = new ArrayList<>();
        for (List<Integer> temp : finalAns) {
            lastAndFinalAns.add(temp);
        }
//
//        for (List<Integer> temp : finalAns) {
//            for (int item : temp) {
//                System.out.print(item + " ");
//            }
//            System.out.println();
//        }

    }
}
