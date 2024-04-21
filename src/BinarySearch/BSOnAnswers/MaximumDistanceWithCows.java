package BinarySearch.BSOnAnswers;

import java.util.Arrays;

public class MaximumDistanceWithCows {

    public static int maximumDistanceWithCows(int[] stalls, int k) {


        int ans = 1;

        Arrays.sort(stalls);
        int n = stalls.length;

        int min = 1;
        int max = stalls[n - 1] - stalls[0];
//        for (int i = 0; i < stalls.length; i++) {
//            System.out.println(stalls[i] + " ");
//        }

        int left = min;
        int right = max;

        while (left <= right) {
            int i = (right - left) / 2 + left;
            int count = 1;
            int lastIndex = 0;
            for (int j = 1; j < n; j++) {
                if (stalls[j] - stalls[lastIndex] >= i) {
                    count++;
                    lastIndex = j;
                }
            }

            if (k <= count) {
                ans = i;
                left = i + 1;
            } else {
                right = i - 1;
            }
        }


        return ans;
    }

    public static void main(String[] args) {

        int[] stalles = {0, 3, 4, 7, 10, 9};
        int k = 4;

        System.out.println(maximumDistanceWithCows(stalles, k));
        System.out.println("Rahul khichar");
    }
}
