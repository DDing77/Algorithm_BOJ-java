import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] dist;
    static int INF = 999999999;

    static void floyd() {
        for(int k=1; k<=N; k++) {
            for(int i=1; i<=N; i++) {
                for(int j=1; j<=N; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
    }
    static void solution(){
        floyd();
        int ans = 0;
        for(int i=1; i<=N; i++) {
            int cnt = 0;
            for( int j=1; j<=N; j++) {
                if(dist[i][j] != INF || dist[j][i] != INF) cnt++;
            }
            if( cnt == N-1) ans++;
        }
        System.out.println(ans);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dist = new int[N+1][N+1];

        for (int i=1; i<=N; i++) {
            for (int j=1; j<=N; j++) {
                dist[i][j] = INF;
            }
        }

        for(int i= 0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            dist[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
        }
        solution();
    }
}

