package ArrayProblems;

public class RotateArray {


    public static void rotateArray(int arr[], int k) {
        int n = arr.length;

        if (n <= k) {
            return;
        }

        for (int i = 0; i < n; i++) {

            int secondIndex = ((i - k) + n) % n;
            int temp = arr[secondIndex];
            arr[secondIndex] = arr[i];
            arr[i] = temp;
        }

    }

    public static void main(String[] args) {
        System.out.println("Rahul khichar");
    }
}
