package GRAPH;

import GRAPH.ShortestPathAlgo.DijkstrasAlgo;
import GRAPH.ShortestPathAlgo.KosarajusAlgo;
import Sorting.StableCountSort;

import java.util.*;

public class practice {

    static class Edge {
        int src;
        int dest;
        int wt;


        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;

        }
    }

    public static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));
        graph[0].add(new Edge(0,3));

        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,2));

        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,2));

        graph[3].add(new Edge(3,0));
        graph[3].add(new Edge(3,4));
        graph[3].add(new Edge(3,5));

        graph[4].add(new Edge(4,3));
        graph[4].add(new Edge(4,5));

        graph[5].add(new Edge(5,3));
        graph[5].add(new Edge(5,4));
    }

    static class pair implements Comparable<pair> {
        int node;
        int distance;

        public pair(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }

        @Override
        public int compareTo(pair o) {
            return this.distance - o.distance;
        }
    }

    public static int[] dijestraAlgo( ArrayList<Edge>[] graph,int src,int V){
        boolean[] isVisited = new boolean[V];
        int[] distance = new int[V];
        for (int i = 0; i < V; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[src] = 0;
        PriorityQueue<pair> pq = new PriorityQueue<>();
        pq.offer(new pair(src,0));

        while (!pq.isEmpty()){
            pair curr = pq.poll();
            if(!isVisited[curr.node]){
                isVisited[curr.node] = true;
                for (int i = 0; i < graph[curr.node].size(); i++) {
                    Edge e = graph[curr.node].get(i);
                    int u = e.src;
                    int v = e.dest;

                    if (  distance[u] + e.wt < distance[v]){
                        distance[v] = distance[u] + e.wt;
                    }
                    pq.offer(new pair(v,distance[v]));
                }
            }
        }
        return distance;
    }

    static int[] bellmanForrd( ArrayList<Edge>[] graph,int src,int V){
        int[] distance = new int[V];
        for (int i = 0; i < V; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[src] = 0;
        for(int k=0; k < V-1; k++){

            for (int i = 0; i < V; i++) {
                for (int j = 0; j < graph[i].size(); j++) {
                    Edge e = graph[i].get(j);
                    int u = e.src;
                    int v = e.dest;

                    if(distance[u] != Integer.MAX_VALUE && distance[u] + e.wt < distance[v]){
                        distance[v] = distance[u] + e.wt;
                    }

                }

            }
        }

        return distance;

    }

    static void BridgeInGraph( ArrayList<Edge>[] graph,int V){
        int[] discoveryTime = new int[V];
        int[] lowestDiscoveryTime = new int[V];
        boolean[] isVisited = new boolean[V];
        int time = 0;
        for (int i = 0; i < V; i++) {
            if(!isVisited[i]){
                dfs(graph,i,discoveryTime,lowestDiscoveryTime,isVisited,time,-1);
            }

        }
    }

    private static void dfs(ArrayList<Edge>[] graph, int curr, int[] discoveryTime, int[] lowestDiscoveryTime, boolean[] isVisited, int time, int parent) {
        isVisited[curr] = true;
        discoveryTime[curr] = lowestDiscoveryTime[curr] = ++time;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(e.dest == parent){
                continue;
            } else if (!isVisited[curr]) {
                dfs(graph, e.dest, discoveryTime, lowestDiscoveryTime, isVisited, time, curr);
                lowestDiscoveryTime[curr] = Math.min(lowestDiscoveryTime[curr],lowestDiscoveryTime[e.dest]);

                if(discoveryTime[curr] < lowestDiscoveryTime[e.dest]){
                    System.out.println("Bridge exist from : " + curr + "----" + e.dest);
                }

            } else {
                lowestDiscoveryTime[curr] = Math.min(discoveryTime[curr],lowestDiscoveryTime[e.dest]);
            }


        }
    }

    public static void main(String[] args) {

        int V = 6;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
//       int[] ans = dijestraAlgo(graph,0,V);
//       int[] ans2 = bellmanForrd(graph,0,V);
//        System.out.println(Arrays.toString(ans2));
//        System.out.println(Arrays.toString(ans));
        BridgeInGraph(graph,V);

    }
}
