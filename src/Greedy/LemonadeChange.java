package Greedy;

import java.util.Arrays;

public class LemonadeChange {

    public static void main(String[] args) {
        System.out.println("Rahul khichar");
        int[] arr = {5,5,10,10,20};
        System.out.println(lemonadeChange(arr));
    }

    public static boolean lemonadeChange(int[] arr) {

        Arrays.sort(arr);

        int ten = 0;
        int five = 0;

        for (int number : arr) {

            if (number == 5) five++;
            else if (number == 10) {
                if (five == 0) return false;
                else {
                    five--;
                    ten++;
                }
            } else {

                if ((ten > 0 && five > 0) || five > 2) {
                    if ((ten > 0 && five > 0)) {
                        ten--;
                        five--;
                    } else {
                        five = five - 3;
                    }

                } else {
                    return false;
                }
            }


        }


        return true;
    }
}
