package ArrayProblems;

import java.util.HashSet;

public class LongestConsecutiveSequence {


    public static int longestConsecutiveSequence(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            hashSet.add(num);
        }
        int ans = 1;
        int currAns = 1;
        for (int element : hashSet) {

            if (!hashSet.contains(element - 1)) {
                currAns = 1;
                int temp = element;
                while (hashSet.contains(temp + 1)) {
                    temp=temp+1;
                    currAns++;
                }
                ans = Math.max(ans, currAns);
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        int []nums={0,3,7,2,5,8,4,6,0,1};
        System.out.println(longestConsecutiveSequence(nums));
        System.out.println("Rahul khichar");
    }
}
