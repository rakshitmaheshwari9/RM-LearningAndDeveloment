package String.Medium;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    public static int romanToInteger(String s) {


        Map<Character, Integer> mp = new HashMap<>();
        mp.put('I', 1);
        mp.put('V', 5);
        mp.put('X', 10);
        mp.put('L', 50);
        mp.put('C', 100);
        mp.put('D', 500);
        mp.put('M', 1000);
        int ans = 0;
        int n = s.length();
        for (int i = n - 1; i >= 0; i--) {
            ans += mp.get(s.charAt(i));
            if (i != n - 1) {
                if (mp.get(s.charAt(i)) < mp.get(s.charAt(i + 1)))
                    ans -= 2 * mp.get(s.charAt(i));
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        System.out.println(romanToInteger("LVIII"));
        System.out.println("Rahul khichar");
    }
}
