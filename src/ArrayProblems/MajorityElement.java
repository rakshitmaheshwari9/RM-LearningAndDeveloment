package ArrayProblems;

public class MajorityElement {


    public static int majorityElement(int[] nums) {

        int element = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if(count==0) {
                element=nums[i];
            }
            if(element==nums[i]) {
                count++;
            } else {
                count--;
            }
        }

        return element;

    }

    public static void main(String[] args) {

        System.out.println("Rahul hichar");
    }
}
