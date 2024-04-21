package Graph.TopoSort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopoLogicalSorting {

    public static void main(String[] args) {
        System.out.println("Rahul khichar");

        int edges[][] = {
                {0, 2},
                {1, 2},
                {3, 1},
                {0, 4}};
        topologicalSort(edges, 5, 4);
    }

    public static void dfs(Map<Integer, List<Integer>> mp, int node, boolean[] vis, List<Integer> ans) {

        vis[node] = true;

        if (mp.containsKey(node)) {
            for (int number : mp.get(node)) {
                if (!vis[number]) {
                    dfs(mp, number, vis, ans);
                }
            }
        }
        ans.add(node);
    }

    public static List<Integer> topologicalSort(int[][] edges, int e, int v) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, List<Integer>> mp = new HashMap<>();
        for (int[] arr : edges) {

            int firstElement = arr[0];
            int secondElement = arr[1];
            List<Integer> temp;
            if (mp.containsKey(secondElement)) {
                temp = mp.get(secondElement);
            } else {
                temp = new ArrayList<>();
            }
            temp.add(firstElement);
            mp.put(secondElement, temp);
        }


        boolean[] vis = new boolean[v + 1];

        for (int i = 0; i <= v; i++) {


            if (!vis[i]) {
                dfs(mp, i, vis, list);
            }
        }


        return list;
        // Write your code here!

    }
}
