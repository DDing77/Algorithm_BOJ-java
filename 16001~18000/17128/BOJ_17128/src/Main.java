import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ_17128
 * author_devteo77
 */

public class Main {

    int N;
    int Q;
    int[] cows;
    int[] preSum;
    int res;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        cows = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            cows[i] = Integer.parseInt(st.nextToken());
        }

        preSum = new int[N + 1];
        res = 0;
        for (int i = 1; i <= N; i++) {
            int temp = 1;
            for (int j = 0; j < 4; j++) {
                int idx = i + j;
                if (idx > N) {
                    idx -= N;
                }
                temp *= cows[idx];
            }
            res += temp;
            preSum[i] = temp;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < Q; i++) {
            int query = Integer.parseInt(st.nextToken());
            for (int j = 0; j < 4; j++) {
                if (query < 1) {
                    query += N;
                }
                preSum[query] *= -1;
                res += (preSum[query] * 2);
                query--;
            }
            sb.append(res).append('\n');
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
