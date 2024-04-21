package BinarySearch.BSOnAnswers;

public class SplitArray {


    public static int splitArray(int[] nums, int k) {


        int ans = -1;

        int sum = 0;
        int min = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            min = Math.max(min, nums[i]);
        }
        int left = min;
        int right = sum;

        while (left <= right) {
            int mid = (right - left) / 2 + left;
            int temp = 0;
            int count = 1;
            for (int i = 0; i < nums.length; i++) {

                temp += nums[i];

                if (temp > mid) {
                    temp = nums[i];
                    count++;
                }
            }

            if (count <= k) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }


        return ans;
    }

    public static void main(String[] args) {

        int[] nums = {7, 2, 5, 10, 8};
        int k = 2;
        System.out.println(splitArray(nums, k));
        System.out.println("Rahul khichar");
    }
}
