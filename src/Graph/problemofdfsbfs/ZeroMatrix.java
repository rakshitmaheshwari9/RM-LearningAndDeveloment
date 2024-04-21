package Graph.problemofdfsbfs;

import java.util.LinkedList;
import java.util.Queue;

public class ZeroMatrix {


    public static void main(String[] args) {
        System.out.println("Rahul khichar");
        //will do it next up

        int[][] grapth = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};

        ZeroMatrix zeroMatrix = new ZeroMatrix();

        zeroMatrix.dfs(grapth);
        for (int xIndex = 0; xIndex < grapth.length; xIndex++) {
            for (int yIndex = 0; yIndex < grapth[0].length; yIndex++) {
                System.out.printf(grapth[xIndex][yIndex] + ",");
            }
            System.out.println("Rahul khichar");
        }
    }

    int direction[][] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public void dfs(int[][] graph) {
        int n = graph.length;
        int m = graph[0].length;

        boolean vis[][] = new boolean[n][m];


        Queue<Pair> queue = new LinkedList<>();
        for (int xIndex = 0; xIndex < graph.length; xIndex++) {
            for (int yIndex = 0; yIndex < graph[xIndex].length; yIndex++) {
                if (graph[xIndex][yIndex] == 0) {
                    vis[xIndex][yIndex] = true;
                    queue.add(new Pair(xIndex, yIndex, 0));
                }
            }
        }
        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int number = 0; number < size; number++) {
                Pair p = queue.poll();


                for (int index = 0; index < 4; index++) {

                    int xIndex = p.x + direction[index][0];
                    int yIndex = p.y + direction[index][1];
                    if (isValid(graph, xIndex, yIndex) && !vis[xIndex][yIndex]) {
                        graph[xIndex][yIndex] = graph[p.x][p.y] + 1;
                        vis[xIndex][yIndex] = true;
                        queue.add(new Pair(xIndex, yIndex, graph[xIndex][yIndex]));
                    }
                }

            }


        }

    }

    public boolean isValid(int[][] graph, int x, int y) {
        if (x < 0 || x >= graph.length || y < 0 || y >= graph[0].length) return false;
        return true;

    }

    public class Pair {


        public int x;
        public int y;

        Pair(int x, int y, int val) {
            this.x = x;
            this.y = y;
        }


    }


}
