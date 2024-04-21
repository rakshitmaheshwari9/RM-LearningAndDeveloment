package BinarySearch.BSOnAnswers;

public class MinEatingSpeed {

    public static int minEatingSpeed(int[] nums, int h) {


        int ans = -1;
        int n = nums.length;

        int min = nums[0];
        int max = nums[0];

        for (int i = 0; i < n; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }


        for (int i = min; i <= max; i++) {
            int tempTime = 0;
            for (int j = 0; j < n; j++) {

                if (nums[j] % i == 0) {
                    tempTime += nums[j] / i;
                } else {
                    tempTime += nums[j] / i + 1;
                }
            }
            if (tempTime <= h) {
                return i;
            }
        }


        return ans;
    }

    public static int minEatingSpeedOptimisedWay(int[] nums, int h) {


        int ans = -1;
        int n = nums.length;

        int min = 1;
        int max = nums[0];

        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
        }


        int left = min;
        int right = max;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
             long tempTime = 0;
            for (int j = 0; j < n; j++) {

                if (nums[j] % mid == 0) {
                    tempTime += nums[j] / mid;
                } else {
                    tempTime += nums[j] / mid + 1;
                }
            }
            if (tempTime <= h) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }


        return ans;
    }

    public static void main(String[] args) {


        int num[] = {805306368,805306368,805306368};
        int n = 1000000000;

        System.out.println(minEatingSpeed(num, n));
        System.out.println(minEatingSpeedOptimisedWay(num, n));
        System.out.println();
        System.out.println("Rahul khichar");
    }
}
