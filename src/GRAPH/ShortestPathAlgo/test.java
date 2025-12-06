package GRAPH.ShortestPathAlgo;


import java.util.ArrayList;
import java.util.Stack;

public class test {

    static class Edge {
        int src;
        int dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    static void createGraph( ArrayList<Edge>[] graph){
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[1].add(new Edge(1,2));
        graph[1].add(new Edge(1,4));

        graph[2].add(new Edge(2,3));

        graph[3].add(new Edge(3,1));

        graph[4].add(new Edge(4,5));

        graph[5].add(new Edge(5,6));

    }

    static void topologicalSort( ArrayList<Edge>[] graph,int curr,boolean[] isVisited,Stack<Integer> st){
        isVisited[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(!isVisited[e.dest]){
                topologicalSort(graph, e.dest, isVisited, st);
            }
        }
        st.push(curr);
    }

    static void SSC(  ArrayList<Edge>[] graph,int V){
        // step 1 -> totological Sorting
        Stack<Integer> st = new Stack<>();
        boolean[] isVisited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if(!isVisited[i]){
                topologicalSort(graph,i,isVisited,st);
            }
        }
        // step 2 -> make transpose graph
        ArrayList<Edge>[] transpose = new ArrayList[V];
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
        while (!st.isEmpty()){
            int curr = st.pop();
            if(!isVisited[curr]){
                dfs(transpose,curr,isVisited);
                System.out.println();
            }
        }
    }
    static void dfs(ArrayList<Edge>[] transpose,int cuur,boolean[] isVisited){
        isVisited[cuur] = true;
        System.out.print(cuur + " ");
        for (int i = 0; i < transpose[cuur].size(); i++) {
            Edge e = transpose[cuur].get(i);
            if(!isVisited[e.dest]){
                dfs(transpose, e.dest, isVisited);
            }
        }
    }


    public static void main(String[] args) {
        int V = 7;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        SSC(graph,V);

    }

}