package Greedy;

import java.util.Arrays;

public class AssignCookies {

    public static void main(String[] args) {
        System.out.println("Rahul khichar");

        AssignCookies assignCookies = new AssignCookies();
        int g[] = {1, 2, 3};
        int s[] = {3};
        System.out.println(assignCookies.findContentChildren(g, s));
    }

    public int findContentChildren(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);

        int index = 0;
        int ans = 0;
        for (int number : g) {

            while (index < s.length && number > s[index]) {
                index++;
            }
            if (index == s.length) return ans;
            ans++;
            index++;


        }


        return ans;
    }

    public int findContentChildrenWithBatterNamingConvention(int[] childrenAppetite, int[] cookieSizes) {
        Arrays.sort(childrenAppetite);
        Arrays.sort(cookieSizes);

        int childIndex = 0;
        int satisfiedChildrenCount = 0;

        for (int appetite : childrenAppetite) {
            while (childIndex < cookieSizes.length && appetite > cookieSizes[childIndex]) {
                childIndex++;
            }

            if (childIndex == cookieSizes.length) {
                // No more cookies available
                return satisfiedChildrenCount;
            }

            satisfiedChildrenCount++;
            childIndex++;
        }

        return satisfiedChildrenCount;
    }
}
