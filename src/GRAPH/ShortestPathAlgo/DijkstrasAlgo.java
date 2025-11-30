package GRAPH.ShortestPathAlgo;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class DijkstrasAlgo {

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
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1,2,1));
        graph[1].add(new Edge(1,3,7));

        graph[2].add(new Edge(2,4,3));

        graph[3].add(new Edge(3,5,1));

        graph[4].add(new Edge(4,3,2));
        graph[4].add(new Edge(4,5,5));

    }
    public static class pair implements Comparable<pair>{
        int node;
        int dist;
        public pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
        @Override
        public int compareTo(pair p2 ) {
            return this.dist-p2.dist; // ascending order
        }
    }
    public static void dijkstra(ArrayList<Edge>[] graph,int src,int V){ // TC - O(E + ElogV)
        PriorityQueue<pair> pq = new PriorityQueue<>();
        int dist[] = new int[V];
        for (int i = 0; i < V; i++) {
            if(i != src){
                dist[i] = Integer.MAX_VALUE;
            }
        }
        boolean isVisited[] = new boolean[V];
        pq.add(new pair(0,0));
        while (!pq.isEmpty()){
            pair curr = pq.remove();
            if(!isVisited[curr.node]){
                isVisited[curr.node] = true;
                for (int i = 0; i < graph[curr.node].size(); i++) {
                    Edge e = graph[curr.node].get(i);
                    int u =e.src;
                    int v = e.dest;
                    if(dist[u] + e.wt < dist[v] ){
                        dist[v] = dist[u] + e.wt;
                        pq.add(new pair(v,dist[v]));
                    }

                }
            }

        }
        for (int i = 0; i < V; i++) {
            System.out.print(dist[i] + " ");
        }

    }

    public static void main(String[] args) {
        /*
        (2)        (7)        (1)
     0 -----> 1 --------> 3 ------> 5
     \        \         ^
     (4)\      (1)\      / (2)
       v        v    /
        2 -----> 4 --+----> 5
            (3)        (5)


        Adjacency list (directed, weighted):

        0 -> 1(2), 2(4)
        1 -> 2(1), 3(7)
        2 -> 4(3)
        3 -> 5(1)
        4 -> 3(2), 5(5)
        5 -> (no outgoing edges)
*/

        int v = 6;
        ArrayList<Edge>[] graph = new ArrayList[v];
        createGraph(graph);
        dijkstra(graph,0,v);
    }
}
