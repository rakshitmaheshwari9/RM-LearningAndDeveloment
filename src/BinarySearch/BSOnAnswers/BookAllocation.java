package BinarySearch.BSOnAnswers;

import java.util.ArrayList;

public class BookAllocation {


    public static int findPage(ArrayList<Integer> arr, int n, int m) {
        int ans = -1;

        int sum = 0;
        int min = 0;


        for (int i = 0; i < n; i++) {
            sum += arr.get(i);
            min = Math.max(min, arr.get(i));
        }
        if (n == m) {
            return min;
        }

        int left = min;
        int right = sum;

        while (left <= right) {

            int mid = (right - left) / 2 + left;

            int tempSum = 0;
            int count = 0;
            for (int i = 0; i < n; i++) {
                tempSum += arr.get(i);
                if (tempSum >= mid) {
                    count++;
                    tempSum = arr.get(i);
                }
            }

            if (count >= m) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }


        return ans;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();

//        4 2
//        12 34 67 90
        arrayList.add(12);
        arrayList.add(34);
        arrayList.add(67);
        arrayList.add(90);


        System.out.println(findPage(arrayList, 4, 2));


        System.out.println("Rahul khichar");
    }
}
