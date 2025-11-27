package GRAPH;

import HASHMAP.INBULT;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSort { // TC - O(V + E)

    static class Edge {
        int src;
        int dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }
    static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        // for 2
        graph[2].add(new Edge(2, 3));
        // for 3
        graph[3].add(new Edge(3, 1));
        // for 4
        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));
        // for 5
        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));

    }
    private static void topologicalSorting(ArrayList<Edge> graph[], int curr, boolean[] isVisited, Stack<Integer> st) {
        isVisited[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!isVisited[e.dest]) {
                topologicalSorting(graph, e.dest, isVisited, st);
            }
        }
        st.push(curr);
    }
    public static void topologicalSort(ArrayList<Edge> graph[], int v) {
        boolean[] isVisited = new boolean[v];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < v; i++) {
            if (!isVisited[i]) {
                topologicalSorting(graph, i, isVisited, st);
            }
        }
        // stack fill with sort
        while (!st.isEmpty()) {
            System.out.print(st.pop() + " ");
        }
    }

    public static void main(String[] args) {
        /*
        valid only on DAG Graph - Directed , No-cycle Graph
        Graph (Directed Acyclic Graph used for Topological Sort)
          5 -----> 0 <----- 4
          |                  |
          v                  v
          2 -----> 3 -----> 1
      Edges:
      5 -> 0
      5 -> 2
      4 -> 0
      4 -> 1
      2 -> 3
      3 -> 1
     One valid Topological Order:
     5 4 2 3 1 0
     (Order may vary based on DFS starting node)
*/
        int v = 6;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);
        topologicalSort(graph, v);
    }
}
