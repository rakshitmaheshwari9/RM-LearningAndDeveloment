package Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapSack {

    public static void main(String[] args) {

        FractionalKnapSack fractionalKnapSack = new FractionalKnapSack();
        System.out.println(fractionalKnapSack.fractionalKnapsack());
        System.out.println("Rahul khichar");
    }

    double fractionalKnapsack() {
        int N = 4, W = 5,
                value[] = {
                        6, 8, 10, 8
                }, weight[] = {
                2, 6, 9, 3
        };
        Item[] arr = new Item[N];
        for (int index = 0; index < N; index++) {
            arr[index] = new Item(value[index], weight[index]);
        }

        Arrays.sort(arr, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                double ratio1 = (double) o1.value / o1.weight;
                double ratio2 = (double) o2.value / o2.weight;

                return Double.compare(ratio2, ratio1);
            }
        });

        System.out.println("Rhaul");
        System.out.println((5 * (double) (5 / 9)));
        double ans = 0;

        for (int index = 0; index < arr.length; index++) {
            if (W >= arr[index].weight) {
                ans += arr[index].value;
                W -= arr[index].weight;
            } else {
                ans += (W * (double) (arr[index].value / arr[index].weight));
                return ans;
            }
        }


        return ans;
    }

    class Item {
        int value, weight;

        Item(int x, int y) {
            this.value = x;
            this.weight = y;
        }
    }


}
