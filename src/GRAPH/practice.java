package GRAPH;

import GRAPH.ShortestPathAlgo.KosarajusAlgo;
import Sorting.StableCountSort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class practice {

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

    static void kosarajuAlgo(ArrayList<Edge>[] graph,int V){
        // step 1 -> do Topological Sorting
        Stack<Integer> st = new Stack<>();
        boolean[] isViisited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if(!isViisited[i]){
                topologicalSorting(graph,i,isViisited,st);
            }
        }
        // step 2 -> make a transpose graph
        ArrayList<Edge>[] transpose = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            isViisited[i] = false;
            transpose[i] = new ArrayList<>();
        }
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                transpose[e.dest].add(new Edge(e.dest,e.src));
            }
        }
        // do DFS using Stack elements
        while (!st.empty()){
            int curr = st.pop();
            if(!isViisited[curr]){
                DFS(transpose,curr,isViisited);
                System.out.println();
            }
        }
    }
    static void DFS(ArrayList<Edge>[] transpose,int curr,boolean[] isVisited){
        System.out.print(curr + " ");
        isVisited[curr] = true;

        for (int i = 0; i < transpose[curr].size(); i++) {
           Edge e = transpose[curr].get(i);
           if(!isVisited[e.dest]){
               DFS(transpose, e.dest, isVisited);
           }

        }
    }

    static void topologicalSorting( ArrayList<Edge>[] graph,int curr,boolean[] isVisited,Stack<Integer> st){
        isVisited[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(!isVisited[e.dest]){
                topologicalSorting(graph, e.dest, isVisited, st);
            }
        }
        st.push(curr);
    }


    //

    public static void main(String[] args) {

        int V = 5;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        kosarajuAlgo(graph,V);

    }
}
