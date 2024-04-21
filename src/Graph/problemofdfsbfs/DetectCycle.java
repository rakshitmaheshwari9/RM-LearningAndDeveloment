package Graph.problemofdfsbfs;

import java.util.List;
import java.util.Stack;

public class DetectCycle {

    public static void main(String[] args) {
        System.out.println("Rahul khichar");
    }

    boolean detectCycle(int V, List<List<Integer>> adj) {
        boolean[] vis = new boolean[V + 1];

        for (int index = 0; index < V; index++) {

            if (!vis[index + 1]) {

                Stack<Pair<Integer>> st = new Stack<>();
                st.add(new Pair<>(index + 1, -1));
                while (!st.isEmpty()) {
                    Pair pair = st.pop();
                    if (vis[(int) pair.currentNode]) return true;
                    vis[(int) pair.currentNode] = true;

                    List<Integer> list = adj.get((int) pair.currentNode);
                    list.remove(pair.parentNode);

                    for (int node : list) {
                        st.add(new Pair<>(node, (int) pair.currentNode));
                    }


                }


            }
        }

        return false;
    }

    public class Pair<T> {

        public T parentNode;
        public T currentNode;

        Pair(T currentNode, T parentNode) {
            this.currentNode = currentNode;
            this.parentNode = parentNode;
        }

    }
}
