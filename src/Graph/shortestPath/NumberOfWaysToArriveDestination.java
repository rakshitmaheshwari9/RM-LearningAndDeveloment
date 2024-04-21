package Graph.shortestPath;

import java.util.*;

public class NumberOfWaysToArriveDestination {

    public static void main(String[] args) {
        System.out.println("Rahul khichar");

        int n = 7;

        int[][] roads = {{0, 6, 7}, {0, 1, 2}, {1, 2, 3}, {1, 3, 3}, {6, 3, 3}, {3, 5, 1}, {6, 5, 1}, {2, 5, 1}, {0, 4, 5}, {4, 6, 2}};

        NumberOfWaysToArriveDestination numberOfWaysToArriveDestination = new NumberOfWaysToArriveDestination();
        numberOfWaysToArriveDestination.countPaths(n, roads);


    }

    public int countPaths(int n, int[][] roads) {

        long time[] = new long[n];

        int ways[] = new int[n];
        ways[0] = 1;

        for (int i = 1; i < n; i++) {
            time[i] = Long.MAX_VALUE;
        }

        time[0] = 0;

        Map<Integer, List<Pair>> adjMap = new HashMap<>();

        for (int[] road : roads) {
            int start = road[0];
            int end = road[1];
            long weight = road[2];

            List<Pair> startToEnd;
            if (adjMap.containsKey(start)) {
                startToEnd = adjMap.get(start);
            } else {
                startToEnd = new ArrayList<>();
            }
            startToEnd.add(new Pair(end, weight));
            adjMap.put(start, startToEnd);

            List<Pair> endToStart;
            if (adjMap.containsKey(end)) {
                endToStart = adjMap.get(end);
            } else {
                endToStart = new ArrayList<>();
            }
            endToStart.add(new Pair(start, weight));
            adjMap.put(end, endToStart);
        }

        PriorityQueue<Pair> queue = new PriorityQueue<>(
                new Comparator<Pair>() {

                    @Override
                    public int compare(Pair o1, Pair o2) {
                        return (int) (o1.time - o2.time);
                    }
                }
        );

        queue.add(new Pair(0, 0L));

        int mod = (int) Math.pow(10, 9) + 7;

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();

            if (adjMap.containsKey(pair.node)) {
                for (Pair p : adjMap.get(pair.node)) {
                    int endNode = p.node;
                    Long weight = p.time;

                    if (time[endNode] > time[pair.node] + weight) {
                        time[endNode] = time[pair.node] + weight; // Corrected this line
                        queue.add(new Pair(endNode, time[endNode]));
                        ways[endNode] = ways[pair.node];
                    } else if (time[endNode] == time[pair.node] + weight) {
                        ways[endNode] = (ways[endNode] + ways[pair.node]) % mod;
                    }
                }
            }
        }

        return ways[n - 1];
    }

    class Pair {

        int node;
        long time;

        Pair(int noe, long time) {
            this.node = noe;
            this.time = time;

        }


    }
}
