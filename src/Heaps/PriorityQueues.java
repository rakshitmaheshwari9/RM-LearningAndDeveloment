package Heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueues {


    public static void main(String[] args) {
        System.out.println("Rahul khichar");

        PriorityQueue<Task> pq = new PriorityQueue<>(new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                return 1;
            }
        });

        PriorityQueue<Task> p2 = new PriorityQueue<>((t1, t2) -> Integer.compare(t1.a, t2.a));
        PriorityQueue<Task> p3 = new PriorityQueue<>((t1, t2) -> {
            return 1;
        });

    }

    static class Task {

        int a;
        int b;

        Task(int a, int b) {
            this.a = a;
            this.b = b;
        }

    }

}
