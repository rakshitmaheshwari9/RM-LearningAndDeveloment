package String.Medium;

public class MaximumNestedDepth {
    public static int maximumNestedDepth(String str) {
        int count = 0;
        int ans = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') count++;
            ans = Math.max(ans, count);
            if (str.charAt(i) == ')') count--;
        }
        return ans;
    }
   

    public static void main(String[] args) {

        System.out.println(maximumNestedDepth("(1)+((2))+(((3)))"));
        System.out.println("Rahul khichar");
    }
}
