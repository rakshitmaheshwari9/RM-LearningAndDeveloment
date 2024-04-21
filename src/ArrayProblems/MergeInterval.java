package ArrayProblems;

import java.util.*;

public class MergeInterval {


    public static int[][] mergeBetterSolution(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                } else {
                    return o1[0] - o2[0];
                }
            }
        });
        Queue<List<Integer>> ans = new LinkedList<>();
        List<Integer> tempList = new ArrayList<>();
        tempList.add(intervals[0][0]);
        tempList.add(intervals[0][1]);
        ans.add(tempList);

        for (int i = 1; i < intervals.length; i++) {
            List<Integer> temp = ans.peek();
            int firstIndex=temp.get(0);
            while (temp.get(1) >= intervals[i][0]) {
                ans.poll();
                firstIndex=temp.get(0);
                temp = ans.peek();
            }
        }
        int[][] finalAns = new int[ans.size()][2];
        int i = 0;
        for (List<Integer> list : ans) {
            finalAns[i][0] = list.get(0);
            finalAns[i][1] = list.get(1);
            i++;
//            System.out.println("{" + list.get(0) + "," + list.get(1) + "}");
        }

        return finalAns;
    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                } else {
                    return o1[0] - o2[0];
                }
            }
        });

        List<List<Integer>> ans = new ArrayList<>();
        int firstIndex = intervals[0][0];
        int secondIndex = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {

            if (intervals[i][0] > secondIndex) {
                List<Integer> tempList = new ArrayList<>();
                tempList.add(firstIndex);
                tempList.add(secondIndex);
                ans.add(tempList);
                firstIndex = intervals[i][0];
            }
            secondIndex = intervals[i][1];
            firstIndex = Math.min(firstIndex, intervals[i][0]);
        }
        List<Integer> tempList = new ArrayList<>();
        tempList.add(firstIndex);
        tempList.add(secondIndex);
        ans.add(tempList);
        int[][] finalAns = new int[ans.size()][2];
        int i = 0;
        for (List<Integer> list : ans) {
            finalAns[i][0] = list.get(0);
            finalAns[i][1] = list.get(1);
            i++;
//            System.out.println("{" + list.get(0) + "," + list.get(1) + "}");
        }

        return finalAns;
    }

    public static void main(String[] args) {

        int[][] ans = {{2, 3}, {4, 5}, {6, 7}, {8, 9}, {1, 10}};
        ans = merge(ans);

        for (int i = 0; i < ans.length; i++) {
            System.out.println("{" + ans[i][0] + "," + ans[i][1] + "}");
        }
        System.out.println("Rahul khichar");
    }
}
