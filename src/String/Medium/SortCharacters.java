package String.Medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortCharacters {

    public static String frequencySort(String s) {

        int n = s.length();
        int arr[] = new int[75];
        for (int i = 0; i < n; i++) {
            arr[s.charAt(i) - '0']++;
        }

        List<List<Integer>> tempAns = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {

            List<Integer> tl = new ArrayList<>();
            tl.add(i);
            tl.add(arr[i]);
            tempAns.add(tl);
        }

        tempAns.sort(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o2.get(1) - o1.get(1);
            }
        });
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < tempAns.size(); i++) {
            if (tempAns.get(i).get(1) == 0) break;
            for (int j = 0; j < tempAns.get(i).get(1); j++) {
                str.append((char) (tempAns.get(i).get(0) + '0'));
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println(frequencySort("RahulKhichar"));
        System.out.println("Rahul khichar");
    }
}
