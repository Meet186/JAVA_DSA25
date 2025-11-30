package GRAPH.ShortestPathAlgo;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class test {

    static class Edge{
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
    static class pair implements Comparable<pair> {
        int node;
        int distance;

        public pair(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
        @Override
        public int compareTo(pair p2) {
            return this.distance - p2.distance;
        }
    }
    static void dijkstrasAlgo(ArrayList<Edge>[] graph, int src, int V) {
            int[] distance = new int[V];
            boolean[] isVisited = new boolean[V];
            PriorityQueue<pair> queue = new PriorityQueue<>();
        for (int i = 0; i < V; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[src] = 0;
        queue.offer(new pair(src,0));
        while (!queue.isEmpty()){
            pair curr = queue.poll();
            for (int i = 0; i < graph[curr.node].size(); i++) {
                if(!isVisited[curr.node]){
                    isVisited[curr.node] = true;
                    Edge e = graph[curr.node].get(i);
                    int u = e.src;
                    int v = e.dest;
                    // perform relaxtation
                    if(distance[u] != Integer.MAX_VALUE && distance[u] + e.wt < distance[v]){
                        distance[v] = distance[u] + e.wt;
                        queue.offer(new pair(v,distance[v]));
                    }
                }

            }
        }

        for (int num : distance){
            System.out.print(num + " ");
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
        dijkstrasAlgo(graph,0,v);
    }
}
