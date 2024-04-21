package Graph.Learning;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindNumOfProvinces {

    public static void main(String[] args) {

        int[][] arr = {{1, 1, 1, 0},
                {1, 1, 1, 0},
                {1, 1, 1, 0},
                {0, 0, 0, 1}};
        int n = 4;
        System.out.println(findNumOfProvinces(arr, n));
        System.out.println("Rahul khichar");
    }

    public static void dfs(int index, Map<Integer, List<Integer>> mp, boolean[] vis) {

        if (vis[index]) return;
        vis[index] = true;

        if (mp.containsKey(index)) {
            for (int i = 0; i < mp.get(index).size(); i++) {
                if (!vis[mp.get(index).get(i)]) {
                    dfs(mp.get(index).get(i), mp, vis);
                }
            }
        }

    }

    public static int findNumOfProvinces(int[][] roads, int n) {
        // Write your code here.

        Map<Integer, List<Integer>> mp = new HashMap<>();

        for (int i = 0; i < roads.length; i++) {
            for (int j = 0; j < roads[i].length; j++) {
                if (i != j) {
                    if (roads[i][j] != 0) {
                        if (mp.containsKey(i)) {
                            mp.get(i).add(j);
                        } else {
                            List<Integer> temp = new ArrayList<>();
                            temp.add(j);
                            mp.put(i, temp);
                        }

                    }
                }
            }
        }

        boolean[] vis = new boolean[n];
        int ans = 0;

        for (int index = 0; index < vis.length; index++) {

            if (!vis[index]) {
                ans++;
                dfs(index, mp, vis);

            }
        }
        return ans;
    }
}
