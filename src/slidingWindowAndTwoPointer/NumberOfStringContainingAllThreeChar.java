package slidingWindowAndTwoPointer;

public class NumberOfStringContainingAllThreeChar {

    public static void main(String[] args) {
        System.out.println("Rahul khichar");
        NumberOfStringContainingAllThreeChar numberOfStringContainingAllThreeChar=new NumberOfStringContainingAllThreeChar();
        System.out.println(numberOfStringContainingAllThreeChar.numberOfStringContainingAllThreeChar("abc"));
    }

    public int numberOfStringContainingAllThreeChar(String str) {
        int arr[] = new int[3];

        int lastIndex = 0;
        int ans = 0;

        for (int index = 0; index < str.length(); index++) {
            arr[str.charAt(index) - 'a']++;


            while (arr[0] > 0 && arr[1] > 0 && arr[2] > 0) {
                ans += (str.length() - index );
                arr[str.charAt(lastIndex) - 'a']--;
                lastIndex++;

            }

        }

        return ans;
    }
}
