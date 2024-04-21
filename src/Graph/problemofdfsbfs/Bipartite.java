package Graph.problemofdfsbfs;

import java.util.Stack;

public class Bipartite {

    public static void main(String[] args) {
        System.out.println("Rahul khichar");

        int[][] graph = {{1}, {0}, {4}, {4}, {2, 3}};
        Bipartite bipartite = new Bipartite();

        System.out.println(bipartite.isBipartite(graph));
    }


    public boolean isBipartite(int[][] graph) {

        int n = graph.length;
        int[] vis = new int[n];

        for (int i = 0; i < n; i++) {
            vis[i] = -1;
        }

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (vis[i] == -1) {

                stack.push(i);
                vis[i] = 1;


                while (!stack.isEmpty()) {

                    int node = stack.pop();
                    int value = vis[node];

                    for (int index = 0; index < graph[node].length; index++) {
                        int lastNode = graph[node][index];
                        if (vis[lastNode] == vis[node]) return false;

                        if (vis[lastNode] == -1) {
                            stack.add(lastNode);
                            if (value == 1) {
                                vis[lastNode] = 0;
                            } else {
                                vis[lastNode] = 1;
                            }
                        }
                    }
                }
            }


        }


        return true;

    }
}
