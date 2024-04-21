package Greedy.MediamAndHard;

import java.util.*;

public class ShortestJobFirst {

    public static void main(String[] args) {
        System.out.println("Rahul khichar");

        int n = 10;


        int[] arrivalTime = {9, 26, 29, 25, 22, 4, 24, 29, 10, 11};
        int[] burstTime = {12, 29, 11, 14, 3, 21, 6, 28, 29, 7};
        float ans = secondSolution(n, arrivalTime, burstTime);
        System.out.println(ans);

    }


    /**
     * Shortest Job First (SJF) algorithm implementation.
     * <p>
     * Shortest Job First is an algorithm in which the process having the smallest execution (burst) time is chosen for the next execution. Here, you will implement a non-preemptive version (a process will wait until process(es) with shorter burst time execute). You have to return the average waiting time for the given number of processes.
     *
     * @param n           the number of processes
     * @param arrivalTime an array containing arrival times of processes
     * @param burstTime   an array containing burst times of processes
     * @return the average waiting time for the given number of processes
     * @since 1.8
     */
    public static float sjf(int n, int[] arrivalTime, int[] burstTime) {
        // Write your code here.

        int waitingTime[] = new int[n];

        Arrays.sort(burstTime);

        waitingTime[0] = 0;
        int totalTime = 0;


        for (int index = 0; index < n - 1; index++) {

            waitingTime[index + 1] = waitingTime[index] + burstTime[index];
            totalTime += waitingTime[index + 1];
        }


        return (float) totalTime / n;
    }


    public static float secondSolution(int n, int[] arrivalTime, int[] burstTime) {
        // Write your code here.


        List<process> processes = new ArrayList<>();
        for (int index = 0; index < n; index++) {
            processes.add(new process(index + 1, arrivalTime[index], burstTime[index]));
        }

        processes.sort(new Comparator<process>() {
            @Override
            public int compare(process o1, process o2) {
                return o1.arrivalTime > o2.arrivalTime ? 1 : -1;
            }
        });


        PriorityQueue<process> pq = new PriorityQueue<>(new Comparator<process>() {
            @Override
            public int compare(process o1, process o2) {
                return o1.burstTime > o2.burstTime ? 1 : -1;
            }
        });

        int completedProcess = 0;
        int currentTime = 0;

        int waitingTime = 0;


        while (completedProcess < n) {


            while (!processes.isEmpty() && processes.get(0).arrivalTime <= currentTime) {
                pq.add(processes.remove(0));
            }

            if (!pq.isEmpty()) {
                process p = pq.poll();
                waitingTime += (currentTime - p.arrivalTime);
                currentTime += p.burstTime;
                completedProcess++;

            } else {
                currentTime = processes.get(0).arrivalTime;
            }

        }
//        int waitingTime[] = new int[n];
//
//        Arrays.sort(burstTime);
//
//        waitingTime[0] = 0;
//        int totalTime = 0;
//
//
//        for (int index = 0; index < n - 1; index++) {
//
//            waitingTime[index + 1] = waitingTime[index] + burstTime[index];
//            totalTime += waitingTime[index + 1];
//        }
//
//
        return (float) waitingTime / n;

//        return (float) 10.90;
    }

    public static class process {
        int index;
        int arrivalTime;
        int burstTime;

        process(int index, int arrivalTime, int burstTime) {
            this.index = index;
            this.arrivalTime = arrivalTime;
            this.burstTime = burstTime;
        }
    }
}
