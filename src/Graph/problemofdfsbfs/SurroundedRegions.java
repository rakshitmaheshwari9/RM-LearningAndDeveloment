package Graph.problemofdfsbfs;

import java.util.Stack;

public class SurroundedRegions {

    int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {
        System.out.println("Rahul khichar");

        SurroundedRegions surroundedRegions = new SurroundedRegions();
        char[][] board = {{'X', 'O', 'X' }, {'O', 'X', 'O' }, {'X', 'O', 'X' }};

        surroundedRegions.solve(board);

        for (int xIndex = 0; xIndex < board.length; xIndex++) {
            for (int yIndex = 0; yIndex < board[0].length; yIndex++) {

                System.out.printf(board[xIndex][yIndex] + ",");
            }
            System.out.println();
        }
    }

    public boolean isValid(char[][] board, int x, int y) {

        if (x >= 0 && x < board.length && y >= 0 && y < board[0].length && board[x][y] == 'O') return true;
        return false;
    }

    public void bfs(char[][] board, int xIndex, int yIndex) {
        Stack<Pair> st = new Stack<>();

        st.add(new Pair(xIndex, yIndex));

        while (!st.isEmpty()) {

            Pair p = st.pop();
            board[p.x][p.y] = 'N';

            for (int index = 0; index < 4; index++) {
                int X = p.x + direction[index][0];
                int Y = p.y + direction[index][1];
                if (isValid(board, X, Y)) {
                    st.push(new Pair(X, Y));
                }
            }
        }

    }

    public void solve(char[][] board) {


        for (int xIndex = 0; xIndex < board.length; xIndex++) {
            for (int yIndex = 0; yIndex < board[0].length; yIndex++) {

                if (xIndex == 0 || yIndex == 0 || xIndex == board.length - 1 || yIndex == board[0].length-1) {
                    if (board[xIndex][yIndex] == 'O')
                        bfs(board, xIndex, yIndex);
                }
            }
        }

        for (int xIndex = 0; xIndex < board.length; xIndex++) {
            for (int yIndex = 0; yIndex < board[0].length; yIndex++) {
                if (board[xIndex][yIndex] != 'N') {

                    board[xIndex][yIndex] = 'X';
                } else {
                    board[xIndex][yIndex] = 'O';
                }

            }
        }


    }

    public class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
