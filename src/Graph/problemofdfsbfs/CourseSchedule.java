package Graph.problemofdfsbfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseSchedule {
    public static void main(String[] args) {
        System.out.println("rahul khichar");

        int[][] pre = {{1, 0}};
        int number = 2;
        CourseSchedule courseSchedule = new CourseSchedule();
        int[] ans = courseSchedule.findOrder(number, pre);

        for (int index = 0; index < ans.length; index++) {

            System.out.println(ans[index]);
        }
    }


    public void dfs(Map<Integer, List<Integer>> mp, int node, boolean[] vis, List<Integer> ans) {

        vis[node] = true;

        if (!mp.containsKey(node)) {
            ans.add(node);
            return;
        }


        List<Integer> list = mp.get(node);

        for (int number : list) {
            if (!vis[number]) {
                dfs(mp, number, vis, ans);
            }
        }


        ans.add(node);

    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        Map<Integer, List<Integer>> mp = new HashMap<>();
        List<Integer> ans = new ArrayList<>();

        boolean[] vis = new boolean[numCourses];

        for (int index = 0; index < prerequisites.length; index++) {

            int x = prerequisites[index][0];
            int y = prerequisites[index][1];
            List<Integer> tempList;
            if (mp.containsKey(x)) {
                tempList = mp.get(x);
            } else {
                tempList = new ArrayList<>();
            }
            tempList.add(y);
            mp.put(x, tempList);
        }


        for (int index = 0; index < numCourses; index++) {

            if (!vis[index] && mp.containsKey(index)) {
                dfs(mp, index, vis, ans);
            }
        }


        int[] list = new int[numCourses];
        int index = 0;
        for (int number : ans) {
            list[index] = number;
            index++;
        }
        while (index < numCourses) {
            list[index] = index;
            index++;
        }

        return list;

    }
}
