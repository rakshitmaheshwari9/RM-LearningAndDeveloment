package StackAndQueue.MonotonicStack;

public class SumOfSubarrayRanges {

    public static void main(String[] args) {
        System.out.println("Rahul Khichar");
    }


    public static int firstMethod(int[] input) {

        int ans = 0;
        int n = input.length;
        for (int i = 0; i < n; i++) {

            int smallest = input[i];
            int largest = input[i];
            for (int j = i; j < n; j++) {
                smallest = Math.min(smallest, input[j]);
                largest = Math.max(largest, input[j]);
                ans += (largest - smallest);
            }
        }
        return ans;
    }


}
