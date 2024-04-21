package Graph.problemofdfsbfs;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class NumberOfIsland {


    public static int[][] direction = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) {

        int[][] input = {{
                1, 1, 0, 1, 1},
                {1, 0, 0, 0, 0},
                {0, 0, 0, 0, 1},
                {1, 1, 0, 1, 1}};
        int n = 4;
        int m = 5;
        System.out.println(distinctIsland(input, n, m));

        System.out.println("Rahul khichar");
    }

    public static boolean isValid(int[][] arr, boolean[][] vis, int n, int m, int xIndex, int yIndex) {
        if (xIndex >= 0 && yIndex >= 0 && xIndex < n && yIndex < m && !vis[xIndex][yIndex] && arr[xIndex][yIndex] == 1)
            return true;
        return false;
    }

    public static void dfs(int[][] arr, boolean[][] vis, int n, int m, int xIndex, int yIndex, StringBuilder str) {
        Stack<Pair> st = new Stack();

        st.push(new Pair(xIndex, yIndex));
        while (!st.isEmpty()) {

            Pair p = st.pop();
            vis[p.x][p.y] = true;

            str.append(xIndex - p.x).append(',').append(yIndex - p.y).append(';');

            for (int index = 0; index < 4; index++) {

                int XIndex = direction[index][0] + p.x;
                int YIndex = direction[index][1] + p.y;
                if (isValid(arr, vis, n, m, XIndex, YIndex)) {
                    st.add(new Pair(XIndex, YIndex));
                }
            }
        }

    }

    public static int distinctIsland(int[][] arr, int n, int m) {


        boolean[][] vis = new boolean[n][m];
        int ans = 0;

        Set<String> st = new HashSet<>();
        for (int xIndex = 0; xIndex < n; xIndex++) {
            for (int yIndex = 0; yIndex < m; yIndex++) {

                if (!vis[xIndex][yIndex] && arr[xIndex][yIndex] == 1) {
                    StringBuilder str = new StringBuilder("");
                    dfs(arr, vis, n, m, xIndex, yIndex, str);
                    st.add(String.valueOf(str));
//                    System.out.println(str);
//                    ans++;
                }
            }
        }

        return st.size();
    }

    public static class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
