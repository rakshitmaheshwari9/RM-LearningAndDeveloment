package Graph.TopoSort;

import java.util.*;

public class Courseschedule {

    public static void main(String[] args) {
        System.out.println("Rahul khichar");

        Courseschedule courseschedule = new Courseschedule();
        int prerequisites[][] = {{0, 1}, {0, 2}, {1, 2}};
        int n = 3;

        System.out.println(courseschedule.canFinish(n, prerequisites));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> mp = new HashMap<>();
        for (int[] direction : prerequisites) {
            int firstElement = direction[0];
            int secondElement = direction[1];
            List<Integer> adjList;
            if (mp.containsKey(firstElement)) {
                adjList = mp.get(firstElement);
            } else {
                adjList = new ArrayList<>();
            }
            adjList.add(secondElement);
            mp.put(firstElement, adjList);
        }


        boolean[] vis = new boolean[numCourses];
        for (int index = 0; index < numCourses; index++) {

            if (!vis[index]) {

                Stack<Integer> st = new Stack<>();
                st.push(index);
                List<Integer> list = new ArrayList<>();


                while (!st.isEmpty()) {
                    int node = st.pop();
                    vis[node] = true;
                    list.add(node);

                    if (mp.containsKey(node)) {
                        for (int element : mp.get(node)) {

                            if (vis[element] && list.contains(element)) return false;
                            if (!vis[element]) st.add(element);
                        }
                    }


                }


            }
        }


        return true;

    }
}
