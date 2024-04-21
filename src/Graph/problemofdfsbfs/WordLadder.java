package Graph.problemofdfsbfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * A transformation sequence from beginWord to endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:
 * - Every adjacent pair of words differs by a single letter.
 * - Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
 * - sk == endWord
 * Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.
 */

public class WordLadder {

    public static void main(String[] args) {
        System.out.println("Rahul khichar");

        String beginWord = "leet", endWord = "code", wordList[] = {"lest", "leet", "lose", "code", "lode", "robe", "lost"};
        WordLadder wordLadder = new WordLadder();
        wordLadder.ladderLength(beginWord, endWord, new ArrayList<>(List.of(wordList)));
    }

    /**
     * Returns the number of words in the shortest transformation sequence from beginWord to endWord.
     *
     * @param beginWord The starting word.
     * @param endWord   The target word.
     * @param wordList  The dictionary of words.
     * @return The length of the shortest transformation sequence, or 0 if no such sequence exists.
     */
    public List<Node> dffByOneLatter(List<String> wordList, String word) {
        List<Node> list = new ArrayList<>();

        for (String temp : wordList) {
            int count = 0;

            for (int index = 0; index < word.length(); index++) {
                if (temp.charAt(index) != word.charAt(index)) count++;
            }

            if (count <= 1) {
                list.add(new Node(temp, null));
            }
        }

        for (Node temp : list) {
            wordList.remove(temp.word);
        }
        if (list.size() >= 1) return list;
        return null;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;
        wordList.add(beginWord);
        Node rootNode = new Node(endWord, null);
        wordList.remove(endWord);

        Queue<Node> queue = new LinkedList<>();
        queue.add(rootNode);

        while (!queue.isEmpty()) {
            Node tempNode = queue.poll();
            tempNode.list = dffByOneLatter(wordList, tempNode.word);
            if (tempNode.list != null) {
                for (Node node : tempNode.list) {
                    queue.add(node);
                }
            }
        }

        List<String> ans = new ArrayList<>();
        isAvailabe(rootNode, beginWord, ans);

        return ans.size();
    }

    public boolean isAvailabe(Node root, String word, List<String> ans) {
        if (root == null) return false;
        if (root.word == word) {
            ans.add(word);
            return true;
        }

        if (root.list != null) {
            for (Node node : root.list) {
                if (isAvailabe(node, word, ans)) {
                    ans.add(root.word);
                    return true;
                }
            }
        }

        return false;
    }



    public class Node {
        String word;
        List<Node> list;

        Node(String word, List<Node> list) {
            this.word = word;
            this.list = list;
        }
    }

}
