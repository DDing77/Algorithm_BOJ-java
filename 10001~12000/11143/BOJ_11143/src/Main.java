import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int T;
    private int B;
    private int P;
    private int Q;
    private int[] cntNodes;

    private void update(int start, int end, int targetIdx, int value, int nodeNum) {
        if (targetIdx < start || end < targetIdx) {
            return;
        }

        cntNodes[nodeNum] += value;

        if (start == end) {
            return;
        }

        int mid = (start + end) >> 1;
        update(start, mid, targetIdx, value, nodeNum << 1);
        update(mid + 1, end, targetIdx, value, nodeNum << 1 | 1);
    }

    private int query(int start, int end, int queryLeft, int queryRight, int nodeNum) {
        if (queryRight < start || end < queryLeft) {
            return 0;
        }

        if (queryLeft <= start && end <= queryRight) {
            return cntNodes[nodeNum];
        }

        int mid = (start + end) >> 1;
        return query(start, mid, queryLeft, queryRight, nodeNum << 1)
                + query(mid + 1, end, queryLeft, queryRight, nodeNum << 1 | 1);
    }

    private void solution() throws IOException {
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            B = Integer.parseInt(st.nextToken());
            P = Integer.parseInt(st.nextToken());
            Q = Integer.parseInt(st.nextToken());

            int size = 1;
            while (size < B * 2) {
                size <<= 1;
            }

            cntNodes = new int[size + 1];

            for (int i = 0; i < P + Q; i++) {
                st = new StringTokenizer(br.readLine());
                String op = st.nextToken();
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                if (op.equals("P")) {
                    update(1, B, a, b, 1);
                } else if (op.equals("Q")) {
                    sb.append(query(1, B, a, b, 1)).append("\n");
                }
            }
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
