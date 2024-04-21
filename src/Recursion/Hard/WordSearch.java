package Recursion.Hard;

public class WordSearch {

    public static void main(String[] args) {
        System.out.println("Rahul khichar");

        WordSearch wordSearch = new WordSearch();
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "SE";
        System.out.println(wordSearch.exist(board, word));
    }


    public boolean exist(char[][] board, String word) {
        return isAvailable(board, word, 0, 0, 0);
    }

    public boolean isAvailable(char[][] board, String word, int xIndex, int yIndex, int index) {
        if (index == word.length()) return true;
        if (xIndex < 0 || yIndex < 0 || xIndex >= board.length || yIndex >= board[0].length) return false;

        if (board[xIndex][yIndex] == word.charAt(index)) {
            boolean firstMatchIndex = isAvailable(board, word, xIndex + 1, yIndex, index + 1);
            boolean secondMatchIndex = isAvailable(board, word, xIndex, yIndex + 1, index + 1);
            if (firstMatchIndex || secondMatchIndex) return true;
        }

        boolean firstSolution = isAvailable(board, word, xIndex + 1, yIndex, index);
        boolean secondSolution = isAvailable(board, word, xIndex, yIndex + 1, index);

        return firstSolution || secondSolution;
    }
}
