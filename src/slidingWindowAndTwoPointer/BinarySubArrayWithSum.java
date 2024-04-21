package slidingWindowAndTwoPointer;

import java.util.HashMap;
import java.util.Map;

public class BinarySubArrayWithSum {

    public static void main(String[] args) {
        System.out.println("Rahul khichar");
        BinarySubArrayWithSum binarySubArrayWithSum = new BinarySubArrayWithSum();

        int[] firstSampleCase = {0, 0, 0, 0, 0};
        int firstSampleSum = 0;

        int[] secondSampleCase = {1, 0, 1, 0, 1};
        int secondSampleSum = 2;
        System.out.println(binarySubArrayWithSum.binarySubArrayWithSum(firstSampleCase, firstSampleSum));
        System.out.println(binarySubArrayWithSum.binarySubArrayWithSum(secondSampleCase, secondSampleSum));
    }

    public int binarySubArrayWithSum(int[] arr, int k) {


        Map<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        int ans = 0;
        map.put(0, 1);

        for (int index = 0; index < arr.length; index++) {
            sum += arr[index];
            if (map.containsKey(sum - k)) {
                ans += map.get(sum - k);
            }

            if (!map.containsKey(sum)) {
                map.put(sum, 1);
            } else {
                map.put(sum, map.get(sum) + 1);
            }


        }

        return ans;

    }
}
