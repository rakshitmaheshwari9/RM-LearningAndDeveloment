package Heaps.HardProblem;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFinder {

    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        this.minHeap = new PriorityQueue<>();
        this.maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
    }

    public static void main(String[] args) {
        System.out.println("Rahul khichar");
//        MedianFinder medianFinder = new MedianFinder();
////        medianFinder.M
////        medianFinder.MedianFinder();
//        medianFinder.addNum(-1);
//        System.out.println(medianFinder.findMedian());
//        medianFinder.addNum(-2);
//        System.out.println(medianFinder.findMedian());
//        medianFinder.addNum(-3);
//        System.out.println(medianFinder.findMedian());
//        medianFinder.addNum(-4);
//        System.out.println(medianFinder.findMedian());
//        medianFinder.addNum(-5);
//        System.out.println(medianFinder.findMedian());

        secondSolution();

    }

    public static void secondSolution() {
        int numbers[] = {-1, -2, -3, -4, -5};

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int number : numbers) {
            if (maxHeap.isEmpty()) {
                maxHeap.add(number);
            } else if (number < maxHeap.peek()) {
                maxHeap.add(number);
            } else {
                minHeap.add(number);
            }
            if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.add(maxHeap.poll());
            }

            if (minHeap.size() > maxHeap.size() + 1) {
                maxHeap.add(minHeap.poll());
            }

            if (maxHeap.size() == minHeap.size()) {
                System.out.println((double) (maxHeap.peek() + minHeap.peek()) / 2);
            } else if (maxHeap.size() > minHeap.size()) {
                System.out.println(maxHeap.peek());
            } else {
                System.out.println(minHeap.peek());
            }
        }

//        while (!maxHeap.isEmpty()) {
////            System.out.println(minHeap.poll());
//            System.out.println(maxHeap.poll());
//        }
    }

    public void addNum(int num) {
        if (maxHeap.isEmpty()) {
            maxHeap.add(num);
        } else if (num < maxHeap.peek()) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.poll());
        }

        if (minHeap.size() > maxHeap.size() + 1) {
            maxHeap.add(minHeap.poll());
        }
    }

    public double findMedian() {

        double ans;
        if (maxHeap.size() == minHeap.size()) {
            ans = (double) (maxHeap.peek() + minHeap.peek()) / 2;
        } else if (maxHeap.size() > minHeap.size()) {
            ans = maxHeap.peek();
//            System.out.println(maxHeap.peek());
        } else {
            ans = minHeap.peek();
//            System.out.println(minHeap.peek());
        }

        return ans;
    }
}
