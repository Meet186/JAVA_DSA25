package GRAPH;
import java.util.ArrayList;
public class cycleInDirectedGraph {
    static class Edge {
        int src;
        int dest;
        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }
    static void createGraph( ArrayList<Edge> graph[]){
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        // for 0
        graph[0].add(new Edge(0,2));
        // for 1
        graph[1].add(new Edge(1,0));
        // for 2
        graph[2].add(new Edge(2,3));
        // for 3
        graph[3].add(new Edge(3,0));
    }
    static boolean isCycle( ArrayList<Edge> graph[],int curr,boolean[] isVisited,boolean[] recStack){
        isVisited[curr] = true;
        recStack[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(recStack[e.dest] == true){
                return true;
            } else if (isVisited[e.dest] == false) {
                if(isCycle(graph,e.dest,isVisited,recStack)){
                    return true;
                }
            }
        }
        recStack[curr] = false;
        return false;
    }
    public static void main(String[] args) {
        int v = 4;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);
        System.out.println(isCycle(graph,0,new boolean[v],new boolean[v]));
    }
}
