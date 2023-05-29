import java.io.*;
import java.util.StringTokenizer;

public class Main { // BOJ_11404
    public static int N;
    public static int[][] distance;
    public static final int INF = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        distance = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) continue;
                distance[i][j] = INF;
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());


            distance[start][end] = Math.min(distance[start][end], time);
        }
        floydWarshall();
        bw.write(String.valueOf(print()));
        bw.flush();
        br.close();
        bw.close();
    }

    public static void floydWarshall() {
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
                }
            }
        }
    }

    public static StringBuilder print() {
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i<= N; i++){
            for(int j=1; j<=N; j++) {
                if(distance[i][j] >= INF) sb.append("0 ");
                sb.append(distance[i][j] + " ");
            }
            sb.append("\n");
        }
        return sb;
    }
}
