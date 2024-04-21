package Graph.problemofdfsbfs;

import java.util.Stack;

public class NumberOfEnclaves {

    int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {
        System.out.println("Rahul khichar");
    }


    public boolean isValid(int[][] grid, boolean[][] vis, int xIndex, int yIndex) {
        if (xIndex < 0 || yIndex < 0 || xIndex > grid.length || yIndex > grid[0].length || vis[xIndex][yIndex] || grid[xIndex][yIndex] == 0)
            return false;
        return true;
    }

    public void dfs(int[][] grid, boolean[][] vis, int xIndex, int yIndex) {

        Stack<Pair> st = new Stack<>();

        st.push(new Pair(xIndex, yIndex));
        while (!st.isEmpty()) {

            Pair pair = st.pop();
            vis[pair.x][pair.y] = true;

            for (int index = 0; index < 4; index++) {

                int XIndex = pair.x + direction[index][0];
                int YIndex = pair.y + direction[index][1];
                if (isValid(grid, vis, XIndex, YIndex)) {
                    st.push(new Pair(XIndex, YIndex));
                }
            }

        }


    }

    public int numEnclaves(int[][] grid) {


        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;

        boolean vis[][] = new boolean[n][m];

        for (int xIndex = 0; xIndex < n; xIndex++) {
            for (int yIndex = 0; yIndex < m; yIndex++) {
                if (!vis[xIndex][yIndex] && grid[xIndex][yIndex] == 1) {
                    dfs(grid, vis, xIndex, yIndex);
                    ans++;
                }
            }
        }

        return ans;
    }


    public boolean isValid(int[][] grid, int xIndex, int yIndex) {
        if (xIndex >= 0 && yIndex >= 0 && xIndex < grid.length && yIndex < grid[0].length && grid[xIndex][yIndex] == 1)
            return false;
        return true;
    }

    public void bfs(int[][] grid, int xIndex, int yIndex) {


        Stack<Pair> st = new Stack<>();

        st.add(new Pair(xIndex, yIndex));
        while (!st.isEmpty()) {
            Pair p = st.pop();
            grid[xIndex][yIndex] = 0;
            for (int index = 0; index < 4; index++) {
                int XIndex = p.x + direction[index][0];
                int YIndex = p.y + direction[index][1];
                if (isValid(grid, xIndex, yIndex)) {
                    st.push(new Pair(XIndex, YIndex));
                }
            }
        }
    }

    public int numEnclavessecondIssue(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;

        for (int xIndex = 0; xIndex < n; xIndex++) {
            for (int yIndex = 0; yIndex < m; yIndex++) {

                if (xIndex == 0 || xIndex == n - 1 || yIndex == 0 || yIndex == m - 1) {
                    if (grid[xIndex][yIndex] == 1) {
                        bfs(grid, xIndex, yIndex);
                    }

                }
            }
        }
        for (int xIndex = 0; xIndex < n; xIndex++) {
            for (int yIndex = 0; yIndex < m; yIndex++) {

                if (grid[xIndex][yIndex] == 1) {
                    ans++;
                }

            }
        }

        return ans;
    }

    public class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
