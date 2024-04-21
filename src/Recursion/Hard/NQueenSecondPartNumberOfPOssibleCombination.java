package Recursion.Hard;

import java.util.ArrayList;
import java.util.List;

public class NQueenSecondPartNumberOfPOssibleCombination {
    public static void main(String[] args) {
        System.out.println("Rahul Khichar");
    }
    public void printQueen(int n) {

        List<List<String>> ans = new ArrayList<>();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            matrix[0][i] = 1;
            bfsSearchInMatrix(matrix, 1, n, ans);
            matrix[0][i] = 0;
        }







        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + ",");
            }
            System.out.println();
        }


    }
    public List<String> printQueen(int[][] matrix, int n) {
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    builder.append('Q');
                } else {
                    builder.append('.');
                }
            }
            ans.add(builder.toString());
        }

        return ans;

    }

    public boolean fillVisList(int[][] vis, int xIndex, int yIndex, int n) {
        for (int i = 0; i < n; i++) {
            if (vis[i][yIndex] == 1) return false;
        }

        int i = xIndex;
        int j = yIndex;
        while (i >= 0 && j >= 0) {
            if (vis[i][j] == 1) return false;
            i--;
            j--;
        }

        i = xIndex;
        j = yIndex;
        while (i < n && j < n) {
            if (vis[i][j] == 1) return false;
            i++;
            j++;
        }

        i = xIndex;
        j = yIndex;
        while (i >= 0 && j < n) {
            if (vis[i][j] == 1) return false;
            i--;
            j++;
        }

        i = xIndex;
        j = yIndex;
        while (i < n && j >= 0) {
            if (vis[i][j] == 1) return false;
            i++;
            j--;
        }

        return true;

    }

    public void bfsSearchInMatrix(int[][] matrix, int row, int n, List<List<String>> ans) {

        if (row == n) {
            ans.add(printQueen(matrix, n));
            return;
        }

        for (int j = 0; j < n; j++) {
            if (fillVisList(matrix, row, j, n)) {
                matrix[row][j] = 1;
                bfsSearchInMatrix(matrix, row + 1, n, ans);
                matrix[row][j] = 0;
            }
        }
    }
}
