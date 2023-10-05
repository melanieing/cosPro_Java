package graph;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindParent94339 {

    public int[] parent;
    public List<List<Integer>> adj;

    public static void main(String[] args) {
        FindParent94339 q = new FindParent94339();
        int n = 6;
        int[][] adjacent = {{1,4},{2,4},{5,6},{6,1},{6,3}};
        int root = 1;

        System.out.println(Arrays.toString(q.solution(n, adjacent, root)));
    }

    public void dfs(int cur) {
        System.out.println("cur : " + cur);
        System.out.println("adj.get(cur) : " + adj.get(cur));
        for (int next : adj.get(cur)) {
            if (parent[cur] != next) {
                parent[cur] = next;
                dfs(next);
            }
        }
    }

    public int[] solution(int n, int[][] adjacent, int root) {
        parent = new int[n+1];
        adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : adjacent) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        dfs(root);

        int[] answer = new int[n];
        for (int i = 1; i <= n; i++) {
            answer[i-1] = parent[i];
        }

        return answer;
    }
}
