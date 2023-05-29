import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] arr, dp1, dp2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        dp1 = new int[N][M];
        dp2 = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // dp1 초기화 및 수행
        dp1[N - 1][0] = arr[N - 1][0];
        for (int i = N - 2; i >= 0; i--) {
            dp1[i][0] = arr[i][0] + dp1[i + 1][0];
        }
        for (int i = 1; i < M; i++) {
            dp1[N - 1][i] = arr[N - 1][i] + dp1[N - 1][i - 1];
        }
        for(int i = N-2; i>=0; i--) {
            for( int j = 1; j<M; j++) {
                dp1[i][j] = arr[i][j];
                dp1[i][j] += Math.max(dp1[i][j-1], dp1[i+1][j]);
            }
        }

        // dp2 초기화 및 수행
        dp2[N-1][M-1] = arr[N-1][M-1];
        for(int i = N-2; i>=0; i--){
            dp2[i][M-1] = arr[i][M-1]+ dp2[i+1][M-1];
        }
        for(int i = M-2; i>=0; i--){
            dp2[N-1][i] = arr[N-1][i] + dp2[N-1][i+1];
        }
        for(int i = N-2; i>=0; i--) {
            for(int j = M-2; j>=0; j--) {
                dp2[i][j] = arr[i][j];
                dp2[i][j] += Math.max(dp2[i+1][j], dp2[i][j+1]);
            }
        }

        long ans = dp1[0][0] + dp2[0][0];
        for(int i=0; i<N; i++) {
            for( int j=0; j<M; j++) {
                ans = Math.max(ans, dp1[i][j] + dp2[i][j]);
            }
        }
        System.out.println(ans);
    }
}
