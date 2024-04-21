package DP.TwoD;

import java.util.ArrayList;
import java.util.List;

public class Triangle {
    public static void main(String[] args) {
        System.out.println("Rahul khichar");

        List<List<Integer>> input = new ArrayList<>();
        input.add(List.of(2));
        input.add(List.of(3, 4));
        input.add(List.of(6, 5, 7));
        input.add(List.of(4, 1, 8, 3));
        Triangle triangle = new Triangle();

        System.out.println(triangle.minimumTotal(input));
    }

    public int minimumTotal(List<List<Integer>> triangle) {

        int n = triangle.size();
        int m = triangle.get(n - 1).size();
        int dp[][] = new int[n][m];

        for (int i = 0; i < m; i++) {
            if (i == 0) {
                dp[0][i] = triangle.get(0).get(0);
            } else {
                dp[0][i] = Integer.MAX_VALUE;
            }
        }

        for (int i = 1; i < n; i++) {
            int j = 0;
            for (; j < triangle.get(i).size(); j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + triangle.get(i).get(j);
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle.get(i).get(j);
                }
            }
            for (; j < m; j++) {
                dp[i][j] = dp[i - 1][j];
            }
        }


        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            ans = Math.min(ans, dp[n - 1][i]);
        }

        return ans;
    }
}
