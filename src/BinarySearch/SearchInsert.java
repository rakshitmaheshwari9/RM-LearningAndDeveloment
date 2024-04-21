package BinarySearch;

public class SearchInsert {

    public static int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int ans = n;

        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;

            if (nums[mid] <target) {

                left = mid + 1;
            } else {
                ans = mid;
                right = mid - 1;
            }
        }


        return ans;
    }

    public static void main(String[] args) {

        int []nums={1,3,5,6};
        System.out.println(searchInsert(nums,5));
        System.out.println("Rahul khichar");
    }
}
