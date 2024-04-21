package BinarySearch;

public class RotatedArraySearch {

    public static int pivotIndex(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }

        int n = nums.length;


        int ans = n - 1;
        int left = 0;
        int right = n - 1;

        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if ((mid - 1 >= 0 && mid + 1 <= n - 1) && nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (mid == 0 && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (mid == n - 1 && nums[mid] < nums[mid - 1]) {
                return mid - 1;
            } else if (nums[mid] >= nums[left]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }


        return ans;
    }

    public static int binarySearch(int[] nums, int target, int leftIndex, int rightIndex) {
        int ans = -1;

        while (leftIndex <= rightIndex) {
            int mid = (rightIndex - leftIndex) / 2 + leftIndex;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                rightIndex = mid - 1;
            } else {
                leftIndex = mid + 1;
            }
        }

        return ans;
    }

    public static int search(int[] nums, int target) {
        int ans = -1;

        int pivotIndex = pivotIndex(nums);
        System.out.println(pivotIndex);
        int n = nums.length;

        if (target >= nums[0] && target <= nums[pivotIndex]) {
            return binarySearch(nums, target, 0, pivotIndex);
        } else if (pivotIndex < n - 1 && target >= nums[pivotIndex + 1] && target <= nums[n - 1]) {
            return binarySearch(nums, target, pivotIndex + 1, n - 1);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {3, 1};
//        System.out.println(pivotIndex(nums));
        System.out.println(search(nums, 1));
        System.out.println();
        System.out.println("Here we are searching in Rotated Array Rahul khichar");
    }
}
