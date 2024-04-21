package BinarySearch.BSOnAnswers;

public class FindKthPositive {

    public static int findKthPositive(int[] nums, int k) {
        int ans = -1;
        int n = nums.length;
        int temp = k;

        for (int num : nums) {
            n = Math.max(n, num) + temp;
        }

        for (int i = 1; i <= n; i++) {
            boolean isAva = false;
            for (int num : nums) {

                if (num == i) {
                    isAva = true;
                }
            }
            if (!isAva) {
                k--;
                if (k == 0) {
                    return i;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("Rahul khichar");

        int nums[] = {1};
        int k = 1;
        System.out.println(findKthPositive(nums, k));
    }
}
