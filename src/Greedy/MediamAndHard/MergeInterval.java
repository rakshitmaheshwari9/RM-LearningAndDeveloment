package Greedy.MediamAndHard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeInterval {
    public static void main(String[] args) {
        System.out.println("Rahul khichar");
        int interval[][] = {{1, 4}, {0, 0}};
        MergeInterval mergeInterval = new MergeInterval();


        int ans[][] = mergeInterval.merge(interval);

        for (int index = 0; index < ans.length; index++) {
            for (int secondIndex = 0; secondIndex < ans[0].length; secondIndex++) {

                System.out.print(ans[index][secondIndex] + ",");
            }
            System.out.println();
        }
    }

    public int[][] merge(int[][] intervals) {


        Arrays.sort(
                intervals,
                new Comparator<int[]>() {
                    @Override
                    public int compare(int[] o1, int[] o2) {
                        if (o1[0] == o2[0]) return o1[1] > o2[1] ? 1 : -1;
                        return o1[0] > o2[0] ? 1 : -1;
                    }
                }
        );
        List<List<Integer>> secondList = new ArrayList<>();

        int n = intervals.length;

        for (int index = 0; index <= intervals.length; index++) {

            if (secondList.size() >= 2) {
                List<Integer> lastInserted = secondList.remove(secondList.size() - 1);
                List<Integer> secondLastInserted = secondList.remove(secondList.size() - 1);

                if (secondLastInserted.get(1) >= lastInserted.get(0)) {
                    List<Integer> newList = new ArrayList<>();
                    newList.add(Math.min(secondLastInserted.get(0), lastInserted.get(0)));
                    newList.add(Math.max(secondLastInserted.get(1), lastInserted.get(1)));
                    secondList.add(newList);
                } else {
                    secondList.add(secondLastInserted);
                    secondList.add(lastInserted);
                }
            }
            if (index != n) {
                int[] interval = intervals[index];
                List<Integer> list = new ArrayList<>();
                list.add(interval[0]);
                list.add(interval[1]);
                secondList.add(list);
            }
        }
        int[][] ans = new int[secondList.size()][];
        int index = 0;

        for (List<Integer> list : secondList) {
            ans[index] = new int[]{list.get(0), list.get(1)};
            index++;
        }

        return ans;
    }
}
