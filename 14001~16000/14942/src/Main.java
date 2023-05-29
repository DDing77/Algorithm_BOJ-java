import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int LogN;
    static int[] ant;
    static int[][] parent;
    static int[] depth;
    static int[][] distance;
    static class Info{
        int to;
        int weight;
        public Info(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
    static ArrayList<Info>[] list;
    static void getLogN() {
        LogN = 0;
        for(int k=1; k<N; k*=2) LogN++;
    }
    static void BFS(int start) {
        Queue<Integer> que = new LinkedList<>();
        depth[start] = 1;
        que.add(start);

        while(!que.isEmpty()) {
            int now = que.poll();
            for(Info next : list[now]){
                if(depth[next.to] == 0) {
                    depth[next.to] = depth[now] +1;
                    parent[0][next.to] = now;
                    distance[0][next.to] = next.weight;
                    que.add(next.to);
                }
            }
        }
    }
    static void makeSparseTable() {
        for(int i=1; i<=LogN; i++) {
            for(int j=1; j<=N; j++) {
                parent[i][j] = parent[i-1][parent[i-1][j]];
                distance[i][j] = distance[i-1][j] + distance[i-1][parent[i-1][j]];
            }
        }
    }
    static int getLCA(int x, int weight) {
        for(int i=LogN; i>=0; i--) {
            if(weight >= distance[i][x] && parent[i][x] != 0){
                weight -= distance[i][x];
                x = parent[i][x];
            }
        }
        return x;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        getLogN();
        ant = new int[N+1];
        depth = new int[N+1];
        list = new ArrayList[N+1];
        parent = new int[LogN+1][N+1];
        distance = new int[LogN+1][N+1];

        for(int i=0; i<=N; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i=1; i<=N; i++) {
            ant[i] = Integer.parseInt(br.readLine());
        }
        for(int i=0; i<N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list[start].add(new Info(end,weight));
            list[end].add(new Info(start, weight));
        }

        BFS(1);
        makeSparseTable();
//
//        for(int i=0; i<=LogN; i++) {
//            System.out.println(Arrays.toString(parent[i]));
//        }
//        for(int i=0; i<=LogN; i++) {
//            System.out.println(Arrays.toString(distance[i]));
//        }
        for(int i=1; i<=N; i++) {
            sb.append(getLCA(i,ant[i])).append('\n');
        }
        System.out.print(sb);
    }
}
