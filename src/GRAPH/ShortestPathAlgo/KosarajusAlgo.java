package GRAPH.ShortestPathAlgo;

import java.util.ArrayList;
import java.util.Stack;



public class KosarajusAlgo {
    static class Edge {
        int src;
        int dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }
    public static void createGraph(ArrayList<Edge>[] graph){
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0,2));
        graph[0].add(new Edge(0,3));

        graph[1].add(new Edge(1,0));

        graph[2].add(new Edge(2,1));

        graph[3].add(new Edge(3,4));
    }


    private static void topologicalSort(ArrayList<Edge>[] graph, int curr, boolean[] isVisited, Stack<Integer> st) {
        isVisited[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(!isVisited[e.dest]){
                topologicalSort(graph, e.dest, isVisited, st);
            }
        }
        st.push(curr);
    }

    public static void kosarajuAlgo(ArrayList<Edge>[] graph,int V){
        // step 1 -> Do Topological Sorting
        Stack<Integer> st = new Stack<>();
        boolean[] isVisited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if(!isVisited[i]){
                topologicalSort(graph,i,isVisited,st);
            }
        }
        // step 2 -> transpose the Graph
        ArrayList<Edge> transpose[] = new ArrayList[V];
        for (int i = 0; i < transpose.length; i++) {
            isVisited[i] = false;
            transpose[i] = new ArrayList<>();
        }
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                transpose[e.dest].add(new Edge(e.dest,e.src));
            }
        }
        // step 3 -> perform dfs using the stack
        while (!st.isEmpty()){
            int curr = st.pop();
            if(!isVisited[curr]){
                dfs(transpose,curr,isVisited);
                System.out.println();
            }
        }

    }

    private static void dfs(ArrayList<Edge>[] transpose,int curr,boolean[] isVisited){
        isVisited[curr] = true;
        System.out.print(curr + " ");
        for (int i = 0; i < transpose[curr].size(); i++) {
            Edge e = transpose[curr].get(i);
            if(!isVisited[e.dest]){
                dfs(transpose, e.dest, isVisited);
            }

        }
    }
    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        kosarajuAlgo(graph,V);
    }
}
