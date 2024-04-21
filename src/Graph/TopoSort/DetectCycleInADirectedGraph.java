package Graph.TopoSort;

import java.util.*;

public class DetectCycleInADirectedGraph {

    public static void main(String[] args) {
        System.out.println("Rahul khichar");
    }

    //  this one is the correct solution rahul khichar
    // you are going in the right path rahul khichar
    public static boolean detectCycleInDirectedGraph(int n, ArrayList<ArrayList<Integer>> edges) {

        boolean[] vis = new boolean[n];
        Map<Integer, List<Integer>> mp = new HashMap<>();

        for (List<Integer> list : edges) {
            int firstElement = list.get(0);
            int secondElement = list.get(1);
            List<Integer> adj;

            if (mp.containsKey(firstElement)) {
                adj = mp.get(firstElement);
            } else {
                adj = new ArrayList<>();
            }
            adj.add(secondElement);
            mp.put(firstElement, adj);

        }


        for (int index = 0; index < n; index++) {
            if (!vis[index]) {
                Stack<Integer> st = new Stack<>();
                List<Integer> list = new ArrayList<>();
                st.push(index);
                while (!st.isEmpty()) {
                    int node = st.pop();
                    vis[node] = true;
                    list.add(node);
                    if (mp.containsKey(node)) {
                        List<Integer> temp = mp.get(node);
                        for (int element : temp) {
                            if (vis[element] && list.contains(element)) return true;
                            st.add(element);
                        }

                    }

                }
            }


        }


        return false;
    }
}
