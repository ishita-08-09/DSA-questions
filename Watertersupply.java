import java.util.*;

public class Solution {

    static class Edge {
        int u;
        int v;
        int cost;

        Edge(int u, int v, int cost) {
            this.u = u;
            this.v = v;
            this.cost = cost;
        }
    }

    static int find(int x, int[] parent) {
        if(parent[x] != x) {
            parent[x] = find(parent[x], parent);
        }
        return parent[x];
    }

    static void union(int a, int b, int[] parent) {
        int pa = find(a, parent);
        int pb = find(b, parent);

        if(pa != pb) {
            parent[pa] = pb;
        }
    }

    public static int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {

        ArrayList<Edge> edges = new ArrayList<>();

        for(int i = 1; i <= n; i++) {
            edges.add(new Edge(0, i, wells[i-1]));
        }

        for(int i = 0; i < pipes.length; i++) {
            edges.add(new Edge(pipes[i][0], pipes[i][1], pipes[i][2]));
        }

        Collections.sort(edges, (a, b) -> a.cost - b.cost);

        int[] parent = new int[n+1];
        for(int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        int totalCost = 0;

        for(Edge e : edges) {

            int pu = find(e.u, parent);
            int pv = find(e.v, parent);

            if(pu != pv) {
                union(pu, pv, parent);
                totalCost += e.cost;
            }
        }

        return totalCost;
    }
}