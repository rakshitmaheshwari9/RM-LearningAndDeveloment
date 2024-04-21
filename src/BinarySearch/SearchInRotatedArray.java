package BinarySearch;

public class SearchInRotatedArray {

    public static int find(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;

        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (target == nums[mid]) {
                return mid;
            }

            if (target <= nums[mid]) {
                if (nums[mid] >= target && nums[left] <= target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }

            } else {
                if (nums[mid] <= target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }


        }


        return -1;
    }

    public static void main(String[] args) {
        System.out.println("Rahul khichar");
    }
}
