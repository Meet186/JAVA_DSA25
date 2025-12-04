package GRAPH.ShortestPathAlgo;

import java.util.ArrayList;

public class BellmanFordAlgo {
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

    static void createGraph( ArrayList<Edge>[] graph){
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0,1,2));
        graph[0].add(new Edge(0,2,4));

        graph[1].add(new Edge(1,2,-4));

        graph[2].add(new Edge(2,3,2));
        graph[3].add(new Edge(3,4,4));
        graph[4].add(new Edge(4,1,-1));
    }
    public static void bellmanFord( ArrayList<Edge>[] graph,int src,int v){ // TC - O(E.V)
        // fail for -ve weight cycle
        int dist[] = new int[v];
        for (int i = 0; i < dist.length; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[src] = 0;
        for(int k=0; k < v-1; k++){
            // perform relextation
            for (int i = 0; i < v; i++) {
                for (int j = 0; j < graph[i].size(); j++) {
                    Edge e = graph[i].get(j);
                    int u = e.src;
                    int V = e.dest;
                    if(dist[u] != Integer.MAX_VALUE && dist[u] + e.wt < dist[V]){
                        dist[V] = dist[u] + e.wt;
                    }
                }
            }
        }
        for(int num : dist){
            System.out.print(num + " ");
        }

    }
    public static void main(String[] args) {
        int v = 5;
        ArrayList<Edge>[] graph = new ArrayList[v];
        createGraph(graph);
        bellmanFord(graph,0,v);
    }
}
