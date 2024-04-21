package ArrayProblems;

public class findMaximumConsucativeOne {


    public static int findMaximumConsucativeOne(int[] arr) {
        int tempMax = 0;
        int ans = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                ans = Math.max(ans, tempMax);
                tempMax = 0;

            } else {
                tempMax++;
            }
        }

        ans = Math.max(tempMax, ans);
        return ans;


    }

    public static void main(String[] args) {

        int[] arr = {1, 1, 0, 1, 1, 1};

        System.out.println(findMaximumConsucativeOne(arr));
        System.out.println("Rahul khichar");
    }
}
