package Greedy.MediamAndHard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class NonOverLapingntervals {
    public static void main(String[] args) {
        System.out.println("Rahul khichar");

        int[][] input = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        NonOverLapingntervals nonOverLapingntervals = new NonOverLapingntervals();

        System.out.println(nonOverLapingntervals.eraseOverlapIntervals(input));
    }


    public int eraseOverlapIntervals(int[][] intervals) {

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) return o1[0] > o2[0] ? 1 : -1;
                else if (o2[1] != o2[1]) return o1[1] > o2[1] ? 1 : -1;
                return 0;
            }
        });

        List<int[]> list = new ArrayList<>();
        for (int index = 0; index < intervals.length; index++) {

            if (list.size() >= 1) {
                int[] lastInterval = list.remove(list.size() - 1);
                if (intervals[index][0] < lastInterval[1]) {

                    if (intervals[index][1] < lastInterval[1]) {
                        list.add(intervals[index]);
                    } else {
                        list.add(lastInterval);
                    }
                } else {
                    list.add(lastInterval);
                    list.add(intervals[index]);
                }
            } else {

                list.add(intervals[index]);
            }

        }


        return intervals.length - list.size();
    }
}
