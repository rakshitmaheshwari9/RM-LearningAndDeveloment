package ArrayProblems;

public class RearrangeArray {

    public static void swap(int[] nums, int firstIndex, int secondIndex) {
        int temp = nums[firstIndex];
        nums[firstIndex] = nums[secondIndex];
        nums[secondIndex] = temp;
    }

    public static void reArrangeArray(int[] nums) {
        int n = nums.length;



        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i = i + 2) {
                if (nums[i] < 0 && nums[i + 1] > 0) {
                    swap(nums, i, i + 1);
                } else if (nums[i + 1] > 0 && i + 2 < n && nums[i + 2] < 0) {
                    swap(nums, i + 1, i + 2);
                }
            }
        }

        System.out.println("Rahul khichar");
    }

    public static void main(String[] args) {
        System.out.println("Rahul Khichar");
    }
}
