package GRAPH;

import java.util.ArrayList;

public class CycleInUnDirectedGraph {
    static class Edge{
        int src;
        int dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }
    static void createGraph(ArrayList<Edge> graph[]){ // TC - O(V + E)
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        // for 0
        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,4));
        // for 1
        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,2));
        graph[1].add(new Edge(1,4));
        // for 2
        graph[2].add(new Edge(2,1));
        graph[2].add(new Edge(2,3));
        // for 3
        graph[3].add(new Edge(3,2));
        // for 4
        graph[4].add(new Edge(4,0));
        graph[4].add(new Edge(4,1));
        graph[4].add(new Edge(4,5));
        // for 5
        graph[5].add(new Edge(5,4));
    }
    private static boolean isCycle(ArrayList<Edge> graph[],boolean[] isVisited,int curr,int parent){
        isVisited[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(isVisited[e.dest] && e.dest != parent){
                return true;
            } else if (!isVisited[e.dest]) {
               if( isCycle(graph,isVisited,e.dest,curr)){
                   return true;
               }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        /*
              1 ------ 2
            /  |       |
          0    |       |
           \   |       |
              4        3
                 \
                   5

         */
        int v = 6;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);
        System.out.println( isCycle(graph,new boolean[6],0,-1));
    }
}
