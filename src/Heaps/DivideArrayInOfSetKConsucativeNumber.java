package Heaps;

import java.util.*;

public class DivideArrayInOfSetKConsucativeNumber {

    public static void main(String[] args) {
        System.out.println("Rahul khichar");

        DivideArrayInOfSetKConsucativeNumber divideArrayInOfSetKConsucativeNumber = new DivideArrayInOfSetKConsucativeNumber();
        int[] nums = {1,2,3,4};
        int k = 3;
        System.out.println(divideArrayInOfSetKConsucativeNumber.isPossibleDivide(nums,k));
    }

    public boolean isPossibleDivide(int[] nums, int k) {

        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int number : nums) {
            frequencyMap.put(number, frequencyMap.getOrDefault(number, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int number : frequencyMap.keySet()) {
            pq.add(number);
        }

        while (!pq.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < k; i++) {
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


        return true;


    }
}
