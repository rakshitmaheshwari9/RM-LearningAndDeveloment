package BinarySearch;

public class LowerBound {


    public static int lowerBound(int[] arr, int n, int x) {


        int left = 0;
        int right = n - 1;
        int ans = n;
        while (left <= right) {
            int mid = (right - left) / 2 + left;

            if (arr[mid] <x) {
                left = mid + 1;
            } else {
                ans = mid;
                right = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3};
        System.out.println(lowerBound(arr, 4, 0));
        System.out.println("Rahul khichar");
    }
}