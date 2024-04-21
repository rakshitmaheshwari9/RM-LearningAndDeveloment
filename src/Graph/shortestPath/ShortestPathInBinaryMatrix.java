package Graph.shortestPath;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ShortestPathInBinaryMatrix {

    int[][] direction = {{1, 1}, {1, -1}, {-1, 1}, {-1, -1}, {0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) {
        System.out.println("Rahul khichar");

        int matrix[][] = {{0, 0, 0}, {1, 1, 0}, {1, 1, 0}};
        ShortestPathInBinaryMatrix shortestPathInBinaryMatrix = new ShortestPathInBinaryMatrix();
        int ans = shortestPathInBinaryMatrix.shortestPathBinaryMatrix(matrix);
        System.out.println(ans);


    }

    public boolean isValid(int[][] grid, int x, int y) {

        if (x < 0 || x >= grid.length || y >= grid[0].length || y < 0 || grid[x][y] == 1) return false;
        return true;
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return -1;
        if (grid[0][0] == 1) return -1;
        int n = grid.length;
        int m = grid[0].length;
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.weight - o2.weight;
            }
        });

        int[][] vis = new int[grid.length][grid[0].length];

        for (int xIndex = 0; xIndex < vis.length; xIndex++) {
            for (int yIndex = 0; yIndex < vis[xIndex].length; yIndex++) {
                vis[xIndex][yIndex] = Integer.MAX_VALUE;
            }
        }
        vis[0][0] = 1;


        pq.add(new Pair(0, 0, 0));

        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            int x = pair.xIndex;
            int y = pair.yIndex;

            for (int index = 0; index < direction.length; index++) {

                int newXIndex = x + direction[index][0];
                int newYIndex = y + direction[index][1];
                if (isValid(grid, newXIndex, newYIndex)) {
                    if (vis[newXIndex][newYIndex] > vis[x][y] + 1) {
                        vis[newXIndex][newYIndex] = vis[x][y] + 1;
                        pq.add(new Pair(newXIndex, newYIndex, vis[x][y] + 1));
                        if (newXIndex == n - 1 && newYIndex == m - 1) return vis[x][y] + 1;
                    }

                }
            }
        }

        if (vis[n - 1][m - 1] == Integer.MAX_VALUE) return -1;

        return vis[n - 1][m - 1];

    }

    public class Pair {

        int xIndex;
        int yIndex;
        int weight;

        Pair(int xIndex, int yIndex, int weight) {
            this.xIndex = xIndex;
            this.yIndex = yIndex;
            this.weight = weight;
        }
    }
}
