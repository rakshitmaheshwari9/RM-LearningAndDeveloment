package ArrayProblems;

public class RemoveDuplicatesInPlace {


    public static int removeBro(int[] arr) {

        int n = arr.length;

        int c = 0;

        for (int i = 1; i < n; i++) {
            if (arr[c] != arr[i]) {
                c++;
                arr[c] = arr[i];
            }
        }


        return c;
    }

    public static void main(String[] args) {


        System.out.println("Rahul khichar");

    }
}
