package Graph.shortestPath;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PathWithMinimumEffort {

    int fourDirection[][] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {

        int[][] input = {{1, 2, 3}, {3, 8, 4}, {5, 3, 5}};

        PathWithMinimumEffort pathWithMinimumEffort = new PathWithMinimumEffort();

        System.out.println(pathWithMinimumEffort.minimumEffortPath(input));


//        System.out.println(m);
        System.out.println("Rahul Khichar");
    }

    public boolean isValidDirection(int[][] heights, int x, int y) {
        int n = heights.length;
        int m = heights[0].length;
        if (x < 0 || y < 0 || x >= n || y >= m) return false;

        return true;

    }

    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[0][0] = 0;

        PriorityQueue<Pair> queue = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.diff - o2.diff;
            }
        });
        queue.add(new Pair(0, 0, 0));

        while (!queue.isEmpty()) {
            Pair p = queue.poll();

            for (int index = 0; index < 4; index++) {
                int xIndex = p.x + fourDirection[index][0];
                int yIndex = p.y + fourDirection[index][1];
                if (isValidDirection(heights, xIndex, yIndex)) {
                    int maxEffort = Math.max(dist[p.x][p.y], Math.abs(heights[p.x][p.y] - heights[xIndex][yIndex]));
                    if (maxEffort < dist[xIndex][yIndex]) {
                        dist[xIndex][yIndex] = maxEffort;
                        queue.add(new Pair(xIndex, yIndex, maxEffort));
                    }
                }
            }
        }

        return dist[n - 1][m - 1];
    }

    public class Pair {
        int x;
        int y;
        int diff;

        Pair(int x, int y, int diff) {
            this.x = x;
            this.y = y;
            this.diff = diff;

        }

    }
}
