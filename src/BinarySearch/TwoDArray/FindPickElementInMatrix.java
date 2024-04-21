package BinarySearch.TwoDArray;

public class FindPickElementInMatrix {

    public static int[] pickElement(int[][] matrix) {

        int[] ans = new int[2];
        int n = matrix.length;

        if (n == 0) {
            return ans;
        }

        int m = matrix[0].length;

        if (n == 1 && m == 1) {
            ans[0] = 0;
            ans[1] = 0;
            return ans;
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0) {
                    if (matrix[i][j] > matrix[i + 1][j]) {
                        if (j == 0) {
                            if (j == m - 1 && matrix[i][j] > matrix[i + 1][j]) {
                                ans[0] = i;
                                ans[1] = j;
                                return ans;
                            } else if (matrix[i][j] > matrix[i + 1][j] && matrix[i][j] > matrix[i + 1][j]) {
                                ans[0] = i;
                                ans[1] = j;
                                return ans;
                            }
                        }
                    }
                }

                if (j == 0) {

                }

                if (i == n - 1) {

                }
                if (j == n - 1) {

                }

                if (matrix[i][j] > matrix[i - 1][j] && matrix[i][j] > matrix[i][j - 1] && matrix[i][j] > matrix[i][j + 1] && matrix[i][j] > matrix[i + 1][j]) {
                    ans[0] = i;
                    ans[1] = j;
                    return ans;

                }
            }
        }


        return ans;
    }

    public static void main(String[] args) {
        System.out.println("Rahul Khichar");
    }
}
