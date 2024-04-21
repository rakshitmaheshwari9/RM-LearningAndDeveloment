package BinarySearch.BSOnAnswers;

public class SmallestDivisor {

    public static void main(String[] args) {
        System.out.println("Rahul khichar");

        int[] nums = {44, 22, 33, 11, 1};
        int test = 5;
        System.out.println(smallestDivisor(nums, test));
        System.out.println(secondSolution(nums,5));
    }

    public static int smallestDivisor(int[] nums, int threshold) {
        int ans = 1;
        int max = 1;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
        }

        if (threshold < n) {
            return max;
        }


        for (int i = 1; i < max; i++) {
            int sum = 0;

            for (int j = 0; j < n; j++) {
                if (nums[j] % i == 0) {
                    sum += nums[j] / i;
                } else {
                    sum += nums[j] / i + 1;
                }

            }
            if (sum <= threshold) {
                return i;
            }
        }

        return ans;
    }

    public static int secondSolution(int[] nums, int threshold) {
        int ans = 1;
        int max = 1;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
        }

        if (threshold < n) {
            return max;
        }

        int left = 1;
        int right = max;

        while (left <= right) {


            int mid = (right - left) / 2 + left;
            int sum = 0;

            for (int j = 0; j < n; j++) {
                if (nums[j] % mid == 0) {
                    sum += nums[j] / mid;
                } else {
                    sum += nums[j] / mid + 1;
                }

            }

            if (sum <= threshold) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }
        return ans;
    }
}
