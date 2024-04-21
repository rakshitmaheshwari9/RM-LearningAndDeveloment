package ArrayProblems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SuperiorElements {


    public static List<Integer> superiorElements(int[] nums) {

        List<Integer> ans = new ArrayList<>();
        int n = nums.length;

        for (int i = n - 1; i >= 0; i--) {

            if (ans.isEmpty()) {
                ans.add(nums[i]);
            } else {
                if (nums[i] > ans.get(ans.size() - 1)) {
                    ans.add(nums[i]);
                }
            }
        }
//        Collections.reverse(ans);
        return ans;
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 2};
        List<Integer> ans = superiorElements(arr);

        for (int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i) + " ");
        }

        System.out.println("Rahul khichar");
    }
}
