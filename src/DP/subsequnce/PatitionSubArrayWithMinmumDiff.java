package DP.subsequnce;

public class PatitionSubArrayWithMinmumDiff {

    public static void main(String[] args) {
        System.out.println("rahul khichar");

        PatitionSubArrayWithMinmumDiff patitionSubArrayWithMinmumDiff = new PatitionSubArrayWithMinmumDiff();
        int[] input = {3, 1, 5, 2, 8};

        System.out.println(patitionSubArrayWithMinmumDiff.minimumDifference(input));
    }

    public int minimumDifference(int[] nums) {

        int n = nums.length;
        int sum = 0;
        for (int number : nums) {
            sum += number;
        }
        int midSum = sum / 2;


        boolean[][] dp = new boolean[n + 1][midSum + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= midSum; j++) {

                if (i == 0 || j == 0) {
                    if (j == 0) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = false;
                    }
                } else if (j >= nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        int ans = midSum;
        for (int i = 0; i <= midSum; i++) {

            if (dp[n][i]) {
                ans = Math.min(ans, Math.abs(sum - 2 * i));
            }
        }

        return ans;
    }
}
