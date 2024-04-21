package Graph.shortestPath;

import java.util.*;

public class Dijkstra {

    public static void main(String[] args) {
        System.out.println("Rahul khichar");
        int vertices = 5;
        int edges = 7;
        int source = 0;

        int edge[][] = {{0, 1, 7},
                {0, 2, 1},
                {0, 3, 2},
                {1, 2, 3},
                {1, 3, 5},
                {1, 4, 1},
                {3, 4, 7}};

        List<Integer> ans = dijkstra(edge, vertices, edges, source);

        for (int number : ans) {
            System.out.print(number);
        }


    }

    public static List<Integer> dijkstra(int[][] edge, int vertices, int edges, int source) {

        Map<Integer, List<Pair>> graph = new HashMap<>();

        for (int[] input : edge) {

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

            if (graph.containsKey(toNode)) {
                list = graph.get(toNode);
            } else {
                list = new ArrayList<>();
            }

            list.add(new Pair(fromNode, weight));
            graph.put(toNode, list);


        }

        int[] dist = new int[vertices];
        for (int i = 1; i < vertices; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty()) {

            int fromElement = queue.poll();

            if (graph.containsKey(fromElement)) {
                for (Pair pair : graph.get(fromElement)) {

                    int toNode = pair.node;
                    int weight = pair.weight;

                    if (dist[toNode] > dist[fromElement] + weight) {
                        dist[toNode] = dist[fromElement] + weight;
                        queue.add(toNode);
                    }
                }
            }

        }


        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < vertices; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                ans.add(-1);
            } else {
                ans.add(dist[i]);
            }
        }
        return ans;
    }

    public static class Pair {

        int node;
        int weight;

        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }
}
