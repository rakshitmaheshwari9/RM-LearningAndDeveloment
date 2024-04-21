package Recursion.Hard;

public class sudokuSolver {

    public static void main(String[] args) {
        System.out.println("Rahul Khichar");

        char[][] inputArray ={
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.println(isSolve(inputArray));
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(inputArray[i][j] + ",");
//                if (inputArray[i][j] == '.') {
//                    System.out.println(isSolve(inputArray, 0, 0));
//                    break;
//                }
            }
            System.out.println();
        }
    }

    private static boolean isValid(char[][] matrix, int row, int col, char num) {
        // Check the row
        for (int i = 0; i < 9; i++) {
            if (matrix[row][i] == num) {
                return false;
            }
        }

        // Check the column
        for (int i = 0; i < 9; i++) {
            if (matrix[i][col] == num) {
                return false;
            }
        }

        // Check the 3x3 subgrid
        int startRow = 3 * (row / 3);
        int startCol = 3 * (col / 3);
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (matrix[i][j] == num) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean isSolve(char[][] matrix) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (matrix[i][j] == '.') {
                    for (int k = 1; k <= 9; k++) {
                        char num = (char) (k + '0');
                        if (isValid(matrix, i, j, num)) {
                            matrix[i][j] = num;
                            if (isSolve(matrix)) {
                                return true;
                            } else {
                                matrix[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }


}
