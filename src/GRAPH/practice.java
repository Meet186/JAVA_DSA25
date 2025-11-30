package GRAPH;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class practice {

    static class Edge {
        int src;
        int dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    public static void createGraph( ArrayList<Edge>[] graph){
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>(); // this is because fill array with empty List of type Edge
        }

        // for 0
        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));
        // for 1
        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,3));
        // for 2
        graph[2].add(new Edge(2,0));
        // for 3
        graph[3].add(new Edge(3,1));
        graph[3].add(new Edge(3,4));
        // for 4
        graph[4].add(new Edge(4,3));
        graph[4].add(new Edge(4,5));
        // for 5
        graph[5].add(new Edge(5,4));
    }
    static void BFS(  ArrayList<Edge>[] graph ,int v){
        Queue<Integer> queue = new LinkedList<>();
        boolean[] isVisited = new boolean[v];
        queue.offer(0);
        while (!queue.isEmpty()){
            int curr = queue.poll();
            if(isVisited[curr] == false){
                System.out.print(curr + " ");
                isVisited[curr] = true;
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    queue.offer(e.dest);
                }
            }
        }
    }

    static void DFS(ArrayList<Edge> graph[], int curr, boolean[] isVisited){
        System.out.print(curr + " ");
        isVisited[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(isVisited[e.dest] == false){
                DFS(graph,e.dest,isVisited);
            }
        }
    }
    public static void main(String[] args) {
             /*

      0 ---- 1   4
       \      \ | \
        2      3   5
*/
        int v = 6; // virtices of graph
        ArrayList<Edge>[] graph = new ArrayList[v];
        createGraph(graph);
//        // print graph 2 neighbours
//        for (int i = 0; i < graph[3].size(); i++) {
//            Edge e = graph[3].get(i);
//            System.out.print(e.dest + " "); // 1 4
//        }
//        BFS(graph,6);
//        DFS(graph,0,new boolean[v]);
        System.out.println(8%4);

    }
}
