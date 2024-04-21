package Graph.TopoSort;

import java.util.*;

public class AlienDictionary {

    public static void main(String[] args) {
        System.out.println("Rahul khichar");

        String[] dist = {"caa", "aaa", "aab"};
        int k = 3;
        System.out.println(getAlienLanguage(dist, k));
    }

    public static List<Character> findSequence(String firstString, String secondString) {
        List<Character> list = new ArrayList<>();

        int firstIndex = 0;
        int secondIndex = 0;
        while (firstIndex < firstString.length() && secondIndex < secondString.length()) {


            if (firstString.charAt(firstIndex) != secondString.charAt(secondIndex)) {
                list.add(firstString.charAt(firstIndex));
                list.add(secondString.charAt(secondIndex));
                return list;
            }
            firstIndex++;
            secondIndex++;
        }

        return list;
    }

    public static String getAlienLanguage(String[] dictionary, int k) {
        Map<Integer, List<Integer>> mp = new HashMap<>();
        int[] vis = new int[27];
        Set<Character> st = new HashSet<>();

        for (int i = 1; i < k; i++) {
            String firstString = dictionary[i - 1];
            String secondString = dictionary[i];
            List<Character> list = findSequence(firstString, secondString);

            if (list.size() >= 2) {
                Character from = list.get(0);
                Character to = list.get(1);
                st.add(from);
                st.add(to);
                List<Integer> adjList;
                if (mp.containsKey(from - 'a')) {
                    adjList = mp.get(from - 'a');
                } else {
                    adjList = new ArrayList<>();
                }
                adjList.add(to - 'a');
                vis[to - 'a']++;
                mp.put(from - 'a', adjList);
            }

        }
        Queue<Integer> queue = new LinkedList<>();
        for (int index = 0; index < 27; index++) {
            if (st.contains((char) (index + 'a')) && vis[index] == 0) {
                queue.add(index);
            }
        }


        String str = "";
        while (!queue.isEmpty()) {
            int node = queue.poll();
            str+=(char) (node + 'a');

            if (mp.containsKey(node)) {
                for (int number : mp.get(node)) {
                    vis[number]--;
                    if (vis[number] == 0) {
                        queue.add(number);
                    }
                }
            }
        }

        return str;
    }
}
