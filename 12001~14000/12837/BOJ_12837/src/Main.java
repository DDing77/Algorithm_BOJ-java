import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    int N;
    int Q;
    long[] tree;

    private long getPrefixSum(int idx) {
        long sum = 0L;

        while (idx > 0) {
            sum += tree[idx];
            idx -= idx & -idx;
        }

        return sum;
    }

    private void update(int idx, int value) {
        while (idx <= N) {
            tree[idx] += value;
            idx += idx & -idx;
        }
    }

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        tree = new long[N + 1];
        while (Q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            if (op == 1) {
                int x = Integer.parseInt(st.nextToken());
                update(p, x);
            } else if (op == 2) {
                int q = Integer.parseInt(st.nextToken());
                sb.append(getPrefixSum(q) - getPrefixSum(p - 1)).append("\n");
            }
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
