package DailyLeetCode.Contest127;

public class ShortestSubarrayWithR {

    public static void main(String[] args) {

        System.out.println("Rahul khichar");

        int input[] = {1, 2, 3}, k = 2;
        ShortestSubarrayWithR shortestSubarrayWithR = new ShortestSubarrayWithR();
        shortestSubarrayWithR.minimumSubarrayLength(input, k);
        System.out.println(shortestSubarrayWithR.minimumSubarrayLength(input, k));
    }

    public int minimumSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        int length = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {

            int temp = nums[i];

            for (int j = i + 1; j < n; j++) {
                temp = temp | nums[j];
                if (temp >= k) {
                    length = Math.min(length, j - i);
                    break;
                }
            }
        }
        if (length == Integer.MAX_VALUE) return -1;
        return length;

    }
}
