package DP.TwoD;

public class MinimumFailingPath {

    public static void main(String[] args) {
        System.out.println("Rahul khichar");

        int[][] input = {{2, 1, 3}, {6, 5, 4}, {7, 8, 9}};

        MinimumFailingPath minimumFailingPath = new MinimumFailingPath();

        System.out.println(minimumFailingPath.minFallingPathSum(input));

    }

    public int minFallingPathSum(int[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;
        for (int i = 1; i < n; i++) {

            for (int j = 0; j < m; j++) {

                if (j == 0) {
                    matrix[i][j] += Math.min(matrix[i - 1][j], matrix[i - 1][j + 1]);
                } else if (j == m - 1) {
                    matrix[i][j] += Math.min(matrix[i - 1][j], matrix[i - 1][j - 1]);
                } else {
                    matrix[i][j] += Math.min(matrix[i - 1][j], Math.min(matrix[i - 1][j - 1], matrix[i - 1][j + 1]));
                }
            }
        }
        ;

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            ans = Math.min(matrix[n - 1][i], ans);
        }

        return ans;
    }
}
