package GRAPH;

import java.util.ArrayList;

public class ArticulationPoint {

    static class Edge {
        int src;
        int dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    static int time = 0;   // ✅ GLOBAL TIME

    static void createGraph(ArrayList<Edge>[] graph) {
        // Initialize array lists
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // Add edges
        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));
        graph[0].add(new Edge(0,3));

        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,2));

        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,1));

        graph[3].add(new Edge(3,0));
        graph[3].add(new Edge(3,4));

        graph[4].add(new Edge(4,3));
    }

    public static void getAP(ArrayList<Edge>[] graph, int V) {
        int[] dt = new int[V];
        int[] low = new int[V];
        boolean[] isVisited = new boolean[V];
        boolean[] ap = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!isVisited[i]) {
                dfs(graph, i, -1, dt, low, isVisited, ap);
            }
        }

        System.out.println("Articulation Points:");
        for (int i = 0; i < V; i++) {
            if (ap[i]) {
                System.out.println(i);   // ✅ PRINT NODE
            }
        }
    }

    static void dfs(ArrayList<Edge>[] graph, int curr, int par,
                    int[] dt, int[] low, boolean[] isVisited, boolean[] ap) {

        isVisited[curr] = true;
        dt[curr] = low[curr] = ++time;
        int children = 0;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            int neigh = e.dest;

            if (par == neigh) continue;

            if (isVisited[neigh]) {
                // Back-edge
                low[curr] = Math.min(low[curr], dt[neigh]);
            } else {
                dfs(graph, neigh, curr, dt, low, isVisited, ap);

                low[curr] = Math.min(low[curr], low[neigh]);

                // Articulation Point Check
                if (dt[curr] <= low[neigh] && par != -1) {
                    ap[curr] = true;
                }

                children++;
            }
        }

        // Special case for root
        if (par == -1 && children > 1) {
            ap[curr] = true;
        }
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge>[] graph = new ArrayList[V];

        createGraph(graph);   // ✅ IMPORTANT
        getAP(graph, V);
    }
}
