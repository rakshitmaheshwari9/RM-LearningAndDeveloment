package Heaps.HardProblem;


import java.util.Comparator;
import java.util.PriorityQueue;

class KthLargest {

    PriorityQueue<Integer> pq;
    int size = 0;

    public KthLargest(int k, int[] nums) {
        this.pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        this.size = k;

        for (int number : nums) {
            pq.add(number);
            if (pq.size() > this.size) {
                pq.poll();
            }
        }

    }

    public int add(int val) {
        pq.add(val);
        if (pq.size() > this.size) pq.poll();

        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */