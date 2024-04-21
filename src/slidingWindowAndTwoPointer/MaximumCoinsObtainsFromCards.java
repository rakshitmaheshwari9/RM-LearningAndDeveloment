package slidingWindowAndTwoPointer;

public class MaximumCoinsObtainsFromCards {

    public static void main(String[] args) {

        System.out.println("Rahul khichar");
        MaximumCoinsObtainsFromCards maximumCoinsObtainsFromCards = new MaximumCoinsObtainsFromCards();

        int arr[] = {100, 40, 17, 9, 73, 75};
        int k = 3;
        System.out.println(maximumCoinsObtainsFromCards.maximumCoinsObtainsFromCards(arr, k));
    }


    public int maximumCoinsObtainsFromCards(int[] arr, int k) {

        int temp = 0;


        for (int i = 0; i < k; i++) {
            temp += arr[i];
        }
        k = k - 1;
        int lastIndex = arr.length - 1;

        int ans = temp;
        while (k >= 0) {
            temp += arr[lastIndex];
            temp -= arr[k];
            k--;
            lastIndex--;
            ans = Math.max(ans, temp);

        }


        return ans;

    }
}
