package ArrayProblems;

public class SortColours {


    public static void sortColours(int[] arr) {
        if (arr.length <= 1) {
            return;
        }
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            if (arr[start] == 0) {
                start++;
            } else if (arr[end] == 2) {
                end--;
            } else if (arr[start] == 2) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                end--;
            } else if (arr[end] == 0) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
            } else if (arr[start] != 1 && arr[end] != 2) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
            } else if (arr[start] == 1) {
                start++;
            }

        }

    }


    public static void swap(int[] arr, int firstIndex, int secondIndex) {
        int tempElement = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = tempElement;
    }

    public static void secondThreePointerMethod(int[] arr) {

        int low = 0;
        int mid = 0;
        int high = arr.length - 1;


        while (low < high && mid <= high) {

            if (arr[mid] == 0) {
                swap(arr, low, mid);
                low++;
//                mid++;
            } else if (arr[mid] == 2) {
                swap(arr, mid, high);
                high--;
            } else {
                mid++;
            }
        }

    }


    public static void main(String[] args) {

        int[] nums = {1, 0, 1};
        sortColours(nums);
        secondThreePointerMethod(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println("Rahul khichar");
    }
}
