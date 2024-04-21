package Graph.Learning;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LearningAndCreating {
    public static void main(String[] args) {
        System.out.println("rahul khichar");

        int[][] input = {{3, 2},
                {2, 1},
                {2, 0}};
        printAdjacency(3, 3, input);
    }

    public static int[][] printAdjacency(int n, int m, int[][] edges) {

        Map<Integer, List<Integer>> mp = new HashMap<>();
        int[][] ans = new int[n][n];

        for (int index = 0; index < m; index++) {
            int a = edges[index][0];
            int b = edges[index][1];

            if (mp.containsKey(a)) {
                mp.get(a).add(b);
            } else {
                List<Integer> temp = new ArrayList<>();
                temp.add(b);
                mp.put(a, temp);
            }

            if (mp.containsKey(b)) {
                mp.get(b).add(a);
            } else {
                List<Integer> temp = new ArrayList<>();
                temp.add(a);
                mp.put(b, temp);
            }
        }
        for (int i = 0; i < n; i++) {

            if (mp.containsKey(i)) {
                List<Integer> tempAns = mp.get(i);
                for (int j = 0; j < tempAns.size(); j++) {

                    ans[i][j] = tempAns.get(j);
                }
            }

        }
        return ans;
        // Write your code here.
    }
}
