package BinarySearch.TwoDArray;

public class Search2DMMoreDifficult {

    public static boolean matrixSearch2(int[][] matrix, int target) {
        boolean ans = false;

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

        int col = 0;
        low = 0;
        heigh = m - 1;
        while (low <= heigh) {
            int mid = (heigh - low) / 2 + low;

            if (matrix[0][mid] <= target) {
                col = mid;
                low = mid + 1;
            } else {
                heigh = mid - 1;
            }
        }


        int left = 0;
        int right = m - 1;

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
        left = 0;
        right = n - 1;

        while (left <= right) {
            int mid = (right - left) / 2 + left;
            int value = matrix[mid][col];
            if (value == target) {
                return true;
            } else if (value < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }


        return ans;
    }

    public static boolean searchInRow(int[][] matrix, int target, int row) {

        int n = matrix.length;
        int m = matrix[0].length;
        int left = 0;
        int right = m - 1;

        while (left <= right) {
            int mid = (right - left) / 2 + left;

            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }

    public static boolean secondMathod(int[][] matrix, int target) {
        boolean ans = false;

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

            if (matrix[mid][0] <= target && target <= matrix[mid][m - 1]) {
                row = mid;
                if (searchInRow(matrix, target, row)) ;
                low = mid + 1;
            } else if (matrix[mid][0] < target) {
                low = mid + 1;
            } else {
                heigh = mid - 1;
            }
        }


        return ans;
    }


    public static boolean lastSolutionAndCorrect(int[][] matrix, int target) {

        int n = matrix.length;
        if (n == 0) {
            return false;
        }
        int m = matrix[0].length;
        int i = 0;
        int j = m - 1;

        while (i < n && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] < target) {
                i++;
            } else {
                j--;
            }
        }

        return false;

    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7, 9}, {2, 4, 6, 8, 10}, {11, 13, 15, 17, 19}, {12, 14, 16, 18, 20}, {21, 22, 23, 24, 25}};
        System.out.println(matrixSearch2(matrix, 1));
        System.out.println("Rahul khichar");
    }
}
