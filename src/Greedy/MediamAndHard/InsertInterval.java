package Greedy.MediamAndHard;

import java.util.ArrayList;
import java.util.List;

/**
 * Shortest Job First (SJF) algorithm implementation.
 * You are given an array of non-overlapping intervals intervals
 * where intervals[i] = [starti, endi] represent the start and the end of
 * the ith interval and intervals is sorted in ascending order by starti.
 * You are also given an interval newInterval = [start, end] that represents the start and end of another interval.
 * Insert newInterval into intervals such that intervals is still
 * sorted in ascending order by starti and intervals still does not have any overlapping intervals
 * (merge overlapping intervals if necessary).
 * Return intervals after the insertion
 */
public class InsertInterval {

    public static void main(String[] args) {
        System.out.println("Rahul khichar");


        int[][] input = {{1, 5}};
        int[] newInterval = {6, 8};

        InsertInterval insertInterval = new InsertInterval();
        int[][] output = insertInterval.insert(input, newInterval);


    }


    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<List<Integer>> secondList = new ArrayList<>();

        boolean isDone = false;
        int n = intervals.length;

        for (int index = 0; index <= intervals.length; index++) {
            if (index != n && !isDone) {
                int[] interval = intervals[index];
                if (interval[0] > newInterval[0]) {
                    isDone = true;
                    List<Integer> temp2 = new ArrayList<>();
                    temp2.add(newInterval[0]);
                    temp2.add(newInterval[1]);
                    secondList.add(temp2);
                }
            } else if (!isDone && index == n) {
                List<Integer> temp2 = new ArrayList<>();
                temp2.add(newInterval[0]);
                temp2.add(newInterval[1]);
                secondList.add(temp2);
            }

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
