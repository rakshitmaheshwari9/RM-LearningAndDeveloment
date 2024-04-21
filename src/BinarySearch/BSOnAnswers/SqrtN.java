package BinarySearch.BSOnAnswers;

public class SqrtN {


    public static int sqrtN(long N) {

        if (N <= 1) {
            return (int) N;
        }

        int ans = -1;

        long left = 1;
        long right = (int) N ;
        while (left <= right) {

            long mid = (right - left) / 2 + left;
            long temp = ((long) mid * (long) mid);

            if (temp == N) {
                return (int)mid;
            } else if (temp > N) {
                right = mid-1;
            } else {
                ans=(int)mid;
                left = mid+1;
            }
        }


        return ans;

    }

    public static void main(String[] args) {
        System.out.println("Rahul khichar");
        System.out.println(sqrtN(10));
    }
}
