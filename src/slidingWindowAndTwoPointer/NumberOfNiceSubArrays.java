package slidingWindowAndTwoPointer;

public class NumberOfNiceSubArrays {
    public static void main(String[] args) {
        System.out.println("Rahul khichar");

        int[] firstSample = {2, 2, 2, 1, 2, 2, 1, 2, 2, 2};
        int firstK = 2;
        NumberOfNiceSubArrays numberOfNiceSubArrays = new NumberOfNiceSubArrays();


        System.out.println(numberOfNiceSubArrays.secondAns(firstSample, firstK));
    }

    public int countNumberOfNiceSubArrays(int[] nums, int k) {

        int count = 0;
        int lastIndex = 0;
        int ans = 0;

        for (int index = 0; index < nums.length; index++) {

            if (nums[index] % 2 != 0) {
                count++;
            }

            if (count > k) {
                while (nums[index] % 2 == 0) {
                    lastIndex++;
                }
                lastIndex++;
                count--;
            }
            if (count == k) {
                ans++;
            }

        }


        return ans;

    }

    public int secondAns(int[] nums, int k) {

        int count = 0;
        int lastIndex = 0;
        int ans = 0;

        int leftEven[] = new int[nums.length];

        for (int index = 0; index < nums.length; index++) {

            if (nums[index] % 2 == 0) {
                if (index == 0) {
                    leftEven[index] = 1;
                } else
                    leftEven[index] = leftEven[index - 1] + 1;
            } else {
                leftEven[index] = 0;
            }

        }


        for (int index = 0; index < nums.length; index++) {

            if (nums[index] % 2 != 0) {
                count++;
            }

            if (count > k) {
                while (nums[index] % 2 == 0) {
                    lastIndex++;
                }
                lastIndex++;
                count--;
            }
            if (count == k) {
                while (nums[lastIndex] % 2 == 0) {
                    lastIndex++;
                }
                if (lastIndex == 0) {
                    ans += 1;
                } else
                    ans = ans + (leftEven[lastIndex - 1] + 1);
            }

        }


        return ans;

    }
}
