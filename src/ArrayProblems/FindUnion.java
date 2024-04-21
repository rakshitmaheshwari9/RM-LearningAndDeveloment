package ArrayProblems;

import java.util.ArrayList;
import java.util.List;

public class FindUnion {


    public static List<Integer> findUnionOfTwoArray(int[] a, int[] b) {

        List<Integer> tempAns = new ArrayList<>();

        int firstArrayIndex = 0;
        int secondArrayIndex = 0;
        int n = a.length;
        int m = b.length;

        while (firstArrayIndex < n && secondArrayIndex < m) {

            if ((tempAns.size() > 0 && (a[firstArrayIndex] == tempAns.get(tempAns.size() - 1) || b[secondArrayIndex] == tempAns.get(tempAns.size() - 1)))) {
                if (a[firstArrayIndex] == tempAns.get(tempAns.size() - 1)) {
                    firstArrayIndex++;
                } else {
                    secondArrayIndex++;
                }
            } else if (a[firstArrayIndex] < b[secondArrayIndex]) {
                tempAns.add(a[firstArrayIndex]);
                firstArrayIndex++;
            } else {
                tempAns.add(b[secondArrayIndex]);
                secondArrayIndex++;
            }
        }

        while (firstArrayIndex < n) {
            if (a[firstArrayIndex] != tempAns.get(tempAns.size() - 1)) {
                tempAns.add(a[firstArrayIndex]);
            }
            firstArrayIndex++;

        }
        while (secondArrayIndex < m) {
            if (b[secondArrayIndex] != tempAns.get(tempAns.size() - 1)) {
                tempAns.add(b[secondArrayIndex]);
            }
            secondArrayIndex++;

        }

        return tempAns;
    }

    public static void main(String[] args) {
        System.out.println("Rahul khichar");
//        10 4
//        3 3 4 5 6 7 8 9 9 9
//        2 4 10 10

        int[] a = {3, 3, 4, 5, 6, 7, 8, 9, 9, 9};
        int[] b = {2, 4, 10, 10};
        List<Integer> ans = findUnionOfTwoArray(a, b);
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
    }
}
