import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int Q;
    static int[][] prefixSum;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        prefixSum = new int[N + 1][4];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= 3; j++) {
                prefixSum[i][j] = prefixSum[i - 1][j];
            }

            prefixSum[i][Integer.parseInt(br.readLine())]++;
        }

        int from;
        int to;
        while (Q-- > 0) {
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            sb.append((prefixSum[to][1] - prefixSum[from - 1][1]) + " " +
                    (prefixSum[to][2] - prefixSum[from - 1][2]) + " " +
                    (prefixSum[to][3] - prefixSum[from - 1][3])).append('\n');
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
