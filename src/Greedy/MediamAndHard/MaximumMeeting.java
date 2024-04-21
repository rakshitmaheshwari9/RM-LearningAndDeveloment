package Greedy.MediamAndHard;


import java.util.Comparator;
import java.util.PriorityQueue;

public class MaximumMeeting {

    public static void main(String[] args) {
        System.out.println("Rahul khichar");

        int N = 6,
                start[] = {1, 3, 0, 5, 8, 5},
                end[] = {2, 4, 6, 7, 9, 9};
        System.out.println(maxMeetings(start, end, N));
    }


    public static int maxMeetings(int start[], int end[], int n) {
        // add your code here

        PriorityQueue<Pair> pairPriorityQueue = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.end > o2.end ? 1 : -1;
            }
        });
        for (int index = 0; index < n; index++) {
            pairPriorityQueue.add(new Pair(start[index], end[index]));
        }

        int lastEnd = pairPriorityQueue.poll().end;
        int ans = 1;

        while (!pairPriorityQueue.isEmpty()) {
            Pair currentTime = pairPriorityQueue.poll();
            if (currentTime.start > lastEnd) {
                ans++;
                lastEnd = currentTime.end;
            }
        }

        return ans;
    }

    static class Pair {

        int start;
        int end;

        Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }

    }
}
