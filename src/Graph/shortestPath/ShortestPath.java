package Graph.shortestPath;

import java.util.*;

public class ShortestPath {

    public static void main(String[] args) {
        System.out.println("Rahul khichar");

        int n = 5;
        int[][] input = {{0, 1}, {1, 4}, {2, 3}, {2, 4}, {3, 4}};
        int src = 1;

        int[] ans = shortestPath(n, input, src);
        for (int element : ans) {
            System.out.print(element + ",");
        }
    }


    public static int[] shortestPath(int n, int[][] edges, int src) {
        // Write your code here.
        int[] ans = new int[n];


        for (int i = 0; i < n; i++) {
            ans[i] = Integer.MAX_VALUE;
        }
        ans[src] = 0;
        Map<Integer, List<Integer>> adjList = new HashMap<>();

        for (int[] arr : edges) {
            int firstElement = arr[0];
            int secondElement = arr[1];

            List<Integer> firstList;

            if (adjList.containsKey(firstElement)) {
                firstList = adjList.get(firstElement);
            } else {
                firstList = new ArrayList<>();
            }
            firstList.add(secondElement);
            adjList.put(firstElement, firstList);

            List<Integer> secondList;

            if (adjList.containsKey(secondElement)) {
                secondList = adjList.get(secondElement);
            } else {
                secondList = new ArrayList<>();
            }
            secondList.add(firstElement);
            adjList.put(secondElement, secondList);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        while (!queue.isEmpty()) {
            int element = queue.poll();
            if (adjList.containsKey(element)) {
                for (int number : adjList.get(element)) {
                    if (ans[number] > ans[element] + 1) {
                        ans[number] = ans[element] + 1;
                        queue.add(number);
                    }
                }
            }


        }

        for (int i = 0; i < n; i++) {
            if (ans[i] == Integer.MAX_VALUE) {
                ans[i] = -1;
            }
        }


        return ans;
    }
}
