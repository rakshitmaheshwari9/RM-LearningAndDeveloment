package Graph.shortestPath;

import java.util.*;

public class ShortedPathInDirectedGraph {

    public static void main(String[] args) {
        System.out.println("Rahul khichar");

        int n = 4;
        int m = 4;

        int input[][] = {{2, 1, 5},
                {0, 2, 3},
                {0, 1, 2},
                {2, 3, 1}};

        int[] ans = shortestPathInDAG(n, m, input);
        for (int number : ans) {
            System.out.print(number);
        }
    }

    public static int[] shortestPathInDAG(int n, int m, int[][] edges) {
        // Write your code here
        int[] ans = new int[n];

        for (int i = 1; i < n; i++) {
            ans[i] = Integer.MAX_VALUE;
        }

        Map<Integer, List<Pair>> graph = new HashMap<>();

        for (int[] input : edges) {
            int fromNode = input[0];
            int toNode = input[1];
            int weight = input[2];
            List<Pair> list;
            if (graph.containsKey(fromNode)) {
                list = graph.get(fromNode);
            } else {
                list = new ArrayList<>();
            }
            list.add(new Pair(toNode, weight));
            graph.put(fromNode, list);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);

        while (!queue.isEmpty()) {
            int fromNode = queue.poll();

            if (graph.containsKey(fromNode)) {

                for (Pair pair : graph.get(fromNode)) {
                    int toNode = pair.node;
                    int weight = pair.value;
                    if (ans[toNode] > ans[fromNode] + weight) {
                        ans[toNode] = ans[fromNode] + weight;
                        queue.add(toNode);
                    }
                }
            }
        }

        for (int i = 1; i < n; i++) {
            if (ans[i] == Integer.MAX_VALUE) {
                ans[i] = -1;
            }
        }
        return ans;
    }


    public static class Pair {
        int node;
        int value;

        Pair(int node, int value) {
            this.node = node;
            this.value = value;
        }
    }
}
