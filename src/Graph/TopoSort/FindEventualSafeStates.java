package Graph.TopoSort;

import java.util.*;

public class FindEventualSafeStates {

    public static void main(String[] args) {
        System.out.println("Rahul khichar");

        int[][] graph = {{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}};
        FindEventualSafeStates findEventualSafeStates = new FindEventualSafeStates();
        List<Integer> ans = findEventualSafeStates.eventualSafeNodes(graph);

        for (int number : ans) {
            System.out.println(ans);
        }
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ans = new ArrayList<>();
        int n = graph.length;
        int inDegree[] = new int[n];
        Map<Integer, List<Integer>> mp = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int index = 0; index < graph.length; index++) {
            int[] tempArray = graph[index];
            for (int element : tempArray) {
                List<Integer> tempList;
                if (mp.containsKey(element)) {
                    tempList = mp.get(element);
                } else {
                    tempList = new ArrayList<>();
                }
                tempList.add(index);
                mp.put(element, tempList);
                inDegree[index]++;
            }
            if (inDegree[index] == 0) {
                queue.add(index);
            }
        }


        while (!queue.isEmpty()) {
            int node = queue.poll();
            ans.add(node);
            if (mp.containsKey(node)) {
                for (int element : mp.get(node)) {
                    inDegree[element]--;
                    if (inDegree[element] == 0) queue.add(element);
                }
            }
        }

        ans.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        return ans;

    }
}
