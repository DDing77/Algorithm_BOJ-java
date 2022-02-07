//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.Comparator;
//import java.util.PriorityQueue;
//import java.util.StringTokenizer;
//
//public class Main {
//    static int V, E, start;
//    static int[] dist;
//
//    static class Edge {
//        int to, weight;
//
//        public Edge(int to, int weight) {
//            this.to = to;
//            this.weight = weight;
//        }
//    }
//
//    static class Info {
//        int idx, dist;
//
//        public Info(int idx, int dist) {
//            this.idx = idx;
//            this.dist = dist;
//        }
//    }
//
//    static ArrayList<Edge>[] edges;
//
//    static void dijkstra(int start) {
//        for (int i = 1; i <= V; i++) dist[i] = Integer.MAX_VALUE;
//
//        PriorityQueue<Info> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.dist));
//        pq.add(new Info(start, 0));
//        dist[start] =0;
//
//        while(!pq.isEmpty()) {
//            Info info = pq.poll();
//            if(dist[info.idx] < info.dist) continue;
//            for(Edge e : edges[info.idx]) {
//                if(dist[info.idx] + e.weight >= dist[e.to]) continue;
//                dist[e.to] = dist[info.idx] + e.weight;
//                pq.add(new Info(e.to, dist[e.to]));
//            }
//        }
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        StringBuilder sb = new StringBuilder();
//        V = Integer.parseInt(st.nextToken());
//        E = Integer.parseInt(st.nextToken());
//        start = Integer.parseInt(br.readLine());
//        dist = new int[V + 1];
//        edges = new ArrayList[V + 1];
//        for (int i = 1; i <= V; i++) {
//            edges[i] = new ArrayList<>();
//        }
//        for (int i = 1; i <= E; i++) {
//            st = new StringTokenizer(br.readLine());
//            int from = Integer.parseInt(st.nextToken());
//            int to = Integer.parseInt(st.nextToken());
//            int weight = Integer.parseInt(st.nextToken());
//            edges[from].add(new Edge(to, weight));
//        }
//        dijkstra(start);
//        for(int i=1; i<=V; i++) {
//            if(dist[i] == Integer.MAX_VALUE) sb.append("INF\n");
//            else {sb.append(dist[i]).append('\n');}
//        }
//        System.out.println(sb);
//    }
//}
import java.io.*;
import java.util.*;

public class Main {
    static int V, E, start;
    static class Edge {
        int to;
        int weight;
        public Edge(int to, int weight) {
            this.to =to;
            this.weight= weight;
        }
    }

    static class Info{
        int idx;
        int dist;
        public Info(int idx, int dist) {
            this.idx = idx;
            this.dist = dist;
        }
    }
    static int[] dist;
    static ArrayList<Edge>[] edges;

    static void dijkstra(int start) {
        for(int i=1; i<=V; i++) dist[i] = Integer.MAX_VALUE;
        PriorityQueue<Info> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.dist));
        pq.add(new Info(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()) {
            Info info = pq.poll();
            if(dist[info.idx] < info.dist) continue;
            for(Edge e : edges[info.idx]) {
                if(dist[info.idx] + e.weight >= dist[e.to]) continue;
                dist[e.to] = dist[info.idx] + e.weight;
                pq.add(new Info(e.to,dist[e.to]));
            }
        }

    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(br.readLine());

        for(int i=0; i<E; i++) {

        }
    }
}
