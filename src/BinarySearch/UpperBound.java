package BinarySearch;

public class UpperBound {
    public static int upperBound(int[] arr, int n, int x) {


        int left = 0;
        int right = n - 1;
        int ans = n;
        while (left <= right) {
            int mid = (right - left) / 2 + left;

            if (arr[mid] <= x) {

                left = mid + 1;
            } else {
                ans = mid;
                right = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 6, 10 };
        System.out.println(upperBound(arr, 5, 10));
        System.out.println("Rahul khichar");
    }
}
