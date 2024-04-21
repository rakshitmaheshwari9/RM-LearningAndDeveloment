package String;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StringMatchingInArray {


    public static boolean isMatching(String source, String target) {
        if (source.length() == 0) {
            return true;
        }
        if (target.length() == 0) {
            return false;
        }


        if (source.charAt(0) == target.charAt(0)) {
            return isMatching(source.substring(1), target.substring(1)) || isMatching(source, target.substring(1));
        }

        return isMatching(source, target.substring(1));

    }


    public static void main(String[] args) {
        String[] words = {"mass", "as", "hero", "superhero"};
        System.out.println(isMatching("hero", "superhero"));
        Set<String> st = new HashSet<>();
        int n = words.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    if (isMatching(words[i], words[j])) {
                        st.add(words[i]);
                    }
                }
            }
        }

        List<String> ans = new ArrayList<>(st);

        for (String str : ans) {
            System.out.println(ans);
        }
    }
}
