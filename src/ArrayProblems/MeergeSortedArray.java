package ArrayProblems;

public class MeergeSortedArray {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = n + m - 1;
        m--;
        n--;


        while (m >= 0 && n >= 0) {

            if (nums2[n] >= nums1[m]) {
                nums1[k] = nums2[n];
                n--;
                k--;
            } else {
                nums1[k] = nums1[m];
                m--;
                k--;
            }
        }
        while (m >= 0) {
            nums1[k] = nums1[m];
            m--;
            k--;
        }
        while (n >= 0) {
            nums1[k] = nums2[n];
            n--;
            k--;
        }
    }

    public static void main(String[] args) {

        int num1[] = {1, 2, 3, 0, 0, 0};
        int num2[] = {2, 5, 6};
        int m = 3;
        int n = 3;
        merge(num1, m, num2, n);

        for (int i = 0; i < num1.length; i++) {
            System.out.println(num1[i] + " ");
        }
        System.out.println("Rahul khichar");
    }
}
