package Recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubSequnceWithSumK {


    public static void findSubSequnce(int[] a, int index, List<Integer> tempAns, List<List<Integer>> ans, long sum, long currSum) {

        if (index == a.length) {
            if (currSum == sum) {
                ans.add(new ArrayList<>(tempAns));
            }
            return;
        }

        tempAns.add(a[index]);
        currSum += a[index];
        findSubSequnce(a, index + 1, tempAns, ans, sum, currSum);
        tempAns.remove(tempAns.size() - 1);

        currSum -= a[index];
        findSubSequnce(a, index + 1, tempAns, ans, sum, currSum);

    }


    public static void findSubArray(int[] a, int index, List<Integer> tempAns, Set<List<Integer>> ans, long sum, long currSum) {

        if (index == a.length) {
            if (currSum == sum) {
                ans.add(new ArrayList<>(tempAns));
            }
            return;
        }

        if (currSum == sum) {
            ans.add(new ArrayList<>(tempAns));
            return;
        }

        tempAns.add(a[index]);
        currSum += a[index];
        findSubArray(a, index + 1, tempAns, ans, sum, currSum);
        tempAns.remove(tempAns.size() - 1);

        findSubArray(a, index + 1, new ArrayList<>(), ans, sum, 0);

    }

    public static Set<List<Integer>> subarraysWithSumK(int[] a, long k) {
        Set<List<Integer>> ans = new HashSet<>();
        List<Integer> tempSum = new ArrayList<>();
        findSubArray(a, 0, tempSum, ans, k, 0);
        for (List<Integer> ast : ans) {

            for (int test : ast) {
                System.out.print(test + " ");
            }
            System.out.println();
        }

        return ans;
    }

    public static List<List<Integer>> subsequnceWithSumK(int[] a, long k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> tempSum = new ArrayList<>();
        findSubSequnce(a, 0, tempSum, ans, k, 0);
        for (List<Integer> ast : ans) {

            for (int test : ast) {
                System.out.print(test + " ");
            }
            System.out.println();
        }

        return ans;
    }

    public static void subsequnceWithSumKEasyMethod(int[] a, long k) {

        int lastIndex = -1;
        int lastSum = 0;
        for (int i = 0; i < a.length; i++) {
            
        }
    }


    public static void main(String[] args) {
        int[] temp = {1, 2, 3, 1, 1, 1};
//        subsequnceWithSumK(temp, 3);
        subarraysWithSumK(temp, 3);
        System.out.println("Rahul Khichar");
    }
}
