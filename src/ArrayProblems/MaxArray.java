package ArrayProblems;

public class MaxArray {

    public static int maxProduct(int[] arr) {


        int max = Math.max(arr[0],1);
        int min = Math.min(arr[0],1);
        int ans = max;

        for (int i = 1; i < arr.length; i++) {
            int temp=max;
            max = Math.max(max * arr[i], Math.max(arr[i], arr[i] * min));
            min = Math.min(min * arr[i], Math.min(arr[i], arr[i] * temp));
            ans = Math.max(ans, max);
        }


        return ans;
    }

    public static void main(String[] args) {
        int arr[] = {-4,-3,-2};
        System.out.println(maxProduct(arr));
        System.out.println("Rahul khichar");
    }
}
