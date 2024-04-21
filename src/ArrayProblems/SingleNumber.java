package ArrayProblems;

public class SingleNumber {

    public static int findSingleNumber(int[] arr) {

        int temp=arr[0];

        for(int i=1;i<arr.length;i++) {
            temp=temp^arr[i];
        }
        return temp;
    }

    public static void main(String[] args) {
        System.out.println("Single Number Rahul khichar");
    }

}
