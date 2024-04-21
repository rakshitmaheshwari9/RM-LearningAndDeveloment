package Graph.problemofdfsbfs;


import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {

    public int direction[][] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {
        System.out.println("Rahul khichar");

        RottingOranges rottingOranges = new RottingOranges();

        int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        rottingOranges.orangesRotting(grid);
    }

    public int bfs(int[][] grid, boolean vis[][]) {

        int ans = 0;

        Queue<Pair<Integer>> queue = new LinkedList<>();

        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[x].length; y++) {

                if (grid[x][y] == 2) queue.add(new Pair<>(x, y));

            }
        }

        while (!queue.isEmpty()) {
            ans++;
            int n = queue.size();
            for (int index = 0; index < n; index++) {
                Pair pair = queue.poll();
                if (!vis[(int) pair.x][(int) pair.y] && grid[(int) pair.x][(int) pair.y] == 2) {
                    vis[(int) pair.x][(int) pair.y] = true;
                    for (int number = 0; number < 4; number++) {
                        int XIndex = (int) pair.x + direction[number][0];
                        int YIndex = (int) pair.y + direction[number][1];

                        if (validIndex(grid, XIndex, YIndex)) {
                            grid[XIndex][YIndex] = 2;
                            queue.add(new Pair<>(XIndex, YIndex));
                        }
                    }
                }

            }
        }

        return ans - 1;

    }

    public boolean validIndex(int[][] grid, int x, int y) {

        if (x < grid.length && y < grid[0].length && x >= 0 && y >= 0 && grid[x][y] == 1) return true;

        return false;

    }

    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        if (n == 0) return 0;
        int m = grid[0].length;


        boolean vis[][] = new boolean[n][m];
        int ans = bfs(grid, vis);


        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) return -1;
            }
        }

        return ans;
    }

    public class Pair<T> {

        public T x;
        public T y;

        Pair(T x, T y) {
            this.x = x;
            this.y = y;
        }
    }
}
