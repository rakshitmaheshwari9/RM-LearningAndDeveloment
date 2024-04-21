package DP.subsequnce;

import java.util.Arrays;
import java.util.Comparator;

//this will fix fractional knapsackPRoblem not 0/1
//for this you have to take dp problem rahul khichar
public class KnapSackFractional {

    public static void main(String[] args) {
        System.out.println("Rahul khichar");

        int n = 4;
        int[] weights = {1, 2, 4, 5};
        int[] values = {5, 4, 8, 6};
        int maxWeight = 5;


        System.out.println(knapsack(weights, values, n, maxWeight));

    }

    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {


        Pair[] pairs = new Pair[n];

        for (int i = 0; i < n; i++) {
            pairs[i] = new Pair(weight[i], value[i]);
        }
        Arrays.sort(pairs, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if (Double.compare(o2.ratio, o1.ratio) == 0)
                    return Integer.compare(o2.weight, o1.weight);
                else return Double.compare(o2.ratio, o1.ratio);
            }
        });


        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (maxWeight >= pairs[i].weight) {
                ans += pairs[i].value;
                maxWeight -= pairs[i].weight;
            } else if (maxWeight == pairs[i].weight) {
                ans += pairs[i].value;
                return ans;
            }
        }

        return ans;


    }


    static class Pair {

        int weight;
        int value;
        double ratio;

        Pair(int weight, int value) {

            this.weight = weight;
            this.value = value;
            this.ratio = (double) value / weight;
        }
    }
}
