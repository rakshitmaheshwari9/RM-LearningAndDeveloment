package Greedy.MediamAndHard;

import java.util.Arrays;
import java.util.Comparator;

public class JobScheduling {

    public static void main(String[] args) {
        System.out.println("Rahul khichar");


        Job[] jobs = {new Job(1, 2, 100), new Job(2, 1, 19), new Job(3, 2, 27), new Job(4, 1, 25), new Job(5, 1, 15)};
        int[] ans = secondSolution(jobs, 5);

        for (int number : ans) {
            System.out.println(number);
        }


    }

    public static int[] JobScheduling(Job arr[], int n) {

        Arrays.sort(arr, new Comparator<Job>() {
            @Override
            public int compare(Job o1, Job o2) {
                if (o1.profit == o2.profit)
                    return o1.deadline > o2.deadline ? 1 : -1;
                else return o1.profit < o2.profit ? 1 : -1;
            }
        });
        int count = 0;
        int profit = 0;

        for (int index = 0; index < arr.length; index++) {
            if (n >= arr[index].deadline) {
                count++;
                n -= arr[index].deadline;
                profit += arr[index].profit;
            }
        }
        return new int[]{count, profit};
    }


    public static int[] secondSolution(Job arr[], int n) {

        Arrays.sort(arr, new Comparator<Job>() {
            @Override
            public int compare(Job o1, Job o2) {
                if (o1.profit == o2.profit)
                    return o1.deadline > o2.deadline ? 1 : -1;
                else return o1.profit < o2.profit ? 1 : -1;
            }
        });
        int count = 0;
        int profit = 0;

        int array[] = new int[n + 1];
        for (int i = 1; i < n; i++) {
            array[i] = -1;
        }

        for (int index = 0; index < arr.length; index++) {

            int deadLine = arr[index].deadline;

            for (int j = Math.min(deadLine, n); j >= 1; j--) {
                if (array[j] == -1) {
                    count++;
                    profit += arr[index].profit;
                    array[j] = arr[index].id;
                    break;
                }
            }
        }
        return new int[]{count, profit};
    }

    static class Job {
        int id, profit, deadline;

        Job(int x, int y, int z) {
            this.id = x;
            this.deadline = y;
            this.profit = z;
        }
    }
}
