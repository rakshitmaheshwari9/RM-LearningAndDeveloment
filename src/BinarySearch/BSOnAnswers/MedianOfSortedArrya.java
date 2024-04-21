package BinarySearch.BSOnAnswers;

public class MedianOfSortedArrya {

    public static double medianOfSortedArray(int[] nums1, int[] nums2) {

        double d = 1.000;
        int n = nums1.length;
        int m = nums2.length;

        int[] ans = new int[n + m];
        int first = 0;
        int second = 0;
        int k = 0;
        while (first < n && second < m) {
            if (nums1[first] <= nums2[second]) {
                ans[k] = nums1[first];
                k++;
                first++;
            } else {
                ans[k] = nums2[second];
                k++;
                second++;
            }
        }

        while (first < n) {
            ans[k] = nums1[first];
            k++;
            first++;
        }

        while (second < m) {
            ans[k] = nums2[second];
            k++;
            second++;
        }

        int t = (n + m) / 2;
        double mid;
        if ((n + m) % 2 == 0) {

            mid = (double) (ans[t] + ans[t - 1]) / 2;
        } else {
            mid = (double) (ans[t]);
        }
        return mid;

    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        System.out.println(medianOfSortedArray(nums1, nums2));
        System.out.println("Rahul khichar");
    }
}
