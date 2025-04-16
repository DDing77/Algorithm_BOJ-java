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
    private int[] in;
    private int[] out;
    private List<Integer>[] childs;
    private int[] sumTree;
    private int[] lazyTree;

    private void propagate(int start, int end, int curNode) {
        if (lazyTree[curNode] != 0) {
            sumTree[curNode] += lazyTree[curNode];
            if (start != end) {
                lazyTree[curNode << 1] += lazyTree[curNode];
                lazyTree[curNode << 1 | 1] += lazyTree[curNode];
            }
            lazyTree[curNode] = 0;
        }
    }

    private void euler(int cur) {
        in[cur] = ++eulerIdx;
        for (int next : childs[cur]) {
            euler(next);
        }
        out[cur] = eulerIdx;
    }

    private void update(int start, int end, int queryLeft, int queryRight, int value, int curNode) {
        propagate(start, end, curNode);

        if (queryRight < start || end < queryLeft) {
            return;
        }

        if (queryLeft <= start && end <= queryRight) {
            sumTree[curNode] += value;
            if (start != end) {
                lazyTree[curNode << 1] += value;
                lazyTree[curNode << 1 | 1] += value;
            }
            return;
        }

        int mid = (start + end) >> 1;
        update(start, mid, queryLeft, queryRight, value, curNode << 1);
        update(mid + 1, end, queryLeft, queryRight, value, curNode << 1 | 1);
        sumTree[curNode] = sumTree[curNode << 1] + sumTree[curNode << 1 | 1];
    }

    private int query(int start, int end, int targetIdx, int curNode) {
        propagate(start, end, curNode);

        if (targetIdx < start || end < targetIdx) {
            return 0;
        }

        if (start == end) {
            return sumTree[curNode];
        }

        int mid = (start + end) >> 1;
        return query(start, mid, targetIdx, curNode << 1)
                + query(mid + 1, end, targetIdx, curNode << 1 | 1);
    }

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        childs = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            childs[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if (i == 1) {
                continue;
            }
            childs[parent].add(i);
        }

        in = new int[N + 1];
        out = new int[N + 1];
        euler(1);

        sumTree = new int[N * 4];
        lazyTree = new int[N * 4];

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            int i = Integer.parseInt(st.nextToken());
            if (op == 1) {
                int w = Integer.parseInt(st.nextToken());
                update(1, N, in[i], out[i], w, 1);
            } else if (op == 2) {
                sb.append(query(1, N, in[i], 1)).append("\n");
            }
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
