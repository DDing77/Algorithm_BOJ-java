import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Edge {
        int from;
        int to;
        int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    static Edge[] edges;
    static int N, S, E, M;
    static long[] distance;
    static int[] cost;
    static ArrayList<Integer> list;

    static boolean bfs() {
        boolean[] isVisited = new boolean[N];

        for(int start : list) {
            if(!isVisited[start]) {
                Queue<Integer> que = new LinkedList<>();
                que.add(start);
                isVisited[start] = true;

                while(!que.isEmpty()) {
                    int cur = que.poll();
                    if(cur == E) return true;
                    for(int i=0; i<edges.length; i++) {
                        Edge edge = edges[i];

                        if(cur == edge.from) {
                            if(!isVisited[edge.to]) {
                                isVisited[edge.to] = true;
                                que.add(edge.to);
                            }
                        }
                    }
                }
            }
        }

        return false;
    }

    static void bellman() {
        distance[S] = cost[S];
        list = new ArrayList<>();

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(distance[edges[j].from] == Integer.MIN_VALUE) continue;
                if(distance[edges[j].to] < distance[edges[j].from] + edges[j].weight + cost[edges[j].to]) {
                    if(i == N-1) {
                        list.add(edges[j].to);
                        continue;
                    }
                    distance[edges[j].to] = distance[edges[j].from] + edges[j].weight + cost[edges[j].to];
                }

            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N =Integer.parseInt(st.nextToken());
        S =Integer.parseInt(st.nextToken());
        E =Integer.parseInt(st.nextToken());
        M =Integer.parseInt(st.nextToken());

        distance = new long[N];
        Arrays.fill(distance , Integer.MIN_VALUE);
        edges = new Edge[M];
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            edges[i] = new Edge(from, to, -weight);
        }
        cost = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) cost[i] = Integer.parseInt(st.nextToken());

        bellman();

        if(distance[E] == Integer.MIN_VALUE) {
            System.out.println("gg");
            return;
        }

        if(list.size() != 0) {
            if(!bfs()) System.out.println(distance[E]);
            else System.out.println("Gee");
        } else {
            System.out.println(distance[E]);
        }
    }
}
