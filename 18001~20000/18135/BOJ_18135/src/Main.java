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
    private int[] area;
    private int[] values;
    private long[] sumTree;
    private long[] lazyTree;

    private void build(int start, int end, int nodeNum) {
        if (start == end) {
            sumTree[nodeNum] = values[start];
            return;
        }

        int mid = (start + end) >> 1;
        build(start, mid, nodeNum << 1);
        build(mid + 1, end, nodeNum << 1 | 1);
        sumTree[nodeNum] = sumTree[nodeNum << 1] + sumTree[nodeNum << 1 | 1];
    }

    private void propagate(int start, int end, int nodeNum) {
        if (lazyTree[nodeNum] != 0) {
            sumTree[nodeNum] += (end - start + 1) * lazyTree[nodeNum];
            if (start != end) {
                lazyTree[nodeNum << 1] += lazyTree[nodeNum];
                lazyTree[nodeNum << 1 | 1] += lazyTree[nodeNum];
            }
            lazyTree[nodeNum] = 0;
        }
    }

    private void update(int start, int end, int queryLeft, int queryRight, int value, int nodeNum) {
        propagate(start, end, nodeNum);

        if (queryRight < start || end < queryLeft) {
            return;
        }

        if (queryLeft <= start && end <= queryRight) {
            sumTree[nodeNum] += (end - start + 1) * (long) value;
            if (start != end) {
                lazyTree[nodeNum << 1] += value;
                lazyTree[nodeNum << 1 | 1] += value;
            }
            return;
        }

        int mid = (start + end) >> 1;
        update(start, mid, queryLeft, queryRight, value, nodeNum << 1);
        update(mid + 1, end, queryLeft, queryRight, value, nodeNum << 1 | 1);
        sumTree[nodeNum] = sumTree[nodeNum << 1] + sumTree[nodeNum << 1 | 1];
    }

    private long query(int start, int end, int queryLeft, int queryRight, int nodeNum) {
        propagate(start, end, nodeNum);

        if (queryRight < start || end < queryLeft) {
            return 0;
        }

        if (queryLeft <= start && end <= queryRight) {
            return sumTree[nodeNum];
        }

        int mid = (start + end) >> 1;
        return query(start, mid, queryLeft, queryRight, nodeNum << 1)
                + query(mid + 1, end, queryLeft, queryRight, nodeNum << 1 | 1);
    }

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        area = new int[N + 1];
        values = new int[M + 1];
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            values[i] = value;
            if (a <= b) {
                for (int j = a; j <= b; j++) {
                    area[j] = i;
                }
            } else {
                for (int j = 1; j <= b; j++) {
                    area[j] = i;
                }
                for (int j = a; j <= N; j++) {
                    area[j] = i;
                }
            }
        }

        sumTree = new long[M * 4];
        lazyTree = new long[M * 4];
        build(1, M, 1);

        while (true) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (op == 0 && x == 0 && y == 0) {
                break;
            }

            x = area[x];
            y = area[y];

            if (op == 1) {
                long sum = 0L;
                if (x <= y) {
                    sum = query(1, M, x, y, 1);
                } else {
                    sum += query(1, M, 1, y, 1);
                    sum += query(1, M, x, M, 1);
                }
                sb.append(sum).append("\n");
            } else if (op == 2) {
                int z = Integer.parseInt(st.nextToken());
                if (x <= y) {
                    update(1, M, x, y, z, 1);
                } else {
                    update(1, M, 1, y, z, 1);
                    update(1, M, x, M, z, 1);
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
