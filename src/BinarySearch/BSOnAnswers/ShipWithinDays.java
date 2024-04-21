package BinarySearch.BSOnAnswers;

public class ShipWithinDays {


    public static int secondCase(int[] nums, int days) {

        int ans = -1;

        int min = nums[0];
        int n = nums.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            max += nums[i];
            min = Math.max(min, nums[i]);
        }

        int left = min;
        int right = max;

        while (left <= right) {
            int mid = (right - left) / 2 + left;
            int temp = 0;
            int dayCount = 1;

            for (int j = 0; j < n; j++) {
                temp += nums[j];

                if (temp > mid) {
                    dayCount++;
                    temp = nums[j];
                }

            }
            if (dayCount <= days) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }


        return ans;
    }

    public static int shipWithinDays(int[] nums, int days) {

        int ans = -1;

        int min = nums[0];
        int n = nums.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            max += nums[i];
            min = Math.max(min, nums[i]);
        }

        for (int i = min; i <= max; i++) {

            int temp = 0;
            int dayCount = 1;

            for (int j = 0; j < n; j++) {
                temp += nums[j];

                if (temp > i) {
                    dayCount++;
                    temp = nums[j];
                }

            }
            if (dayCount <= days) {
                return i;
            }
        }


        return ans;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int days = 5;

        System.out.println(shipWithinDays(nums, days));
        System.out.println(secondCase(nums,days));
        System.out.println("Rahul khichar");
    }
}
