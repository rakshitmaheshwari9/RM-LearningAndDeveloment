package BinarySearch.TwoDArray;

import java.util.ArrayList;

public class MaximumOnesRow {


    public static int maximumOnesRow(ArrayList<ArrayList<Integer>> matrix, int n, int m) {
        int ans = -1;
        int index=-1;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < m; j++) {
                sum += matrix.get(i).get(j);
            }
            if(sum>ans) {
                ans=sum;
                index=i;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        System.out.println("Rahul khichar");
    }
}
