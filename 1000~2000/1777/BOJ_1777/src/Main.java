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
    private int[] is;
    private int[] nodeTree;
    private int[] res;

    private int build(int start, int end, int nodeNum) {
        if (start == end) {
            return nodeTree[nodeNum] = 1;
        }

        int mid = (start + end) >> 1;
        return nodeTree[nodeNum] = build(start, mid, nodeNum * 2)
                + build(mid + 1, end, nodeNum * 2 + 1);
    }

    private int query(int start, int end, int cnt, int nodeNum) {
        if (start == end) {
            return start;
        }

        int mid = (start + end) >> 1;
        if (nodeTree[nodeNum * 2 + 1] > cnt) {
            return query(mid + 1, end, cnt, nodeNum * 2 + 1);
        }
        return query(start, mid, cnt - nodeTree[nodeNum * 2 + 1], nodeNum * 2);
    }

    private void update(int start, int end, int idx, int nodeNum) {
        if (start > idx || end < idx) {
            return;
        }

        nodeTree[nodeNum]--;

        if (start == end) {
            return;
        }

        int mid = (start + end) >> 1;
        update(start, mid, idx, nodeNum * 2);
        update(mid + 1, end, idx, nodeNum * 2 + 1);
    }

    private void solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        is = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            is[i] = Integer.parseInt(st.nextToken());
        }

        nodeTree = new int[N * 4];
        build(1, N, 1);

        res = new int[N + 1];
        for (int i = N; i >= 1; i--) {
            int idx = query(1, N, is[i], 1);
            res[idx] = i;
            update(1, N, idx, 1);
        }

        for (int i = 1; i <= N; i++) {
            sb.append(res[i]).append(" ");
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
