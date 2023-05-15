import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private int N;
    private int Q;
    private int[] prefixSum;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        prefixSum = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        int pre = 0;
        int cur;
        for (int i = 1; i <= N; i++) {
            cur = Integer.parseInt(st.nextToken());

            prefixSum[i] = prefixSum[i - 1];

            if (pre > cur) {
                prefixSum[i]++;
            }

            pre = cur;
        }

        Q = Integer.parseInt(br.readLine());
        int from;
        int to;
        while (Q-- > 0) {
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());


            sb.append(prefixSum[to] - prefixSum[from]).append('\n');
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
