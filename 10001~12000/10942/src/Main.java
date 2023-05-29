import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;
    static int[][] dp;

    static void dp(int start, int end) {
        for (int i = 1; i <= N; i++) { // 길이 1
            dp[i][i] = 1;
        }
        for (int i = 2; i <= N; i++) { // 길이 2
            if (arr[i] == arr[i - 1])
                dp[i - 1][i] = 1;
        }
        for(int i=2; i<=N-1; i++) {
            for(int j= 1; i+j<=N; j++) {
                if(arr[j] == arr[i+j] && dp[j+1][i+j-1] == 1) dp[j][i+j] = 1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        dp = new int[N + 1][N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp(1, 1);
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            sb.append(dp[x][y]).append('\n');
        }
        System.out.print(sb);
    }
}
