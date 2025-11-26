package GRAPH;

import java.util.ArrayList;

public class AdjacencyListWight {
    static class Edge {
        int src;
        int dest;
        int weight;

        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    public static void createGraph( ArrayList<Edge> graph[]){
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0,1,-10));

        graph[1].add(new Edge(1,2,5));
        graph[1].add(new Edge(1,3,12));

        graph[2].add(new Edge(2,1,5));
        graph[2].add(new Edge(2,3,3));

        graph[3].add(new Edge(3,1,12));
        graph[3].add(new Edge(3,2,3));

    }

    public static void main(String[] args) {
        int v =  4;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);
        // print 3 all data
        for (int i = 0; i < graph[3].size(); i++) {
            Edge e = graph[3].get(i);
            System.out.println("SRC->" + e.src + "DEST->" + e.dest + "WEIGHT->" + e.weight);

        }

    }

}
