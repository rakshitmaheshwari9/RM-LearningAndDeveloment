package slidingWindowAndTwoPointer;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepea {

    public static void main(String[] args) {
        System.out.println("Rahul Khichar");

        LongestSubstringWithoutRepea longestSubstringWithoutRepea = new LongestSubstringWithoutRepea();

        System.out.println(longestSubstringWithoutRepea.secondMethod("pwwkew"));

    }


    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;

        int leftIndex = 0;
        int ans = 1;
        Map<Character, Integer> mp = new HashMap<>();
        mp.put(s.charAt(0), 1);

        for (int i = 1; i < s.length(); i++) {
            if (mp.containsKey(s.charAt(i))) {
                while (leftIndex < i) {
                    mp.remove(s.charAt(leftIndex));
                    if (s.charAt(leftIndex) == s.charAt(i)) {
                        leftIndex++;
                        break;
                    } else {
                        leftIndex++;
                    }
                }
            }
            ans = Math.max(ans, i - leftIndex + 1);
            mp.put(s.charAt(i), 1);
        }

        return ans;
    }

    public int secondMethod(String s) {
        if (s.length() == 0) return 0;

        int ans = 1;
        Map<Character, Integer> mp = new HashMap<>();


        for (int i = 0, j = 0; j < s.length(); j++) {

            if (mp.containsKey(s.charAt(j))) {
                i = Math.max(mp.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            mp.put(s.charAt(j), j + 1);
        }


        return ans;
    }
}
