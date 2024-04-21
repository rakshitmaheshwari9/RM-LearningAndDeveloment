package Graph.problemofdfsbfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordLadderSecondProblem {

    public static void main(String[] args) {
        System.out.println("Rahul khichar");

        String beginWord = "hit", endWord = "cog", wordLis[] = {"hot", "dot", "dog", "lot", "log", "cog"};

        WordLadderSecondProblem wordLadderSecondProblem = new WordLadderSecondProblem();

        List<String> inputList = new ArrayList<>();

        for (String word : wordLis) {
            inputList.add(word);
        }


        List<List<String>> list = wordLadderSecondProblem.findLadders(beginWord, endWord, inputList);

    }

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

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return new ArrayList<>();
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

        List<List<String>> ans = isAvailabe(rootNode, beginWord);

        return ans;
    }

    public List<List<String>> isAvailabe(Node root, String word) {
        if (root == null) return null;
        List<List<String>> list = new ArrayList<>();

        if (root.word == word) {
            List<String> tempList = new ArrayList<>();
            tempList.add(word);
            list.add(tempList);
            return list;

        }

        if (root.list != null) {
            for (Node node : root.list) {

                List<List<String>> tempList = isAvailabe(node, word);
                if (tempList != null) {

                    for (List<String> l : tempList) {
                        l.add(word);
                        list.add(l);
                    }
                }

            }
        }

        return list;
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
