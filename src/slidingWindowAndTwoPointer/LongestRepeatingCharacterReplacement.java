package slidingWindowAndTwoPointer;

public class LongestRepeatingCharacterReplacement {

    public static void main(String[] args) {


        LongestRepeatingCharacterReplacement longestRepeatingCharacterReplacement = new LongestRepeatingCharacterReplacement();

        System.out.println(longestRepeatingCharacterReplacement.longestRepeatingCharacterReplacement("AABABBA", 1));
        System.out.println("Rahul khichar");
    }

    public int longestRepeatingCharacterReplacement(String str, int k) {

        int[] char_count = new int[26];

        int last_index = 0;
        int length = 0;


        for (int curr_index = 0; curr_index < str.length(); curr_index++) {
            char_count[str.charAt(curr_index) - 'A']++;

            while (curr_index - last_index - char_count[str.charAt(curr_index) - 'A'] >= k) {
                char_count[str.charAt(last_index) - 'A']--;
                last_index++;
            }

            length = Math.max(length, curr_index - last_index+1);

        }

        return length;
    }
}
