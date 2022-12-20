import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] map;
    static int res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++) map[r][c] = Integer.parseInt(st.nextToken());
        }

        res = 2 * N * M;
        for (int r = 0; r < N; r++) {
            int sum = 0;
            for (int c = 0; c < M; c++) {
                if (c == 0) sum = map[r][c];
                else sum += Math.abs(map[r][c - 1] - map[r][c]);

                if (c == M - 1) sum += map[r][c];
            }
            res += sum;
        }

        for (int c = 0; c < M; c++) {
            int sum = 0;
            for (int r = 0; r < N; r++) {
                if (r == 0) sum = map[r][c];
                else sum += Math.abs(map[r - 1][c] - map[r][c]);

                if (r == N - 1) sum += map[r][c];
            }
            res += sum;
        }

        System.out.println(res);
    }
}
