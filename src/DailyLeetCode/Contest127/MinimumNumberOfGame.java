package DailyLeetCode.Contest127;

public class MinimumNumberOfGame {

    public static void main(String[] args) {
        System.out.println();

    }

    public int minimumLevels(int[] possible) {

        int n = possible.length;
        int left[] = new int[n];
        int right[] = new int[n];

        for (int i = 0; i < n; i++) {

            if (i == 0) {
                if (possible[i] == 0) {
                    left[i] = -1;
                } else {
                    left[i] = 1;
                }
            } else {
                if (possible[i] == 0) {
                    left[i] = -1 + left[i - 1];
                } else {
                    left[i] = 1 + left[i - 1];
                }
            }
        }

        for (int i = n - 1; i >= 0; i--) {

            if (i == n - 1) {
                if (possible[i] == 0) {
                    right[i] = -1;
                } else {
                    right[i] = 1;
                }
            } else {
                if (possible[i] == 0) {
                    right[i] = -1 + left[i + 1];
                } else {
                    right[i] = 1 + right[i + 1];
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (left[i] > 0) {
                if(left[i]>right[i])  return i+1;
            }
        }


        return -1;
    }
}
