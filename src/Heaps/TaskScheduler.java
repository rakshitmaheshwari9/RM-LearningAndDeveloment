package Heaps;

import java.util.*;

public class TaskScheduler {

    public static void main(String[] args) {
        System.out.println("Rahul khichar");
        char[] tasks = {'A', 'A', 'A', 'A', 'A', 'A','B','C','D','E','F','G'};
        int n = 2;

        TaskScheduler taskScheduler = new TaskScheduler();
        System.out.println(taskScheduler.leastInterval(tasks, n));

    }


    public int leastInterval(char[] tasks, int n) {

        Map<Character, Integer> mp = new HashMap<>();
        for (int i = 0; i < tasks.length; i++) {

            char charFind = tasks[i];
            if (mp.containsKey(charFind)) {
                mp.put(charFind, mp.get(charFind) + 1);
            } else {
                mp.put(charFind, 1);
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        for (int number : mp.values()) {
            pq.add(number);
        }
        int ans = 0;
        int lastSize = 0;
        while (!pq.isEmpty()) {


            List<Integer> list = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                if (!pq.isEmpty()) {
                    list.add(pq.poll());
                }
                ans++;

            }
            lastSize = list.size();
            for (int number : list) {

                if (number != 1) {
                    pq.add(number - 1);
                }
            }
        }

        ans = ans - (n + 1 - lastSize);

        return ans;

    }

    public  int secondQuestion(char[] tasks,int n) {
        if (tasks == null || tasks.length == 0) {
            return 0;
        }

        Map<Character, Integer> frequencyMap = new HashMap<>();

        for (char task : tasks) {
            frequencyMap.put(task, frequencyMap.getOrDefault(task, 0) + 1);
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        maxHeap.addAll(frequencyMap.values());

        int cycles = 0;

        while (!maxHeap.isEmpty()) {
            int interval = n + 1;
            List<Integer> temp = new ArrayList<>();

            for (int i = 0; i < interval; i++) {
                if (!maxHeap.isEmpty()) {
                    temp.add(maxHeap.poll());
                }
            }

            for (int task : temp) {
                if (task > 1) {
                    maxHeap.offer(task - 1);
                }
            }

            cycles += maxHeap.isEmpty() ? temp.size() : interval;
        }

        return cycles;

    }
}
