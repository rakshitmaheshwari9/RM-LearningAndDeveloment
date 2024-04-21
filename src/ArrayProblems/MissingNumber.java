package ArrayProblems;

public class MissingNumber {


    public static int findMissingNumber(int[] arr) {

        int n = arr.length;

        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        int arrSum = (n * (n + 1)) / 2;
        int ans = arrSum - sum;

        return ans;

    }

    public static void main(String[] args) {

        int arr[] = {9, 6, 4, 2, 3, 5, 7, 0, 1};
//        System.out.println("Rahul khichar");

        System.out.println(findMissingNumber(arr));
    }
}
