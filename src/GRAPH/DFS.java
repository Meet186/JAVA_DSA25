package GRAPH;
import java.util.ArrayList;
public class DFS {
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
        // create a graph
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
    static void printVertixNeighbour(ArrayList<Edge> graph[],int vertix){
        for (int i = 0; i < graph[vertix].size(); i++) {
            Edge e = graph[vertix].get(i);
            System.out.print(e.dest + " ");
        }
    }
    static void DFS( ArrayList<Edge> graph[],int curr,boolean[] isVisited){
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
        int v = 7;
        /*
        1 ----- 3
       /        |  \
      0         |   5 ----- 6
       \        |  /
        2 ----- 4
*/
        ArrayList<Edge> graph[] = new ArrayList[v];
        boolean[] isVisited = new boolean[v];
        createGraph(graph);
//        printVertixNeighbour(graph,3);
        DFS(graph,0,isVisited);
    }
}
