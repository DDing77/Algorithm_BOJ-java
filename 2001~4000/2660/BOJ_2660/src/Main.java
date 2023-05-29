import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final int INF = 987654321;
    static int N;
    static int[][] arr;
    static int[] friendScore;
    static int max;
    static int cnt;

    static void floyd() {
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (arr[i][j] > arr[i][k] + arr[k][j]) {
                        arr[i][j] = arr[i][k] + arr[k][j];
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        arr = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i != j) arr[i][j] = INF;
            }
        }

        while (true) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (x == -1 && y == -1) break;

            arr[x][y] = 1;
            arr[y][x] = 1;
        }

        floyd();

        max = Integer.MAX_VALUE;
        friendScore = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            int maxScore = 0;
            for (int j = 1; j <= N; j++) {
                if (arr[i][j] != INF) maxScore = Math.max(maxScore, arr[i][j]);
            }

            friendScore[i] = maxScore;
            max = Math.min(max, friendScore[i]);
        }

        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            if (max == friendScore[i]) cnt++;
        }

        sb.append(max + " " + cnt).append('\n');

        for (int i = 1; i <= N; i++) {
            if (max == friendScore[i]) sb.append(i + " ");
        }
        System.out.println(sb);
    }
}
