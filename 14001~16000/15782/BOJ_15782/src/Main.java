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
    private int M;
    private List<Integer>[] edges;
    private boolean[] isVisited;
    private int[] weights;
    private int[] in;
    private int[] out;
    private int[] nodeTree;
    private int[] lazyTree;

    private void euler(int cur) {
        isVisited[cur] = true;
        in[cur] = ++eulerIdx;
        for (int next : edges[cur]) {
            if (!isVisited[next]) {
                euler(next);
            }
        }
        out[cur] = eulerIdx;
    }

    private void init(int start, int end, int nodeNum) {
        if (start == end) {
            nodeTree[nodeNum] = weights[start];
            return;
        }

        int mid = (start + end) >> 1;
        init(start, mid, nodeNum << 1);
        init(mid + 1, end, nodeNum << 1 | 1);
        nodeTree[nodeNum] = nodeTree[nodeNum << 1] ^ nodeTree[nodeNum << 1 | 1];
    }

    private void propagate(int start, int end, int nodeNum) {
        if (lazyTree[nodeNum] != 0) {
            if (((end - start + 1) & 1) == 1) {
                nodeTree[nodeNum] ^= lazyTree[nodeNum];
            }
            if (start != end) {
                lazyTree[nodeNum << 1] ^= lazyTree[nodeNum];
                lazyTree[nodeNum << 1 | 1] ^= lazyTree[nodeNum];
            }
            lazyTree[nodeNum] = 0;
        }
    }

    private int query(int start, int end, int queryLeft, int queryRight, int nodeNum) {
        propagate(start, end, nodeNum);

        if (queryRight < start || end < queryLeft) {
            return 0;
        }

        if (queryLeft <= start && end <= queryRight) {
            return nodeTree[nodeNum];
        }

        int mid = (start + end) >> 1;
        return query(start, mid, queryLeft, queryRight, nodeNum << 1)
                ^ query(mid + 1, end, queryLeft, queryRight, nodeNum << 1 | 1);
    }

    private void update(int start, int end, int queryLeft, int queryRight, int value, int nodeNum) {
        propagate(start, end, nodeNum);

        if (queryRight < start || end < queryLeft) {
            return;
        }

        if (queryLeft <= start && end <= queryRight) {
            if (((end - start + 1) & 1) == 1) {
                nodeTree[nodeNum] ^= value;
            }
            if (start != end) {
                lazyTree[nodeNum << 1] ^= value;
                lazyTree[nodeNum << 1 | 1] ^= value;
            }
            return;
        }

        int mid = (start + end) >> 1;
        update(start, mid, queryLeft, queryRight, value, nodeNum << 1);
        update(mid + 1, end, queryLeft, queryRight, value, nodeNum << 1 | 1);
        nodeTree[nodeNum] = nodeTree[nodeNum << 1] ^ nodeTree[nodeNum << 1 | 1];
    }

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

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

        weights = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            weights[i] = Integer.parseInt(st.nextToken());
        }

        in = new int[N + 1];
        out = new int[N + 1];
        isVisited = new boolean[N + 1];
        euler(1);

        int[] temp = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            temp[in[i]] = weights[i];
        }
        weights = temp;

        nodeTree = new int[N * 4];
        lazyTree = new int[N * 4];
        init(1, N, 1);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            if (op == 1) {
                sb.append(query(1, N, in[x], out[x], 1)).append("\n");
            } else {
                int y = Integer.parseInt(st.nextToken());
                update(1, N, in[x], out[x], y, 1);
            }
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
