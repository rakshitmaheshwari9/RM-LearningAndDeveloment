package Graph.Learning;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class bfsGraph {

    public static void main(String[] args) {
        System.out.println("Rahul khichar");
    }

    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {

        ArrayList<Integer> ans = new ArrayList<>();
        boolean vis[] = new boolean[V];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);

        while (!queue.isEmpty()) {

            int n = queue.size();

            for (int i = 0; i < n; i++) {

                int node = queue.poll();
                if (!vis[node]) {
                    vis[node] = true;
                    ans.add(node);

                    ArrayList<Integer> list = adj.get(node);

                    for (int index = 0; index < list.size(); index++) {

                        if (!vis[adj.get(node).get(index)]) {
                            queue.add(adj.get(node).get(index));
                        }
                    }
                }


            }

        }


        return ans;
        // Code here
    }
}
