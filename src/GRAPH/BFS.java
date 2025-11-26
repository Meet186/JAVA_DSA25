package GRAPH;
import HASHMAP.INBULT;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS { // TC - O(V+E)
    static class Edge {
        int src;
        int dest;
        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }
    static void createGraph(ArrayList<Edge> graph[]){
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        // for 0
        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));
        // for 1
        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,3));
        // for 2
        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,4));
        // for 3
        graph[3].add(new Edge(3,1));
        graph[3].add(new Edge(3,4));
        graph[3].add(new Edge(3,5));
        // for 4
        graph[4].add(new Edge(4,2));
        graph[4].add(new Edge(4,3));
        graph[4].add(new Edge(4,5));
        // for 5
        graph[5].add(new Edge(5,3));
        graph[5].add(new Edge(5,4));
        graph[5].add(new Edge(5,6));
        // for 6
        graph[6].add(new Edge(6,5));
    }

    public static void BFS( ArrayList<Edge> graph[],int v){
        Queue<Integer> queue = new LinkedList<>();
        boolean isvisited[] = new boolean[v];
        queue.offer(0); // start point of graph
        while (!queue.isEmpty()){
            int curr = queue.poll();
            if(isvisited[curr] == false){
                System.out.print(curr + " _");
                isvisited[curr] = true;

                // add all neighbours
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    queue.offer(e.dest);
                }
            }
        }
    }
    public static void main(String[] args) {
        int v = 7;
        /*
        1 ----- 3
       /        |  \
      0         |   5 ----- 6
       \        |  /
        2 ----- 4
*/
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);
        BFS(graph,v);


    }
}
