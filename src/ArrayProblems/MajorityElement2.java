package ArrayProblems;

import java.util.ArrayList;
import java.util.List;

public class MajorityElement2 {

    public static List<Integer> majorityElement2(int[] nums) {


        int count1 = 0;
        int count2 = 0;
        int element1 = 0;
        int element2 = 0;
        for (int element : nums) {
            if (element == element1) {
                count1++;
            } else if (element == element2) {
                count2++;
            } else if (count1 == 0) {
                element1 = element;
                count1++;
            } else if (count2 == 0) {
                element2 = element;
                count2++;
            } else {
                count2--;
                count1--;
            }
        }

        count2 = 0;
        count1 = 0;
        int n = nums.length;
        for (int element : nums) {
            if (element == element1) {
                count1++;
            } else if (element == element2) {
                count2++;
            }
        }
        List<Integer> ans = new ArrayList<>();
        if (count2 > count1) {
            if (count2 > n / 3)
                ans.add(element2);

            if (count1 > n / 3)
                ans.add(element1);
        } else {
            if (count1 > n / 3)
                ans.add(element1);

            if (count2 > n / 3)
                ans.add(element2);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("rahul khichar");
    }
}
