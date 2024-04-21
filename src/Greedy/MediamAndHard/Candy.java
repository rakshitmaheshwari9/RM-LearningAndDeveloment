package Greedy.MediamAndHard;

public class Candy {

    public static void main(String[] args) {
        System.out.println("Rahul khichar");

        int[] canday = {1, 0, 2};

        Candy candy = new Candy();


        System.out.println(candy.candy(canday));
    }

    public int candy(int[] ratings) {

        int length = ratings.length;


        int candy[] = new int[length];
        for (int index = 0; index < length; index++) {

            candy[index] = 1;
        }

        for (int index = 1; index < length; index++) {

            if (ratings[index] > ratings[index - 1]) {
                candy[index] = candy[index - 1] + 1;
            }
        }

        for (int index = length - 2; index >= 0; index--) {

            if (ratings[index] > ratings[index + 1] && candy[index] <= candy[index + 1]) {
                candy[index] = candy[index + 1] + 1;
            }
        }

        int ans = 0;
        for (int number : candy) {
            ans += number;
        }
        return ans;
    }
}
