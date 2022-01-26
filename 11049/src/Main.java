import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] matrix;
    static int[][] dp;
    static void solution(){
        for( int i=0; i<N -1; i++) {
            dp[i][i+1] = matrix[i][0] * matrix[i][1] * matrix[i+1][1];
        }
        for( int g = 2; g < N; g++) {
            for(int i = 0; i+ g <N; i++) {
                int j = i + g;
                dp[i][j] = Integer.MAX_VALUE;
                for(int k = i; k<j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k+1][j] + (matrix[i][0] * matrix[k][1] * matrix[j][1]));
                }
            }
        }
        System.out.println(dp[0][N-1]);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        matrix = new int[N][2];
        dp = new int[N][N];

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            matrix[i][0] = Integer.parseInt(st.nextToken());
            matrix[i][1] = Integer.parseInt(st.nextToken());
        }

        solution();

    }
}
