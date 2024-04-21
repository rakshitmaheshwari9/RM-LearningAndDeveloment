package Recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GenerateParenthesis {

    public static void main(String[] args) {
        System.out.println("Rahul khichar");
//        List<String> ans = generateParenthesis(4);
        List<String> ans = new ArrayList<>();
        secondMethod(ans, 0, 0, 3, "");
        for (String temp : ans) {
            System.out.print(temp + ",");
        }
    }

    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        if (n == 1) {
            ans.add("()");
            return ans;
        }

        List<String> remainingString = generateParenthesis(n - 1);
        Set<String> st = new HashSet<>();

        for (String str : remainingString) {
            st.add("(" + str + ")");
            st.add(str + "()");
            st.add("()" + str);

        }
        for (String str : st) {
            ans.add(str);
        }

        return ans;

    }


    public static void secondMethod(List<String> ans, int openingCount, int closingCount, int totalCount, String str) {
        if (closingCount == totalCount ) {
            ans.add(str);
            return;
        }

        if (openingCount < totalCount) {
            secondMethod(ans, openingCount+1, closingCount, totalCount, "(" + str);
        }

        if (openingCount > closingCount) {
            secondMethod(ans, openingCount, closingCount+1, totalCount, str + ")");
        }
    }

}

