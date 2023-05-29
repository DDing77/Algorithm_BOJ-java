import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int LogN;
    static int[] depth;
    static int[][] parent;
    static ArrayList<Integer>[] list;

    static void getLogN(){
        LogN = 0;
        for(int k=1; k<N; k*=2) LogN++;
    }

    static void bfs(int start) {
        Queue<Integer> que = new LinkedList<>();
        depth[start] = 1;
        que.add(start);
        while(!que.isEmpty()) {
            int now = que.poll();
            for(int next : list[now]) {
                if(depth[next] ==0) {
                    depth[next] = depth[now] +1;
                    parent[0][next] = now;
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
        if(depth[b] > depth[a]) return getLCA(b,a);
        for(int i=0; i<=LogN; i++) {
            if( ((depth[a] - depth[b]) & (1 <<i)) >= 1){
                a = parent[i][a];
            }
        }
        if(a == b) return a;
        for(int i=LogN; i>=0; i--) {
            if(parent[i][a] != parent[i][b]){
                a = parent[i][a];
                b = parent[i][b];
            }
        }
        return parent[0][a];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        depth = new int[N+1];
        getLogN();
        parent= new int[LogN+1][N+1];
        list = new ArrayList[N+1];
        for(int i=0; i<=N; i++) {
            list[i] = new ArrayList<>();
        }
        for(int i=0; i<N-1; i++) {
            StringTokenizer st= new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        bfs(1);
        makeSparseTable();
        M = Integer.parseInt(br.readLine());
        for(int i=0; i<M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            int a = getLCA(r,u);
            int b = getLCA(u,v);
            int c = getLCA(r,v);
//            sb.append(Math.max(depth[getLCA(u,v)], Math.max(depth[getLCA(r,u)] , depth[getLCA(r, v)]))).append('\n');
            sb.append(
                    depth[a] > depth[b] ? (depth[a] > depth[c] ? a : c) : (depth[b] > depth[c] ? b : c)
            ).append('\n');
        }
        System.out.print(sb);
    }
}
