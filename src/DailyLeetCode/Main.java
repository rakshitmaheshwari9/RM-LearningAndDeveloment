package DailyLeetCode;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static int minOperationsToIncreaseMedian(int n, int[] arr) {
        Arrays.sort(arr);
        int medianPos = (int) Math.ceil(n / 2.0);
        int median = arr[medianPos - 1];
        int targetMedian = arr[n - 1];
        int operations = 0;

        while (median < targetMedian) {
            operations++;
            arr[medianPos - 1]++;
            median = arr[medianPos - 1];
            if (medianPos < n) {
                medianPos++;
            }
        }

        return operations;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int testCase = 0; testCase < t; testCase++) {
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }
            System.out.println(minOperationsToIncreaseMedian(n, arr));
        }
        scanner.close();
    }
}
