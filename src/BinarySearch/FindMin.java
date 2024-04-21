package BinarySearch;

public class FindMin {

    public static int findMin(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        } else if (n == 2) {
            return Math.min(nums[0], nums[1]);
        } else if (nums[n - 1] > nums[0]) {
            return nums[0];
        } else if (nums[n - 1] < nums[n - 2]) {
            return nums[n - 1];
        }

        int left = 0;
        int right = n - 1;

        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (mid != 0 && nums[mid - 1] > nums[mid] && nums[mid + 1] > nums[mid]) {
                return nums[mid];
            } else if (mid == left && nums[mid + 1] > nums[mid]) {
                return mid;
            } else if (mid == right && nums[mid + 1] > nums[mid]) {
                return mid;
            }
            else if (nums[right] == nums[mid] && nums[left] == nums[mid]) {
                left++;
                right--;
            } else if (nums[right] > nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        int ans = -1;

        return ans;
    }

    public static void main(String[] args) {

        int nums[] = {1, 1, 1};
        System.out.println(findMin(nums));
        System.out.println("Rahul khichar");
    }
}
