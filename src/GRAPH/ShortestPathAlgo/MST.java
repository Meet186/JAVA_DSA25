package GRAPH.ShortestPathAlgo;


import java.util.ArrayList;
import java.util.PriorityQueue;

public class MST { // Prim's Algo

    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0,1,10));
        graph[0].add(new Edge(0,2,15));
        graph[0].add(new Edge(0,3,30));

        graph[1].add(new Edge(1,0,10));
        graph[1].add(new Edge(1,3,40));

        graph[2].add(new Edge(2,0,15));
        graph[2].add(new Edge(2,3,50));

        graph[3].add(new Edge(3,0,30));
        graph[3].add(new Edge(3,1,40));
        graph[3].add(new Edge(3,2,50));
    }

    static class pair implements Comparable<pair> {
        int node;
        int cost;

        public pair(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo(pair o) {
            return this.cost - o.cost;
        }
    }

    public static int MST_PRIMS(ArrayList<Edge>[] graph,int src,int V) { // TC - O(ElogE)
        boolean[] isVisited = new boolean[V];
        int ans = 0;
        PriorityQueue<pair> pq = new PriorityQueue<>();
        pq.offer(new pair(src,0));
        while (!pq.isEmpty()){
            pair curr = pq.poll();
            if(!isVisited[curr.node]){
                isVisited[curr.node] = true;
                ans += curr.cost;
                for (int i = 0; i < graph[curr.node].size(); i++) {
                    Edge e = graph[curr.node].get(i);
                    if(!isVisited[e.dest]){
                        pq.offer(new pair(e.dest,e.wt));
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int v = 4;
        ArrayList<Edge>[] graph = new ArrayList[v];
        createGraph(graph);
        System.out.println(MST_PRIMS(graph,0,v));
    }


}
