package ArrayProblems;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public static List<List<Integer>> pascalsTriangle(int n) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        ans.add(list);

        while (n > 0) {
            n--;
            List<Integer> tempList = new ArrayList<>();
            List<Integer> preList = ans.get(ans.size() - 1);
            tempList.add(1);

            for (int i = 1; i < preList.size(); i++) {
                tempList.add(preList.get(i) + preList.get(i - 1));

            }
            tempList.add(1);
            ans.add(tempList);
        }

        return ans;

    }

    public static void main(String[] args) {
        System.out.println("Rahul khichar");
    }
}
