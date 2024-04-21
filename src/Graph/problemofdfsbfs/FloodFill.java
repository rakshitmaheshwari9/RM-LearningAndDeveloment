package Graph.problemofdfsbfs;

public class FloodFill {

    int xDirection[] = {1, 0, 0, -1};
    int yDirection[] = {0, -1, 1, 0};

    public static void main(String[] args) {
        System.out.println("Rahul khichar");

        int image[][] = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        FloodFill floodFill = new FloodFill();
        floodFill.floodFill(image, 1, 1, 2);

        for (int xIndex = 0; xIndex < image.length; xIndex++) {
            for (int yIndex = 0; yIndex < image[xIndex].length; yIndex++) {

                System.out.printf(image[xIndex][yIndex] + " ");
            }
            System.out.println();
        }
    }

    public void fill(int[][] image, boolean vis[][], int xIndex, int yIndex, int color, int fillColor) {

        if (!vis[xIndex][yIndex] && image[xIndex][yIndex] == color) {
            vis[xIndex][yIndex] = true;
            for (int index = 0; index < 4; index++) {
                int X = xDirection[index]+xIndex;
                int Y = yDirection[index]+yIndex;
                if (X >= 0 && X < image[0].length && Y >= 0 && Y < image.length && image[X][Y] == fillColor) {
                    image[X][Y] = color;
                    fill(image, vis, X, Y, color, fillColor);
                }
            }

        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        boolean vis[][] = new boolean[m][n];
        int fillColor = image[sr][sc];
        image[sr][sc] = color;
        fill(image, vis, sr, sc, color, fillColor);
        return image;

    }
}
