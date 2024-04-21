package Graph.TopoSort;

import java.util.*;

public class CourseScheduleTwo {

    public static void main(String[] args) {
        System.out.println("Rahul khichar");
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];

        Map<Integer, List<Integer>> adjList = new HashMap<>();

        for (int inputArry[] : prerequisites) {
            int startNode = inputArry[0];
            int endNode = inputArry[1];
            inDegree[endNode]++;
            List<Integer> insertList;

            if (adjList.containsKey(startNode)) {
                insertList = adjList.get(startNode);
            } else {
                insertList = new ArrayList<>();
            }
            insertList.add(endNode);
            adjList.put(startNode, insertList);
        }
        Queue<Integer> qa = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                qa.add(i);
            }
        }

        List<Integer> ansList = new ArrayList<>();
        while (!qa.isEmpty()) {

            int node = qa.poll();
            ansList.add(node);
            if (adjList.containsKey(node)) {
                for (int element : adjList.get(node)) {
                    inDegree[element]--;
                    if (inDegree[element] == 0) {
                        qa.add(element);
                    }

                }
            }

        }


        int[] ans;

        if (ansList.size() != numCourses) ans = new int[0];
        else {
            ans = new int[numCourses];

            for (int index = 0; index < numCourses; index++) {
                ans[index] = ansList.get(index);
            }
        }

        return ans;

    }
}
