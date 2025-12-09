package GRAPH.ShortestPathAlgo;


import java.util.ArrayList;
import java.util.Arrays;


public class test {

    static class Edge {
        int src;
        int dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 2));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
    }
//
//    static void topologicalSort( ArrayList<Edge>[] graph,int curr,boolean[] isVisited,Stack<Integer> st){
//        isVisited[curr] = true;
//        for (int i = 0; i < graph[curr].size(); i++) {
//            Edge e = graph[curr].get(i);
//            if(!isVisited[e.dest]){
//                topologicalSort(graph, e.dest, isVisited, st);
//            }
//        }
//        st.push(curr);
//    }
//
//    static void SSC(  ArrayList<Edge>[] graph,int V){
//        // step 1 -> totological Sorting
//        Stack<Integer> st = new Stack<>();
//        boolean[] isVisited = new boolean[V];
//        for (int i = 0; i < V; i++) {
//            if(!isVisited[i]){
//                topologicalSort(graph,i,isVisited,st);
//            }
//        }
//        // step 2 -> make transpose graph
//        ArrayList<Edge>[] transpose = new ArrayList[V];
//        for (int i = 0; i < transpose.length; i++) {
//            isVisited[i] = false;
//            transpose[i] = new ArrayList<>();
//        }
//
//        for (int i = 0; i < V; i++) {
//            for (int j = 0; j < graph[i].size(); j++) {
//                Edge e = graph[i].get(j);
//                transpose[e.dest].add(new Edge(e.dest,e.src));
//            }
//        }
//        while (!st.isEmpty()){
//            int curr = st.pop();
//            if(!isVisited[curr]){
//                dfs(transpose,curr,isVisited);
//                System.out.println();
//            }
//        }
//    }
//    static void dfs(ArrayList<Edge>[] transpose,int cuur,boolean[] isVisited){
//        isVisited[cuur] = true;
//        System.out.print(cuur + " ");
//        for (int i = 0; i < transpose[cuur].size(); i++) {
//            Edge e = transpose[cuur].get(i);
//            if(!isVisited[e.dest]){
//                dfs(transpose, e.dest, isVisited);
//            }
//        }
//    }
//
//    static void quickSort(int[] arr,int si,int ei){
//        if(si >= ei) return;
//        int piviot = partation(arr,si,ei);
//        quickSort(arr, si, piviot-1);
//        quickSort(arr, piviot+1, ei);
//    }
//    static void swap(int[] arr,int si,int ei){
//        int temp = arr[si];
//        arr[si] = arr[ei];
//        arr[ei] = temp;
//    }
//
//    static int partation(int[] arr,int si,int ei){
//        int piviot = arr[si];
//        int count = 0;
//        for (int i = si + 1; i <= ei ; i++) {
//            if(arr[i] <= piviot){
//                count++;
//            }
//        }
//        int piviotIndex = si + count;
//        swap(arr, si, piviotIndex);
//        int i = si;
//        int j = ei;
//
//        while (i < piviotIndex && j > piviotIndex){
//            while (arr[i] <= piviot) i++;
//            while (arr[j] > piviot) j--;
//
//            if(i < piviotIndex && j > piviotIndex){
//                swap(arr,i,j);
//                i++;
//                j--;
//            }
//
//        }
//        return piviotIndex;
//    }

    static void getBridge(ArrayList<Edge>[] graph, int V) {
        int[] discoveryTime = new int[V];
        int[] lowestDescoverTime = new int[V];
        boolean[] isVisited = new boolean[V];
        int time = 0;
        for (int i = 0; i < V; i++) {
            if (!isVisited[i]) {
                DFS(graph, isVisited,i ,discoveryTime, lowestDescoverTime, time, -1);
            }
        }
    }

    private static void DFS(ArrayList<Edge>[] graph,boolean[] isVisied ,int curr, int[] discoveryTime, int[] lowestDescoverTime, int time, int parent) {
        isVisied[curr] = true;
        discoveryTime[curr] = lowestDescoverTime[curr] = ++time;
        for (int i = 0; i < graph[curr].size() ; i++) {
            Edge e = graph[curr].get(i);
            if(e.dest == parent) {
                continue;
            } else if (!isVisied[e.dest]) {
                DFS(graph, isVisied, e.dest, discoveryTime, lowestDescoverTime, time, curr);
                lowestDescoverTime[curr] = Math.min(lowestDescoverTime[curr],lowestDescoverTime[e.dest]);
                if(discoveryTime[curr] < lowestDescoverTime[e.dest]){
                    System.out.println("Bridge exist from : " + curr + "------" + e.dest);
                }
            } else {
                lowestDescoverTime[curr] = Math.min(lowestDescoverTime[curr],discoveryTime[e.dest]);
            }
        }
    }

    static void cyclicSort(int[] arr){
        int i = 0;
        while (i < arr.length){
            int correctIndex = arr[i] ; // for zero based index
            if( arr[i] != arr[correctIndex]){
                int temp = arr[i];
                arr[i] = arr[correctIndex];
                arr[correctIndex] = temp;
            } else {
                i++;
            }
        }
    }
    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        getBridge(graph,V);
//        SSC(graph,V);
//        int[] arr = {7,8,91,2,3,2,3,4,5};
//        quickSort(arr,0,arr.length-1);
//        System.out.println(Arrays.toString(arr));
        int[] arr = {4,0,2,3,1};
        cyclicSort(arr);
        System.out.println(Arrays.toString(arr));



    }

}