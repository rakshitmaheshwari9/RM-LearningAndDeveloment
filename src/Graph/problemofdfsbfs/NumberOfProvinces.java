package Graph.problemofdfsbfs;

import java.util.Stack;

public class NumberOfProvinces {

    public static void main(String[] args) {
        System.out.println("Rahul khichar");

        int[][] input = {
                {
                        1, 1, 0
                }, {
                1, 1, 0
        }, {
                0, 0, 1
        }
        };
        NumberOfProvinces numberOfProvinces = new NumberOfProvinces();
        System.out.println(numberOfProvinces.findCircleNum(input));

    }

    public int findCircleNum(int[][] isConnected) {

        int n = isConnected.length;
        int ans = 0;

        boolean[] vis = new boolean[n];

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                stack.add(i);
                ans++;
                while (!stack.isEmpty()) {
                    int element = stack.pop();
                    if (!vis[element]) {
                        vis[element]=true;
                        for (int index = 0; index < n; index++) {
                            if (index != element) {
                                if (isConnected[element][index] == 1) {
                                    stack.add(index);
                                }
                            }
                        }
                    }

                }
            }

        }

        return ans;

    }
}
