package Recursion;

import java.util.ArrayList;
import java.util.List;

public class ListSubSet {


    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> ans = recursion(nums, 0);
        for (List<Integer> tempList : ans) {
            System.out.print("( ");
            for (int item : tempList) {
                System.out.print(item + ",");
            }
            System.out.print(" )");
            System.out.println();
        }
        System.out.println("Rahul khichar");
    }


    public static List<List<Integer>> recursion(int[] nums, int index) {
        List<List<Integer>> ans = new ArrayList<>();
         if(index==0) {

         }

        return ans;
    }

    public List<List<Integer>> subsets(int[] nums) {


        List<List<Integer>> ans = new ArrayList<>();

        return ans;
    }
}
