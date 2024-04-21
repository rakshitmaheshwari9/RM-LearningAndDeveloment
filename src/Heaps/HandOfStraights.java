package Heaps;

import java.util.*;

public class HandOfStraights {

    public static void main(String[] args) {
        System.out.println("Rahul khichar");

        HandOfStraights handOfStraights = new HandOfStraights();

        int[] hand = {1,2,3,4,5,6};
        int groupSize = 2;
        System.out.println(handOfStraights.isNStraightHand(hand, groupSize));


    }

    public boolean isNStraightHand(int[] hand, int groupSize) {

        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int number : hand) {
            frequencyMap.put(number, frequencyMap.getOrDefault(number, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int number : frequencyMap.keySet()) {
            pq.add(number);
        }
        int loop = 0;

        while (!pq.isEmpty()) {
            loop++;
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < groupSize; i++) {
                if (pq.isEmpty()) return false;
                list.add(pq.poll());
                if (i > 0) {
                    if (list.get(i - 1) + 1 != list.get(i)) return false;
                }
            }

            for (int number : list) {
                frequencyMap.put(number, frequencyMap.get(number) - 1);
                if (frequencyMap.get(number) > 0) {
                    pq.add(number);
                }
            }
        }

        if (loop != groupSize) return false;


        return true;
    }
}
