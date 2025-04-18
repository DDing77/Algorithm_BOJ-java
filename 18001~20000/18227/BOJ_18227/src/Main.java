import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private static int eulerIdx = 0;

    private int N;
    private int C;
    private int Q;
    private int in[];
    private int out[];
    private List<Integer>[] edges;
    private int[] depth;
    private int[] nodeTree;

    private void euler(int cur) {
        in[cur] = ++eulerIdx;
        for (int next : edges[cur]) {
            if (depth[next] == 0) {
                depth[next] = depth[cur] + 1;
                euler(next);
            }
        }
        out[cur] = eulerIdx;
    }

    private void update(int start, int end, int targetIdx, int nodeNum) {
        if (targetIdx < start || end < targetIdx) {
            return;
        }

        nodeTree[nodeNum]++;

        if (start == end) {
            return;
        }

        int mid = (start + end) >> 1;
        update(start, mid, targetIdx, nodeNum << 1);
        update(mid + 1, end, targetIdx, nodeNum << 1 | 1);
    }

    private int query(int start, int end, int queryLeft, int queryRight, int nodeNum) {
        if (queryRight < start || end < queryLeft) {
            return 0;
        }

        if (queryLeft <= start && end <= queryRight) {
            return nodeTree[nodeNum];
        }

        int mid = (start + end) >> 1;
        return query(start, mid, queryLeft, queryRight, nodeNum << 1)
                + query(mid + 1, end, queryLeft, queryRight, nodeNum << 1 | 1);
    }

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        edges = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            edges[from].add(to);
            edges[to].add(from);
        }


        in = new int[N + 1];
        out = new int[N + 1];
        depth = new int[N + 1];
        depth[C] = 1;
        euler(C);

        nodeTree = new int[N * 4];
        Q = Integer.parseInt(br.readLine());
        while (Q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            int A = Integer.parseInt(st.nextToken());

            if (op == 1) {
                update(1, N, in[A], 1);
            } else if (op == 2) {
                sb.append(query(1, N, in[A], out[A], 1) * (long) depth[A]).append("\n");
            }
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
