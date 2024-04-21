package BinarySearch;

public class MedianElementInSortedArray {

    public static double medianOfArray(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;


        int left = 0;
        int right = n - 1;
        int k = (n + m + 1) / 2;

        while (left <= right) {

            int mid = (right - left) / 2 + left;

            int l1 = mid;
            int r1 = l1 + 1;
            int l2 = k - l1 - 2;
            int r2 = l2 + 1;
//            int r1 = n - l1;
//            int r2 = m - l2;

            System.out.println(nums1[l1]);
            System.out.println(nums1[r1]);
            System.out.println(nums2[l2]);
            System.out.println(nums2[r2]);

        }


        return 0.0;
    }

    public static void main(String args[]) {

        int[] num1 = {1, 2, 7, 8, 9};
        int[] num2 = {3, 4, 10, 11, 12};
        System.out.println(medianOfArray(num1, num2));

        System.out.println("Rahul Khichar");
    }
}
