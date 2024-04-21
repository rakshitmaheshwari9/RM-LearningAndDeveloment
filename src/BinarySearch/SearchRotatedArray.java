package BinarySearch;

public class SearchRotatedArray {
//   1,1,1,1,1,1,8,0

    public static int pivotPoint2(int[] nums, int left, int right) {
        if (left == right) {
            return left;
        }

        if (nums[left] > nums[left + 1]) {
            return left;
        }

        if (right != 0 && nums[right] < nums[right - 1]) {
            return right - 1;
        }

        int mid = (right - left) / 2 + left;

        if (mid - 1 == -1) {
            if (nums[mid] > nums[mid + 1]) {
                return mid;
            } else {
                return pivotPoint2(nums, mid + 1, right);
            }
        }
        if (mid >= right) {
            if (nums[mid] > nums[mid - 1]) {
                return mid;
            } else {
                return pivotPoint2(nums, left, mid - 1);
            }
        }

        if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
            return mid;
        } else if (nums[mid] > nums[left]) {
            return pivotPoint2(nums, mid + 1, right);
        } else if (nums[mid] < nums[right]) {
            return pivotPoint2(nums, left, mid - 1);
        } else {

            int l = pivotPoint2(nums, left, mid - 1);
            int r = pivotPoint2(nums, mid + 1, right);
            if (l != -1) {
                return l;
            } else if (r != -1) {
                return r;
            }
            return -1;
        }

    }

    public static int pivotPoint(int[] nums) {

        if (nums.length == 1) {
            return 0;
        }

        if (nums[0] > nums[1]) {
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

    public static void main(String[] args) {

        int[] nums = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1};
        int n = nums.length;

        int left = 0;
        int right = n - 1;

        System.out.println(pivotPoint2(nums, left, right));

        System.out.println(pivotPoint(nums));
        System.out.println("Rahul khichar");
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
}
