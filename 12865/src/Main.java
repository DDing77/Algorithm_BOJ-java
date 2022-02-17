import java.io.*;
import java.util.StringTokenizer;
import java.util.zip.InflaterInputStream;

//public class Main {
//    static int[] vi, wi;
//    static int N, W;
//    static int[][] dp;
//
//    static void getDp() {
//        for(int i=1; i<=N; i++) {
//            for(int j=1; j<=W; j++) {
//                if(wi[i]>j) {
//                    dp[i][j] = dp[i-1][j];
//                } else {
//                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-wi[i]] + vi[i]);
//                }
//            }
//        }
//        System.out.println(dp[N][W]);
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        N = Integer.parseInt(st.nextToken());
//        W = Integer.parseInt(st.nextToken());
//
//        vi = new int[N+1];
//        wi = new int[N+1];
//        dp = new int[N+1][W+1];
//
//        for(int i=1; i<=N; i++) {
//            st = new StringTokenizer(br.readLine());
//            wi[i] = Integer.parseInt(st.nextToken());
//            vi[i] = Integer.parseInt(st.nextToken());
//        }
//        getDp();
//    }
//}

public class Main {
    static int[][] dp;
    static int[] W;
    static int[] V;
    static int N, K;
    static void solution(){
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=K; j++) {
                if(W[i] > j) dp[i][j] = dp[i-1][j];
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-W[i]] + V[i]);
                }
            }
        }
        System.out.println(dp[N][K]);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        W = new int[N+1];
        V = new int[N+1];
        dp = new int[N+1][K+1];

        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }
        solution();
    }
}