package BinarySearch.BSOnAnswers;

public class FindNthRootOfM {


    public static int findNthRootOfM(int n, long m) {

        int ans = -1;

        long left = 0;
        long right = m;
        while (left <= right) {

            long mid = (right - left) / 2 + left;

            long tempSol = (long) Math.pow(mid, n);

            if (tempSol == m) {
                return (int) mid;
            } else if (tempSol > m) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }


        return ans;

    }

    public static void main(String[] args) {
        System.out.println("Rahul khichar");
    }
}
