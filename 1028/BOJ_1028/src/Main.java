import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static int[][] map;
    static int[][] dl;
    static int[][] dr;
    static int res;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];
        dl = new int[N + 2][M + 2];
        dr = new int[N + 2][M + 2];

        for (int i = 1; i <= N; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 1; j <= M; j++) {
                map[i][j] = input[j - 1] - '0';
            }
        }

        for (int i = N; i >= 1; i--) {
            for (int j = 1; j <= M; j++) {
                if (map[i][j] == 1) {
                    dl[i][j] = dl[i + 1][j - 1] + 1;
                    dr[i][j] = dr[i + 1][j + 1] + 1;
                }
            }
        }

        res = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                for (int k = Math.min(dl[i][j], dr[i][j]); k >= 1; k--) {
                    if (map[i + k - 1][j - k + 1] == 1) {
                        if (dr[i + k - 1][j - k + 1] >= k && dl[i + k - 1][j + k - 1] >= k) {
                            res = Math.max(res, k);
                            break;
                        }
                    }
                }
            }
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
