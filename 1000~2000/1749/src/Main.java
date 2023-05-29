import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N+1][M+1];
        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=1; i<=N; i++) {
            for(int j=1; j<=M; j++) {
                arr[i][j] = arr[i][j] + arr[i-1][j] + arr[i][j-1] - arr[i-1][j-1];
            }
        }

        int max = Integer.MIN_VALUE;

        for(int x1=1 ; x1<=N; x1++) {
            for(int y1 =1; y1<=M; y1++) {
                for(int x2 = x1; x2<=N; x2++) {
                    for(int y2 = y1; y2<=M; y2++) {
                        max = Math.max(max, arr[x2][y2] - arr[x1 -1][y2] - arr[x2][y1-1] + arr[x1-1][y1-1]);
                    }
                }
            }
        }
        System.out.println(max);
    }
}
