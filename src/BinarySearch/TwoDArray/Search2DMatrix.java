package BinarySearch.TwoDArray;

public class Search2DMatrix {

    public static boolean search2DMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        if (n == 0) {
            return false;
        }
        int m = matrix[0].length;

        if (target < matrix[0][0] || target > matrix[n - 1][m - 1]) {
            return false;
        }

        int low = 0;
        int heigh = matrix.length - 1;
        int row = 0;

        while (low <= heigh) {
            int mid = (heigh - low) / 2 + low;

            if (matrix[mid][0] <= target) {
                row = mid;
                low = mid + 1;
            } else {
                heigh = mid - 1;
            }
        }

        int left = 0;
        int right = matrix[0].length - 1;

        while (left <= right) {
            int mid = (right - left) / 2 + left;
            int value = matrix[row][mid];
            if (value == target) {
                return true;
            } else if (value < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        System.out.println(search2DMatrix(matrix, 23));
        System.out.println("Rahul khichar");
    }
}
