package ArrayProblems;

public class SetMatrixZeroes {


    public static void setMatrixZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        boolean[] hori = new boolean[m];
        boolean[] ver = new boolean[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    hori[j] = true;
                    ver[i] = true;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if(ver[i]) {
                for(int j=0;j<m;j++) {
                    matrix[i][j]=0;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            if(hori[i]) {
                for(int j=0;j<n;j++) {
                    matrix[j][i]=0;
                }
            }
        }

    }

    public static void main(String[] args) {
        System.out.println("Rahul khichar");
    }
}
