import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int M;
    private int[] numbers;
    private int[] evenTree;
    private int[] oddTree;

    private int init(int[] tree, int start, int end, int idx, int nodeNum) {
        if (idx < start || idx > end) {
            return tree[nodeNum];
        }

        if (start == end) {
            return tree[nodeNum] = 1;
        }

        int mid = (start + end) >> 1;
        return tree[nodeNum] = init(tree, start, mid, idx, nodeNum * 2) +
                init(tree, mid + 1, end, idx, nodeNum * 2 + 1);
    }

    private void update(int[] tree, int start, int end, int idx, int value, int nodeNum) {
        if (idx < start || idx > end) {
            return;
        }

        tree[nodeNum] += value;

        if (start == end) {
            return;
        }

        int mid = (start + end) >> 1;
        update(tree, start, mid, idx, value, nodeNum * 2);
        update(tree, mid + 1, end, idx, value, nodeNum * 2 + 1);
    }

    private int query(int[] tree, int start, int end, int queryLeft, int queryRight, int nodeNum) {
        if (queryLeft > end || queryRight < start) {
            return 0;
        }

        if (queryLeft <= start && end <= queryRight) {
            return tree[nodeNum];
        }

        int mid = (start + end) >> 1;
        return query(tree, start, mid, queryLeft, queryRight, nodeNum * 2)
                + query(tree, mid + 1, end, queryLeft, queryRight, nodeNum * 2 + 1);
    }

    private void solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        numbers = new int[N + 1];

        evenTree = new int[N * 4];
        oddTree = new int[N * 4];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
            if (numbers[i] % 2 == 0) {
                init(evenTree, 1, N, i, 1);
            } else {
                init(oddTree, 1, N, i, 1);
            }
        }

        M = Integer.parseInt(br.readLine());
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            if (op == 1) {
                int idx = Integer.parseInt(st.nextToken());
                int value = Integer.parseInt(st.nextToken());

                if (numbers[idx] % 2 == 0 && value % 2 == 1) {
                    update(evenTree, 1, N, idx, -1, 1);
                    update(oddTree, 1, N, idx, 1, 1);
                } else if (numbers[idx] % 2 == 1 && value % 2 == 0) {
                    update(oddTree, 1, N, idx, -1, 1);
                    update(evenTree, 1, N, idx, 1, 1);
                }
                numbers[idx] = value;
            } else if (op == 2) {
                sb.append(query(evenTree, 1, N, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 1)).append("\n");
            } else if (op == 3) {
                sb.append(query(oddTree, 1, N, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 1)).append("\n");
            }
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
