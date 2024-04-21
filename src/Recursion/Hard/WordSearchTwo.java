package Recursion.Hard;

import java.util.ArrayList;
import java.util.List;

public class WordSearchTwo {
    public static void main(String[] args) {
        System.out.println("Here we are going to solve hard problem of word search in Matrix");
    }


    public static boolean searchMatrix(char[][] board, String word, int xIndex, int yIndex, int index, boolean vis[][]) {
        if (index == word.length()) return true;

        if (xIndex < 0 || yIndex < 0 || xIndex >= board.length || yIndex >= board[0].length || vis[xIndex][yIndex] || board[xIndex][yIndex] != word.charAt(index))
            return false;
        vis[xIndex][yIndex] = true;
        boolean xDirection = searchMatrix(board, word, xIndex + 1, yIndex, index + 1, vis);
        boolean yDirection = searchMatrix(board, word, xIndex - 1, yIndex, index + 1, vis);
        boolean upDirection = searchMatrix(board, word, xIndex, yIndex + 1, index + 1, vis);
        boolean downDirection = searchMatrix(board, word, xIndex, yIndex - 1, index + 1, vis);
        vis[xIndex][yIndex] = false;
        return xDirection || yDirection || upDirection || downDirection;
    }

    public static boolean exist(char[][] board, String word) {

        boolean vis[][] = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {

                if (board[i][j] == word.charAt(0)) {
                    if (searchMatrix(board, word, i, j, 0, vis)) return true;
                }
            }
        }
        return false;
    }

    public static List<String> findWords(char[][] board, String[] words) {


        List<String> ans = new ArrayList<>();

        for (String str : words) {
            if (exist(board, str)) ans.add(str);
        }
        return ans;


    }
}
