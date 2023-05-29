import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int T, M, N, K, m, n;
    static char[][] map;

    public static boolean isIsolation() {
        if (map[0][0] != 'X' && (map[0][1] == 'X' && map[1][0] == 'X')) return true;
        if (map[0][N - 1] != 'X' && (map[0][N - 2] == 'X' && map[1][N - 1] == 'X')) return true;
        if (map[M - 1][0] != 'X' && (map[M - 2][0] == 'X' && map[M - 1][1] == 'X')) return true;
        if (map[M - 1][N - 1] != 'X' && (map[M - 1][N - 2] == 'X' && map[M - 2][N - 1] == 'X')) return true;
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            map = new char[M][N];

            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j += 2) {
                    if (i % 2 == 0) {
                        map[i][j] = 'W';
                        map[i][j + 1] = 'B';
                    } else {
                        map[i][j] = 'B';
                        map[i][j + 1] = 'W';
                    }
                }
            }

            int removeW = 0;
            int removeB = 0;

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                m = Integer.parseInt(st.nextToken());
                n = Integer.parseInt(st.nextToken());

                if (map[m - 1][n - 1] == 'W') {
                    removeW++;
                } else {
                    removeB++;
                }
                map[m - 1][n - 1] = 'X';
            }

            if (K == 0) {
                sb.append(M * N / 2).append('\n');
                continue;
            }

            if (K == 1) {
                sb.append(M * N / 2 - K).append('\n');
                continue;
            }

            if (K > 0 && Math.abs(removeB - removeW) == K) {
                sb.append(M * N / 2 - K).append('\n');
                continue;
            }

            if (K == 2 && removeB == removeW) {
                sb.append(M * N / 2 - 1).append('\n');
                continue;
            }

            if ((K > 2 && (removeB == 1 && removeW == K - 1)) || (K > 2 && (removeB == K - 1 && removeW == 1))) {
                sb.append(M * N / 2 - (K - 1)).append('\n');
                continue;
            }

            if (K == 4 && Math.abs(removeB - removeW) == 0) {
                if (isIsolation()) {
                    sb.append(M * N / 2 - 3).append('\n');
                } else {
                    sb.append(M * N / 2 - 2).append('\n');
                }
            }
        }

        System.out.print(sb);
    }
}

