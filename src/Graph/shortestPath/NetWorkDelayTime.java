package Graph.shortestPath;

import java.util.*;

public class NetWorkDelayTime {

    public static void main(String[] args) {
        System.out.println("Rahul khichar");

        int times[][] = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}}, n = 4, k = 2;
        NetWorkDelayTime netWorkDelayTime = new NetWorkDelayTime();


        System.out.println(netWorkDelayTime.networkDelayTime(times, n, k));
    }


    public int networkDelayTime(int[][] times, int n, int k) {

        Map<Integer, List<Pair>> graph = new HashMap<>();

        for (int[] input : times) {
            int startTime = input[0];
            int endTime = input[1];
            int waitTime = input[2];
            List<Pair> tempList;
            if (graph.containsKey(startTime)) {
                tempList = graph.get(startTime);
            } else {
                tempList = new ArrayList<>();
            }
            tempList.add(new Pair(endTime, waitTime));
            graph.put(startTime, tempList);
        }


        int time[] = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            time[i] = Integer.MAX_VALUE;
        }
        time[k] = 0;
        Queue<Integer> queue = new LinkedList<>();

        queue.add(k);

        while (!queue.isEmpty()) {

            int p = queue.poll();
            if (graph.containsKey(p)) {

                for (Pair p2 : graph.get(p)) {

                    if (time[p2.value] > time[p] + p2.weight) {
                        time[p2.value] = time[p] + p2.weight;
                        queue.add(p2.value);
                    }

                }
            }

        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans, time[i]);
        }

        if (ans == Integer.MAX_VALUE) return -1;

        return ans;
    }

    class Pair {

        int value;
        int weight;

        Pair(int value, int weight) {
            this.value = value;
            this.weight = weight;
        }
    }
}
