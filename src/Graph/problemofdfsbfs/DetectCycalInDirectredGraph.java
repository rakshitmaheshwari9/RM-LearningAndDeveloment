package Graph.problemofdfsbfs;

import java.util.*;

/**
 *
 */
public class DetectCycalInDirectredGraph {

    public static void main(String[] args) {
        System.out.println("Rahul khichar");

        DetectCycalInDirectredGraph detectCycalInDirectredGraph = new DetectCycalInDirectredGraph();
        int[][] edges = {
                {1, 0},
                {1, 2},
                {0, 2}
        };

        System.out.println(isCyclic(edges, 3, 3));
    }

    public static Boolean isValid(int index, Map<Integer, List<Integer>> mp, boolean[] vis) {

        Stack<Integer> st = new Stack<>();
        st.add(index);

        while (!st.isEmpty()) {

            int node = st.pop();

            if (vis[node] && node == index) return true;
            if (!vis[node]) {

                vis[node] = true;

                if (mp.containsKey(node)) {
                    for (int tempNode : mp.get(node)) {
                        st.add(tempNode);
                    }
                }
            }
        }

        return false;
    }


    public static Boolean isCyclic(int[][] edges, int v, int e) {
        // Write your code here.

        boolean[] vis = new boolean[v];
        Map<Integer, List<Integer>> mp = new HashMap<>();

        for (int index = 0; index < edges.length; index++) {
            int xIndex = edges[index][0];
            int yIndex = edges[index][1];
            List<Integer> list;
            if (mp.containsKey(xIndex)) {
                list = mp.get(xIndex);
            } else {
                list = new ArrayList<>();
            }
            list.add(yIndex);
            mp.put(xIndex, list);
        }


        for (int index = 0; index < v; index++) {

            if (mp.containsKey(index) && !vis[index]) {
                if (isValid(index, mp, vis)) return true;
            }

        }

        return false;
    }
}
