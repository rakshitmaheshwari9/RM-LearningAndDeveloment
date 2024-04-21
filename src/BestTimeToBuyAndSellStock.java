public class BestTimeToBuyAndSellStock {

    public static int maximumPrices(int[] prices) {

        int min = prices[0];
        int ans = 0;

        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            ans = Math.max(ans, prices[i] - min);
        }
        return ans;

    }

    public static void main(String[] args) {

        int array[] = {7, 1, 5, 3, 6, 4};
        System.out.println(maximumPrices(array));
//        System.out.println("Rahul khichar");
    }
}
