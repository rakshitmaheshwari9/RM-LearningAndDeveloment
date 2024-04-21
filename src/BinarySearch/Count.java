package BinarySearch;

public class Count {

    public static void main(String[] args) {
        System.out.println("rahul khichar");

        int[] nums = {1, 1, 1, 2, 2, 3, 3};
        int x = 1;
        System.out.println(count(nums, x));
    }


    public static int lowerBound(int[] nums, int x) {
        int ans = -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {

            int mid = (right - left) / 2 + left;
            if (nums[mid] == x) {
                ans = mid;
                right = mid - 1;
            } else if (nums[mid] > x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    public static int upperBound(int[] nums, int x) {
        int ans = -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {

            int mid = (right - left) / 2 + left;
            if (nums[mid] == x) {
                ans = mid;
                left = mid + 1;
            } else if (nums[mid] > x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    public static int count(int[] nums, int x) {

        int a = upperBound(nums, x);
        int b = lowerBound(nums, x);
        return (a - b+1);
    }
}
