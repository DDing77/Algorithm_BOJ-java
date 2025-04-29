import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int T;
    private int N;
    private int[] A;
    private int[] B;
    private long[] nodes;
    private long res;

    private void update(int start, int end, int targetNode, int nodeNum) {
        if (targetNode < start || end < targetNode) {
            return;
        }

        if (start == end) {
            nodes[nodeNum]++;
            return;
        }

        int mid = (start + end) >> 1;
        update(start, mid, targetNode, nodeNum << 1);
        update(mid + 1, end, targetNode, nodeNum << 1 | 1);
        nodes[nodeNum] = nodes[nodeNum << 1] + nodes[nodeNum << 1 | 1];
    }

    private long query(int start, int end, int queryLeft, int queryRight, int nodeNum) {
        if (queryRight < start || end < queryLeft) {
            return 0;
        }

        if (queryLeft <= start && end <= queryRight) {
            return nodes[nodeNum];
        }

        int mid = (start + end) >> 1;
        return query(start, mid, queryLeft, queryRight, nodeNum << 1)
                + query(mid + 1, end, queryLeft, queryRight, nodeNum << 1 | 1);
    }

    private void solution() throws IOException {
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            res = 0L;

            nodes = new long[N * 4];
            A = new int[N + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                int num = Integer.parseInt(st.nextToken());
                A[num] = i;
            }

            B = new int[N + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                int num = Integer.parseInt(st.nextToken());
                B[i] = A[num];
            }

            for (int i = 1; i <= N; i++) {
                res += (B[i] - 1) - query(1, N, 1, B[i], 1);
                update(1, N, B[i], 1);
            }

            sb.append(res).append("\n");
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
