package BinarySearch.BSOnAnswers;

import java.util.ArrayList;

public class PartitionProblem {


    public static int findLargestMinDistanceOptimise(ArrayList<Integer> boards, int k) {
        int ans = -1;


        int sum = 0;
        int max = Integer.MIN_VALUE;


        for (int board : boards) {
            max = Math.max(max, board);
            sum += board;
        }
        if (boards.size() == k) {
            return max;
        }


        while (max <= sum) {
            int mid = (sum - max) / 2 + max;
            int tempSum = 0;
            int count = 1;
            for (int board : boards) {

                if (tempSum + board <= mid) {
                    tempSum += board;

                } else {
                    tempSum = board;
                    count++;
                }

            }


            if (count <= k) {
                ans= mid;
                sum=mid-1;
            } else {
                max=mid+1;
            }
        }


        return ans;
    }

    public static int findLargestMinDistance(ArrayList<Integer> boards, int k) {
        int ans = -1;


        int sum = 0;
        int max = Integer.MIN_VALUE;


        for (int board : boards) {
            max = Math.max(max, board);
            sum += board;
        }
        if (boards.size() == k) {
            return max;
        }

        for (int mid = max; mid <= sum; mid++) {
            int tempSum = 0;
            int count = 1;
            for (int board : boards) {

                if (tempSum + board <= mid) {
                    tempSum += board;

                } else {
                    tempSum = board;
                    count++;
                }

            }


            if (count <= k) {
                return mid;
            }
        }

        return ans;
    }

    public static void main(String[] args) {


        ArrayList<Integer> arrayList = new ArrayList<>();
//10 7
//6 2 1 3 4 7 4 6 1 1
//        4 2
//        10 20 30 40
        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(30);
        arrayList.add(40);
//        arrayList.add(4);
//        arrayList.add(7);
//        arrayList.add(4);
//        arrayList.add(6);
//        arrayList.add(1);
//        arrayList.add(1);

//        4 2
//        10 20 30 40

        System.out.println(findLargestMinDistance(arrayList, 2));
        System.out.println(findLargestMinDistanceOptimise(arrayList, 2));
        System.out.println("Rahul Khichar");
    }
}
