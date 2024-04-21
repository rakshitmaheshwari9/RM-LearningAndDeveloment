package BinarySearch;

public class SearchRange {


    public static void main(String[] args) {

        System.out.println("Rahul khichar");
        int[] arr = {5, 7, 7, 8, 8, 10};
        int x = 8;
        int[] ans = searchRange(arr, x);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ,");
        }
    }

    public static int lowerBound(int[] arr, int x) {

        int ans = -1;
        int n = arr.length;
        int left = 0;
        int right = n - 1;
        while (left <= right) {

            int mid = (right - left) / 2 + left;
            if (arr[mid] == x) {
                ans = mid;
                right = mid - 1;
            } else if (arr[mid] < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }

    public static int upperBound(int[] arr, int x) {
        int ans = -1;
        int n = arr.length;
        int left = 0;
        int right = n - 1;
        while (left <= right) {

            int mid = (right - left) / 2 + left;
            if (arr[mid] == x) {
                ans = mid;
                left = mid + 1;
            } else if (arr[mid] < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }

    public static int[] searchRange(int[] arr, int x) {
        int[] ans = {lowerBound(arr, x), upperBound(arr, x)};
        return ans;
    }
}
