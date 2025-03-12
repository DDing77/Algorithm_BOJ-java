import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int M;
    private int[] numbers;
    private int[] nodes;

    private int init(int start, int end, int nodeNum) {
        if (start == end) {
            return nodes[nodeNum] = numbers[start];
        }

        int mid = (start + end) >> 1;
        return nodes[nodeNum] = init(start, mid, nodeNum * 2) + init(mid + 1, end, nodeNum * 2 + 1);
    }

    private void update(int start, int end, int targetIdx, int diff, int nodeNum) {
        if (targetIdx > end || targetIdx < start) {
            return;
        }

        nodes[nodeNum] += diff;

        if (start == end) {
            return;
        }

        int mid = (start + end) >> 1;
        update(start, mid, targetIdx, diff, nodeNum * 2);
        update(mid + 1, end, targetIdx, diff, nodeNum * 2 + 1);
    }

    private int query(int start, int end, int order, int nodeNum) {
        if (start == end) {
            return start;
        }

        int mid = (start + end) >> 1;
        if (nodes[nodeNum * 2] >= order) {
            return query(start, mid, order, nodeNum * 2);
        } else {
            return query(mid + 1, end, order - nodes[nodeNum * 2], nodeNum * 2 + 1);
        }
    }

    private void solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        numbers = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        nodes = new int[N * 4];

        init(1, N, 1);

        M = Integer.parseInt(br.readLine());
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());

            if (op == 1) {
                int idx = Integer.parseInt(st.nextToken());
                int diff = Integer.parseInt(st.nextToken());
                update(1, N, idx, diff, 1);
            } else if (op == 2) {
                int order = Integer.parseInt(st.nextToken());
                sb.append(query(1, N, order, 1)).append("\n");
            }
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
