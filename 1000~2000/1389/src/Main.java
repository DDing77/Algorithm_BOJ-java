import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N + 1][N + 1];

        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= N; j++) {
                if (i == j) map[i][j] = 0;
                else map[i][j] = 101;
            }
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            map[start][end] = 1;
            map[end][start] = 1;
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }

        int min = Integer.MAX_VALUE;
        int res = 1;
        for (int i = 1; i <= N; i++) {
            int tempTotal = 0;
            for (int j = 1; j <= N; j++) {
                tempTotal += map[i][j];
            }
            if (min > tempTotal) {
                min = tempTotal;
                res = i;
            }
        }

        System.out.println(res);
//        for (int i = 1; i <= N; i++) {
//            System.out.println(Arrays.toString(map[i]));
//        }
    }
}
