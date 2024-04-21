package ArrayProblems;

import java.util.*;

public class MinimumArrayWithPair {

    public static void main(String[] args) {
        System.out.println("Rahul khichar");

        int[] nums1 = {1, 7, 11};
        int[] nums2 = {2, 4, 6};
        int k = 3;

        Map<Integer, List<List<Integer>>> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                int sum = nums1[i] + nums2[j];

                if (!map.containsKey(sum)) {
                    List<Integer> tempList = new ArrayList<>();
                    tempList.add(nums1[i]);
                    tempList.add(nums2[j]);
                    List<List<Integer>> tempItemList = new ArrayList<>();
                    tempItemList.add(tempList);
                    map.put(sum, tempItemList);

                } else {
                    List<Integer> tempList = new ArrayList<>();
                    tempList.add(nums1[i]);
                    tempList.add(nums2[j]);
                    List<List<Integer>> tempItemList = map.get(sum);
                    tempItemList.add(tempList);
                    map.put(sum, tempItemList);
                }
                pq.add(nums2[j] + nums1[i]);
                if (pq.size() > 3) {
                    pq.poll();
                }

            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        while (!pq.isEmpty()) {

            int item = pq.poll();
            for (int i = 0; i < map.get(item).size(); i++) {
                ans.add(map.get(item).get(i));
            }
        }

        for (int i = 0; i < ans.size(); i++) {
            System.out.println("(" + ans.get(i).get(0) + "," + ans.get(i).get(1) + ")");
        }
    }
}
