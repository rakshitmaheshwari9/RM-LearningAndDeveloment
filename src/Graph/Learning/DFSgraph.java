package Graph.Learning;

import java.util.ArrayList;
import java.util.Stack;

public class DFSgraph {

    public static void main(String[] args) {
        System.out.println("Rahul khichar");
    }


    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {

        ArrayList<Integer> ans = new ArrayList<>();
        boolean vis[] = new boolean[V];

        Stack<Integer> st = new Stack<>();
        st.add(0);
        while (!st.isEmpty()) {


            int node = st.pop();
            if (!vis[node]) {
                ans.add(node);
                vis[node] = true;
                ArrayList<Integer> tempList = adj.get(node);

                for (int index = 0; index < tempList.size(); index++) {
                    st.push(adj.get(node).get(index));
                }
            }


        }
        return ans;
    }
}
