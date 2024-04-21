package String;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Isomorphic {


    public static boolean isomorphic(String s, String t) {
        HashMap<Character, Character> hm = new HashMap<>();
        Set<Character> st = new HashSet<>();
        if (s.length() != t.length()) return false;
        int index = 0;
        while (index < s.length()) {
            if (hm.containsKey(s.charAt(index))) {
                if (hm.get(s.charAt(index)) != t.charAt(index)) return false;
            } else {

                if (!st.contains(t.charAt(index))) {
                    hm.put(s.charAt(index), t.charAt(index));
                    st.add(t.charAt(index));
                }
                return false;
            }
            index++;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("Rahul Khichar");
        String s1 = "badc";
        String s2 = "baba";

        System.out.println(isomorphic(s1, s2));
    }
}
