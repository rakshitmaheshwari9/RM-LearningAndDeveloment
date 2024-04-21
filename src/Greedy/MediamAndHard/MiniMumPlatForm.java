package Greedy.MediamAndHard;

import java.util.Arrays;
import java.util.Comparator;


public class MiniMumPlatForm {
    public static void main(String[] args) {
        System.out.println("Rahul Khichar");

        int n = 3,
                arr[] = {900, 1100, 1235},
                dep[] = {1000, 1200, 1240};
        System.out.println(secondSolution(arr, dep, n));
    }

//    static int findPlatform(int arr[], int dep[], int n) {
//        // add your code here
//
//
//        Pair[] platformTime = new Pair[n];
//        for (int i = 0; i < n; i++) {
//            platformTime[i] = new Pair(arr[i], dep[i]);
//        }
//
//        Arrays.sort(platformTime, new Comparator<Pair>() {
//            @Override
//            public int compare(Pair o1, Pair o2) {
//                if (o1.end != o2.end) {
//                    return o1.end > o2.end ? 1 : -1;
//                } else {
//                    return o1.start < o2.start ? 1 : -1;
//                }
//
//            }
//        });
//
//        int ans = 1;
//        boolean[] vis = new boolean[n];
//
//        for (int i = 0; i < n; i++) {
//            if (!vis[i]) {
//                int lastTime = platformTime[i].end;
//                for (int j = i + 1; j < n; j++) {
//                    if (!vis[j] && platformTime[j].start > lastTime) {
//                        vis[j] = true;
//                        lastTime = platformTime[j].end;
//                    }
//                }
//                ans++;
//                vis[i] = true;
//            }
//        }
//
//        return ans;
//
//
//    }


    static int secondSolution(int arr[], int dep[], int n) {

        Arrays.sort(arr);
        Arrays.sort(dep);
        int platForm = 1;
        int i = 1;
        int j = 0;
        int ans = 1;

        while (i < n && j < n) {

            if (arr[i] <= dep[j]) {
                platForm++;
                ans = Math.max(ans, platForm);
                i++;
            } else {
                platForm--;
                j++;

            }
        }
        return ans;

    }


}
