import java.io.*;
import java.util.*;

//public class Main {
//    static int N ,M;
//    static int LogN;
//    static int[] depth;
//    static int[][] parent;
//    static ArrayList<Integer>[] map;
//
//    static void getLogN() {
//        LogN = 0;
//        for (int k = 1; k < N; k *= 2) {
//            LogN++;
//        }
//    }
//
//    static void bfs(int start) {
//        Queue<Integer> que = new LinkedList<>();
//        depth[start] = 1;
//        que.add(start);
//        while (!que.isEmpty()) {
//            int now = que.poll();
//            for (int next : map[now]) {
//                if (depth[next] == 0) {
//                    depth[next] = depth[now] + 1;
//                    parent[0][next] = now;
//                    que.add(next);
//                }
//            }
//        }
//    }
//
//    static void makeSparseTable() {
//        for (int i = 1; i <= LogN; i++) {
//            for (int j = 1; j <= N; j++) {
//                parent[i][j] = parent[i - 1][parent[i - 1][j]];
//            }
//        }
//    }
//
//    static int getLCA(int a, int b) {
//        if (depth[b] > depth[a]) {
//            return getLCA(b, a);
//        }
//        for (int i = 0; i <= LogN; i++) {
//            if (((depth[a] - depth[b]) & (1 << i)) >= 1) {
//                a = parent[i][a];
//            }
//        }
//        if (a == b) {
//            return a;
//        }
//        for (int i = LogN; i >= 0; i--) {
//            if (parent[i][a] != parent[i][b]) {
//                a = parent[i][a];
//                b = parent[i][b];
//            }
//        }
//        return parent[0][a];
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//        N = Integer.parseInt(br.readLine());
//        depth = new int[N + 1];
//        map = new ArrayList[N + 1];
//
//        for (int i = 0; i <= N; i++) {
//            map[i] = new ArrayList<>();
//        }
//        for (int i = 1; i < N; i++) {
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            int start = Integer.parseInt(st.nextToken());
//            int end = Integer.parseInt(st.nextToken());
//            map[start].add(end);
//            map[end].add(start);
//        }
//
//        getLogN();
//        parent = new int[LogN + 1][N + 1];
//
//        bfs(1);
//        makeSparseTable();
//        M = Integer.parseInt(br.readLine());
//        for(int i=1; i<=M; i++) {
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            int a = Integer.parseInt(st.nextToken());
//            int b = Integer.parseInt(st.nextToken());
//            sb.append(getLCA(a,b)).append('\n');
//        }
//        System.out.println(sb);
//    }
//}

public class Main{
    static int N , M;
    static int LogN;
    static int[] depth;
    static int[][] parent;
    static ArrayList<Integer>[] map;
    static void getLogN(){
        LogN = 0;
        for(int k=1; k<N; k*=2) {
            LogN++;
        }
    };
    static void bfs(int root){
        Queue<Integer> que = new LinkedList<>();
        depth[root] = 1;
        que.add(root);

        while(!que.isEmpty()) {
            int cur = que.poll();
            for(int next : map[cur]) {
                if(depth[next] == 0) {
                    depth[next] = depth[cur] +1;
                    parent[0][next] = cur;
                    que.add(next);
                }
            }
        }
    }
    static void makeSparseTable(){
        for(int i=1; i<=LogN; i++) {
            for(int j=1; j<=N; j++) {
                parent[i][j] = parent[i-1][parent[i-1][j]];
            }
        }
    }
    static int getLCA(int a, int b) {
        if( depth[b] > depth[a]) return getLCA(b,a);
        for(int i=0; i<=LogN; i++) {
            if( ((depth[a] - depth[b]) & ( 1<<i)) >= 1) {
                a = parent[i][a];
            }
        }
        if( a == b) return a;

        for( int i= LogN; i>=0; i--) {
            if(parent[i][a] != parent[i][b]){
                a = parent[i][a];
                b = parent[i][b];
            }
        }
        return parent[0][a];
    }
    public static void main(String[] args) throws  IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());

        getLogN();
        map = new ArrayList[N+1];
        parent = new int[LogN+1][N+1];
        depth = new int[N+1];
        for(int i=0; i<=N; i++) {
            map[i] = new ArrayList<>();
        }

        for(int i=0; i<N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a= Integer.parseInt(st.nextToken());
            int b= Integer.parseInt(st.nextToken());
            map[a].add(b);
            map[b].add(a);
        }
        bfs(1);
        makeSparseTable();

        M = Integer.parseInt(br.readLine());
        for(int i=0; i<M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(getLCA(a,b)).append('\n');
        }
        System.out.println(sb);
    }
}