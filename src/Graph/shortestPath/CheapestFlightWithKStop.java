package Graph.shortestPath;

import java.util.*;

public class CheapestFlightWithKStop {

    public static void main(String[] args) {
        System.out.println("Rahul khichar");

        int n = 4, flights[][] = {{0, 1, 1}, {0, 2, 5}, {1, 2, 1}, {2, 3, 1}}, src = 0, dst = 3, k = 1;

        CheapestFlightWithKStop cheapestFlightWithKStop = new CheapestFlightWithKStop();

        System.out.println(cheapestFlightWithKStop.findCheapestPrice(n, flights, src, dst, k));

    }


    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        Map<Integer, List<Pair>> hashMap = new HashMap<>();


        int[][] dp = new int[n][n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }


        dp[src][0] = 0;


        for (int flight[] : flights) {
            int startPoint = flight[0];
            int endPoint = flight[1];
            int value = flight[2];
            List<Pair> list;
            if (hashMap.containsKey(startPoint)) {
                list = hashMap.get(startPoint);
            } else {
                list = new ArrayList<>();
            }
            list.add(new Pair(endPoint, value));
            hashMap.put(startPoint, list);
        }

        Queue<Pair> queue = new LinkedList<>();
        if (hashMap.containsKey(src)) {
            for (Pair p : hashMap.get(src)) {
                queue.add(p);
                dp[p.node][1] = p.weight;
            }
        }

        int step = 2;

        while (!queue.isEmpty()) {

            int sizeOfQueue = queue.size();
            for (int inde = 0; inde < sizeOfQueue; inde++) {


                Pair p = queue.poll();

                if (hashMap.containsKey(p.node)) {

                    for (Pair toPair : hashMap.get(p.node)) {

                        if (dp[toPair.node][step] > dp[p.node][step - 1] + toPair.weight) {
                            dp[toPair.node][step] = dp[p.node][step - 1] + toPair.weight;
                            queue.add(toPair);
                        }
                    }

                }

            }
            step++;

        }


        int ans = Integer.MAX_VALUE;

        for (int j = 0; j <= k + 1; j++) {
            ans = Math.min(ans, dp[dst][j]);
        }

        if (ans == Integer.MAX_VALUE) return -1;
        return ans;

    }

    public class Pair {
        int node;
        int weight;

        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

}
