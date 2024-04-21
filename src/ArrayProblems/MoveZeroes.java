package ArrayProblems;

public class MoveZeroes {

    public static void moveZeroes(int[] nums) {
        int n = nums.length;

        int zero = 0;
        for (int i = 0; i < n; i++) {

            while (zero < n && nums[zero] != 0 && zero<i) {
                zero++;
            }

            if (nums[i] != 0 && zero < i) {
                int temp = nums[zero];
                nums[zero] = nums[i];
                nums[i] = temp;
            }
        }

    }

    public static void main(String[] args) {

        int[] temp = {0, 1, 0, 3, 12};
        moveZeroes(temp);

        for (int i = 0; i < temp.length; i++) {
//            System.out.println("args = " + Arrays.spliterator(temp));

            System.out.print(temp[i] + " ,");
        }

        System.out.println("Rahul Khichar");
    }
}
