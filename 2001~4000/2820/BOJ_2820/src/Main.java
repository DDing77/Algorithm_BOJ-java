import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
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
    private int[] in;
    private int[] out;
    private long[] wages;
    private long[] orderedWages;
    private long[] sumTree;
    private long[] lazyTree;

    private void euler(int cur) {
        in[cur] = ++eulerIdx;
        for (int next : edges[cur]) {
            euler(next);
        }
        out[cur] = eulerIdx;
    }

    private void propagate(int start, int end, int curNodeNum) {
        if (lazyTree[curNodeNum] != 0) {
            sumTree[curNodeNum] += lazyTree[curNodeNum];
            if (start != end) {
                lazyTree[curNodeNum << 1] += lazyTree[curNodeNum];
                lazyTree[curNodeNum << 1 | 1] += lazyTree[curNodeNum];
            }
            lazyTree[curNodeNum] = 0;
        }
    }

    private void buildTree(int start, int end, int curNodeNum) {
        if (start == end) {
            sumTree[curNodeNum] = orderedWages[start];
            return;
        }

        int mid = (start + end) >> 1;
        buildTree(start, mid, curNodeNum << 1);
        buildTree(mid + 1, end, curNodeNum << 1 | 1);
    }

    private void update(int start, int end, int queryLeft, int queryRight, long value, int curNodeNum) {
        propagate(start, end, curNodeNum);

        if (queryRight < start || end < queryLeft) {
            return;
        }

        if (queryLeft <= start && end <= queryRight) {
            sumTree[curNodeNum] += value;
            if (start != end) {
                lazyTree[curNodeNum << 1] += value;
                lazyTree[curNodeNum << 1 | 1] += value;
            }
            return;
        }

        int mid = (start + end) >> 1;
        update(start, mid, queryLeft, queryRight, value, curNodeNum << 1);
        update(mid + 1, end, queryLeft, queryRight, value, curNodeNum << 1 | 1);

        sumTree[curNodeNum] = sumTree[curNodeNum << 1] + sumTree[curNodeNum << 1 | 1];
    }

    private long query(int start, int end, int targetIdx, int curNodeNum) {
        propagate(start, end, curNodeNum);

        if (targetIdx < start || end < targetIdx) {
            return 0L;
        }

        if (start == end) {
            return sumTree[curNodeNum];
        }

        int mid = (start + end) >> 1;
        return query(start, mid, targetIdx, curNodeNum << 1)
                + query(mid + 1, end, targetIdx, curNodeNum << 1 | 1);
    }

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        in = new int[N + 1];
        out = new int[N + 1];
        edges = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }

        wages = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            if (i == 1) {
                wages[i] = Long.parseLong(st.nextToken());
                continue;
            }
            wages[i] = Long.parseLong(st.nextToken());
            edges[Integer.parseInt(st.nextToken())].add(i);
        }


        euler(1);
        orderedWages = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            orderedWages[in[i]] = wages[i];
        }

        sumTree = new long[N * 4];
        lazyTree = new long[N * 4];
        buildTree(1, N, 1);

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            String op = st.nextToken();
            if (op.equals("p")) {
                int a = Integer.parseInt(st.nextToken());
                long x = Long.parseLong(st.nextToken());
                update(1, N, in[a] + 1, out[a], x, 1);

            } else if (op.equals("u")) {
                int a = Integer.parseInt(st.nextToken());
                sb.append(query(1, N, in[a], 1)).append("\n");
            }
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
